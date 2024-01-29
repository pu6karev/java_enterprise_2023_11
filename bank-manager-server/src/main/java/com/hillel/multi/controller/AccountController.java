package com.hillel.multi.controller;

import com.hillel.api.AccountsApi;
import com.hillel.model.AccountDTO;
import com.hillel.multi.configuration.exception.BankManagerDatabaseAccessException;
import com.hillel.multi.configuration.exception.BankManagerNotFoundException;
import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.service.AccountEntityService;
import com.hillel.multi.service.mapper.AccountMapper;
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

    private final AccountEntityService accountService;

    public AccountController(AccountEntityService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<AccountDTO> createAccount(Integer id, @Valid @RequestBody AccountDTO accountDTO) {
        AccountEntity createdAccount = accountService.createAccount(id, accountDTO);
        AccountDTO newAccountDTO = AccountMapper.INSTANCE.toDTO(createdAccount);
        newAccountDTO.setCustomerId(id);
        return ResponseEntity.status(201).body(newAccountDTO);
    }


    @Override
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        List<AccountEntity> accountsEntity = accountService.getAllAccounts();
        List<AccountDTO> accountsDTO = AccountMapper.INSTANCE.toDTOList(accountsEntity);
        return ResponseEntity.ok(accountsDTO);
    }

    @ExceptionHandler(BankManagerNotFoundException.class)
    public ResponseEntity<String> handleBankManagerException(BankManagerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @Override
    public ResponseEntity<AccountDTO> getAccount(Integer accountId) throws BankManagerNotFoundException {
        try {
            AccountEntity accountEntity = accountService.getAccountById(accountId);
            AccountDTO accountDTO = AccountMapper.INSTANCE.toDTO(accountEntity);
            if (accountDTO == null) {
                throw new BankManagerNotFoundException("Account not found, accountId=" + accountId);
            }
            return ResponseEntity.ok(accountDTO);
        } catch (BankManagerDatabaseAccessException e) {
            // Catch an exception that can be thrown when there is no access to the database
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new AccountDTO("errorIBAN", 0, "errorCurrency"));
        }
    }

    @Override
    public ResponseEntity<List<AccountDTO>> getAccountsByCustomer(Integer id) {
        List<AccountEntity> accountsEntity = accountService.getAccountsByCustomer(id);
        List<AccountDTO> accounts = AccountMapper.INSTANCE.toDTOList(accountsEntity);
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(Integer accountId, AccountDTO accountDTO) {
        AccountEntity updatedAccount = accountService.updateAccount(accountId, accountDTO);
        AccountDTO updatedAccountDTO = AccountMapper.INSTANCE.toDTO(updatedAccount);
        return ResponseEntity.ok(updatedAccountDTO);
    }


    @Override
    public ResponseEntity<Void> deleteAccount(Integer accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
