package com.hillel.multi.service;

import com.hillel.model.AccountDTO;
import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.repository.AccountEntityRepository;
import com.hillel.multi.persistent.repository.CustomerEntityRepository;
import com.hillel.multi.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return customer.getAccountEntityList();
    }

    public AccountEntity getAccountById(Integer accountId){
        return accountRepository.getReferenceById(accountId);
    }

    public AccountEntity createAccount(Integer customerId, AccountDTO accountDTO){
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();
        AccountEntity accountEntity = AccountMapper.INSTANCE.toEntity(accountDTO);
        accountEntity.setOwner(customerEntity);
        return accountRepository.save(accountEntity);
    }

    public AccountEntity updateAccount(Integer accountId, AccountDTO accountDTOUpdated){
        AccountEntity accountEntityToUpdate = accountRepository.findById(accountId).orElseThrow();

        accountEntityToUpdate.setIban(accountDTOUpdated.getIban());
        accountEntityToUpdate.setBalance(accountDTOUpdated.getBalance());
        accountEntityToUpdate.setCurrency(accountDTOUpdated.getCurrency());

        return accountRepository.save(accountEntityToUpdate);
    }

    public void deleteAccount(Integer accountId){
        accountRepository.deleteById(accountId);
    }
}
