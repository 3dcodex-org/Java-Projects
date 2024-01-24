package com.bankmanagement.bankmanagement.service.serviceClass;

import com.bankmanagement.bankmanagement.dao.persistentDao.AccountDao;
import com.bankmanagement.bankmanagement.model.Account;

public class AccountService {
    private final AccountDao accountDao;
    public AccountService(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    public Account addAccount(Account account){
        accountDao.add(account);
        return null;
    }
}
