package com.bankmanagement.bankmanagement.controller;

import com.bankmanagement.bankmanagement.dao.persistentDao.AccountDao;
import com.bankmanagement.bankmanagement.model.Account;
import com.bankmanagement.bankmanagement.service.serviceClass.AccountService;

public class AccountController {
    private final AccountService accountService;
    private final AccountDao accountDao = new AccountDao();
    public AccountController(){
        accountService = new AccountService(accountDao);
        Account account = new Account();
        accountService.addAccount(account);
    }
}
