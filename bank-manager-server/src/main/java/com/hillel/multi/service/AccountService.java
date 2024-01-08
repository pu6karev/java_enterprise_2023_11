package com.hillel.multi.service;

import com.hillel.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    public List<Account> getAllAccounts(){
        return  null;
    }

    public List<Account> getAccountsByCustomer(Integer customerId){
        return null;
    }

    public Account getAccountById(Integer accountId){
        return null;
    }

    public Account createAccount(Integer customerId, Account account){
        return null;
    }

    public Account updateAccount(Integer customerId, Account account){
        return null;
    }

    public boolean deleteAccount(Integer accountId){
        return false;
    }
}
