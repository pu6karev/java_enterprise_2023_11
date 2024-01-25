package com.hillel.multi.service;

import com.hillel.model.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public List<AccountDTO> getAllAccounts(){
        return  null;
    }

    public List<AccountDTO> getAccountsByCustomer(Integer customerId){
        return null;
    }

    public AccountDTO getAccountById(Integer accountId){
        return null;
    }

    public AccountDTO createAccount(Integer customerId, AccountDTO account){
        return null;
    }

    public AccountDTO updateAccount(Integer customerId, AccountDTO account){
        return null;
    }

    public boolean deleteAccount(Integer accountId){
        return false;
    }
}
