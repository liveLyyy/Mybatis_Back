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
    public int transfer(Account accIn, Account accOut) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
            SqlSession sqlSession = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
