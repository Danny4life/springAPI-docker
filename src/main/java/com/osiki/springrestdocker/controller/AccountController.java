package com.osiki.springrestdocker.controller;

import com.osiki.springrestdocker.model.Account;
import com.osiki.springrestdocker.model.Employee;
import com.osiki.springrestdocker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }

}
