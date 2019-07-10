package com.liyan.test;

import com.liyan.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class AccountTest {

    @Test
    public void find() throws Exception{
        InputStream config = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = factory.openSession();
        Account accIn=new Account();
        accIn.setAccno("1");
        accIn.setName("张三");
        Account accInSelect = sqlSession.selectOne("mapper.AccountMapper.findAccName", accIn);
        System.out.println(accInSelect);
    }
}
