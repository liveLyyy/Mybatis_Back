package com.liyan.test;

import com.liyan.file.PageInfo;
import com.liyan.pojo.Log;
import com.liyan.service.Impl.LogServiceImpl;

import org.junit.Test;

import java.io.InputStream;

public class AccountTest {

    LogServiceImpl logService=new LogServiceImpl();
    @Test
    public void find() throws Exception{

        Log log=new Log();

        PageInfo pageInfo=logService.findpaeg(2,1);
        System.out.println(pageInfo.toString());

    }
}
