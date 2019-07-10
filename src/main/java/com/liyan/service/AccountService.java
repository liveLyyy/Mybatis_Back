package com.liyan.service;

import com.liyan.pojo.Account;

public interface AccountService {
    int transfer(Account accIn,Account accOut);
}
