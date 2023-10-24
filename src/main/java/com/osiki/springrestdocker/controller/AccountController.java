package com.osiki.springrestdocker.controller;

import com.osiki.springrestdocker.model.Account;
import com.osiki.springrestdocker.model.Employee;
import com.osiki.springrestdocker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.osiki.springrestdocker.controller.EmployeeController.getLocation;

@RequestMapping("/api/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);

        return ResponseEntity.created(getLocation((long) newAccount.getId().intValue()))
                .body(newAccount);

    }

}
