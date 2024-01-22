package com.hillel.entitytest;

import com.hillel.entitytest.repository.AccountEntRepository;
import com.hillel.entitytest.repository.CustomerEntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountEntService {

    private final AccountEntRepository accountRepository;
    private final CustomerEntRepository customerRepository;

    @Autowired
    public AccountEntService(AccountEntRepository accountRepository, CustomerEntRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public List<AccountEnt> getAllAccounts(){
        return  accountRepository.findAll();
    }

    public List<AccountEnt> getAccountsByCustomer(Integer customerId){
        CustomerEnt customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getAccountEntityList().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public AccountEnt getAccountById(Integer accountId){
        return accountRepository.getReferenceById(accountId);
    }

    public AccountEnt createAccount(Integer customerId, AccountEnt account){
        CustomerEnt customer = customerRepository.findById(customerId).orElseThrow();
        account.setOwner(customer);
        return accountRepository.save(account);
    }

    public void updateAccount(Integer accountId, AccountEnt accountUpdated){
        AccountEnt accountToUpdate = accountRepository.findById(accountId).orElseThrow();
        accountToUpdate.setIban(accountUpdated.getIban());
        accountToUpdate.setBalance(accountUpdated.getBalance());
        accountToUpdate.setCurrency(accountUpdated.getCurrency());

        accountRepository.save(accountToUpdate);
    }

    public void deleteAccount(Integer accountId){
        accountRepository.deleteById(accountId);
    }}
