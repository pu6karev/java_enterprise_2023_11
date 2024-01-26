package com.hillel.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello for Maven");

        var context = SpringApplication.run(Application.class, args);
//        CustomerEntityService customerService = context.getBean(CustomerEntityService.class);
//
//        CustomerEntity customerEntity1 = customerService.createCustomer(new CustomerDTO("Tim Burton", "burton@gmail.com"));
//        CustomerEntity customerEntity2 = customerService.createCustomer(new CustomerDTO("Rob Snider", "snider1968@yahoo.us"));
//
//        System.out.println("customerEntity1=" + customerEntity1.getName() + " id=" + customerEntity1.getCustomerId());
//        System.out.println("customerEntity2=" + customerEntity2.getName() + " id=" + customerEntity2.getCustomerId());
//
//
//        AccountEntityService accountService = context.getBean(AccountEntityService.class);
//
//        AccountDTO account1 = new AccountDTO("UA1234567890123456", 100, "USD");
//        AccountDTO account2 = new AccountDTO("UA1234567890123457", 50, "EUR");
//
//        accountService.createAccount(customerEntity1.getCustomerId(),  account1);
//        accountService.createAccount(customerEntity2.getCustomerId(),  account2);
//
//        List<AccountEntity> accounts = accountService.getAllAccounts();
//        for (AccountEntity account : accounts) {
//            System.out.println(account.getAccountId());
//            System.out.println(account.getIban());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCurrency());
//            System.out.println(account.getOwner().getName());
//        }
    }
}

