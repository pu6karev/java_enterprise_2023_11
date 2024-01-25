package com.hillel.multi.controller;

import com.hillel.api.AccountsApi;
import com.hillel.model.AccountDTO;
import com.hillel.multi.configuration.exception.BankManagerDatabaseAccessException;
import com.hillel.multi.configuration.exception.BankManagerNotFoundException;
import com.hillel.multi.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public ResponseEntity<AccountDTO> createAccount(Integer id, @Valid @RequestBody AccountDTO account) {
        AccountDTO newAccount = accountService.createAccount(id, account);
        return ResponseEntity.status(201).body(newAccount);
    }


    @Override
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @ExceptionHandler(BankManagerNotFoundException.class)
    public ResponseEntity<String> handleBankManagerException(BankManagerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @Override
    public ResponseEntity<AccountDTO> getAccount(Integer accountId) throws BankManagerNotFoundException {
        try {
            AccountDTO account = accountService.getAccountById(accountId);
            if (account == null) {
                throw new BankManagerNotFoundException("Account not found, accountId=" + accountId);
            }
            return ResponseEntity.ok(account);
        } catch (BankManagerDatabaseAccessException e) {
            // Catch an exception that can be thrown when there is no access to the database
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new AccountDTO("errorIBAN", 0, "errorCurrency", 0));
        }
    }

    @Override
    public ResponseEntity<List<AccountDTO>> getAccountsByCustomer(Integer id) {
        List<AccountDTO> accounts = accountService.getAccountsByCustomer(id);
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(Integer accountId, AccountDTO account) {
        AccountDTO updatedAccount = accountService.updateAccount(accountId, account);
        return ResponseEntity.ok(updatedAccount);
    }


    @Override
    public ResponseEntity<Void> deleteAccount(Integer accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
