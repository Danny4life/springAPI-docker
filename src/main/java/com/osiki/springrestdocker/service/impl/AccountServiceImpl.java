package com.osiki.springrestdocker.service.impl;

import com.osiki.springrestdocker.model.Account;
import com.osiki.springrestdocker.repository.AccountRepository;
import com.osiki.springrestdocker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }

    @Override
    public List<Account> getAllAccount() {
        return null;
    }
}
