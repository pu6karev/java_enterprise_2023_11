package com.hillel.controller;

import com.hillel.api.AccountsApi;
import com.hillel.model.Account;
import com.hillel.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController implements AccountsApi {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<Account> createAccount(Integer id, @Valid @RequestBody Account account) {
        Account newAccount = accountService.createAccount(id, account);
        return ResponseEntity.status(201).body(newAccount);
    }


    @Override
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<Account> getAccount(Integer accountId) {
        Account account = accountService.getAccountById(accountId);
        return ResponseEntity.ok(account);
    }

    @Override
    public ResponseEntity<List<Account>> getAccountsByCustomer(Integer id) {
        List<Account> accounts = accountService.getAccountsByCustomer(id);
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<Account> updateAccount(Integer accountId, Account account) {
        Account updatedAccount = accountService.updateAccount(accountId, account);
        return ResponseEntity.ok(updatedAccount);
    }


    @Override
    public ResponseEntity<Void> deleteAccount(Integer accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
