package com.hillel.multi.persistent.service;

import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.repository.AccountEntityRepository;
import com.hillel.multi.persistent.repository.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountEntityService {

    private final AccountEntityRepository accountRepository;
    private final CustomerEntityRepository customerRepository;

    @Autowired
    public AccountEntityService(AccountEntityRepository accountRepository, CustomerEntityRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public List<AccountEntity> getAllAccounts(){
        return  accountRepository.findAll();
    }

    public List<AccountEntity> getAccountsByCustomer(Integer customerId){
        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow();
        return customer.getAccountEntityList().stream()
               .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public AccountEntity getAccountById(Integer accountId){
        return accountRepository.getReferenceById(accountId);
    }

    public AccountEntity createAccount(Integer customerId, AccountEntity account){
        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow();
        account.setOwner(customer);
        return accountRepository.save(account);
    }

    public AccountEntity updateAccount(Integer accountId, AccountEntity accountUpdated){
        var accountToUpdate = accountRepository.findById(accountId).orElseThrow();
        accountToUpdate.setIban(accountUpdated.getIban());
        accountToUpdate.setBalance(accountUpdated.getBalance());
        accountToUpdate.setCurrency(accountUpdated.getCurrency());

        return accountRepository.save(accountToUpdate);
    }

    public void deleteAccount(Integer accountId){
        accountRepository.deleteById(accountId);
    }
}
