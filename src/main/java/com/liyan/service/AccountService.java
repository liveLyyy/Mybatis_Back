package com.liyan.service;

import com.liyan.pojo.Account;

public interface AccountService {
    //账号和密码不匹配状态码
    int ACCOUNT_PASSWORD_NOT_MATCH=1;
    //余额不足状态码
    int ACCOUNT_BALANCE_NOT_ENOUGH=2;
    //账户和姓名不匹配状态码
    int ACCOUNT_NAME_NOT_MATCH=3;
    //转账失败状态码
    int ERROR=4;
    //转账成功状态码
    int SUCCESS=5;
    //accIn收款账号，accOut转账账号
    int transfer(Account accIn,Account accOut) throws Exception;



}
