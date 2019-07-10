package com.liyan.service.Impl;

import com.liyan.pojo.Account;
import com.liyan.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class AccountServiceImpl implements AccountService {
    @Override
    public int transfer(Account accIn, Account accOut) throws Exception {

        InputStream config = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = factory.openSession();
        //判断账号和密码是否匹配
        Account accOutSelect = sqlSession.selectOne("mapper.AccountMapper.findAccPwd", accOut);
        if (accOutSelect != null) {
            if (accOutSelect.getBalance() >= accOut.getBalance()) {
                Account accInSelect = sqlSession.selectOne("mapper.AccountMapper.findAccName", accIn);
                if (accInSelect != null) {
                    accIn.setBalance(accOut.getBalance());
                    accOut.setBalance(-accOut.getBalance());
                    int index = sqlSession.update("mapper.AccountMapper.updaBalanByAccno", accOut);
                    index += sqlSession.update("mapper.AccountMapper.updaBalanByAccno", accIn);
                    if (index == 2) {
                        sqlSession.commit();
                        sqlSession.close();
                        //转账成功
                        return SUCCESS;
                    } else {
                        sqlSession.rollback();
                        sqlSession.close();
                        //转账失败
                        return ERROR;
                    }
                } else {
                    //账户和姓名不匹配
                    return ACCOUNT_NAME_NOT_MATCH;
                }
            } else {
                //余额不足
                return ACCOUNT_BALANCE_NOT_ENOUGH;
            }
        } else {
            //账号和密码不匹配
            return ACCOUNT_PASSWORD_NOT_MATCH;
        }
    }
}
