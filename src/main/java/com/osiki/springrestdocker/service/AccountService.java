package com.osiki.springrestdocker.service;

import com.osiki.springrestdocker.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAllAccount();
}
