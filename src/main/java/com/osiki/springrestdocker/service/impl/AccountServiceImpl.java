package com.osiki.springrestdocker.service.impl;

import com.osiki.springrestdocker.model.Account;
import com.osiki.springrestdocker.model.Role;
import com.osiki.springrestdocker.repository.AccountRepository;
import com.osiki.springrestdocker.repository.RoleRepository;
import com.osiki.springrestdocker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    @Override
    public Account createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);

        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
}
