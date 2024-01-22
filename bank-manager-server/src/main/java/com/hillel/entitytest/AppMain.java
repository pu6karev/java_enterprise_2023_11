package com.hillel.entitytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        var context = SpringApplication.run(AppMain.class, args);
        CustomerEntService customerService = context.getBean(CustomerEntService.class);

        CustomerEnt customer1 = new CustomerEnt("Tim Burton", "burton@gmail.com");
        CustomerEnt customer2 = new CustomerEnt("Rob Snider", "snider1968@yahoo.us");

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);

        List<CustomerEnt> customers = customerService.getAllCustomers();
        for (CustomerEnt customer : customers) {
            System.out.println(customer.getName());
        }

        AccountEntService accountService = context.getBean(AccountEntService.class);

        AccountEnt account1 = new AccountEnt("UA1234567890123456", 100, "USD");
        AccountEnt account2 = new AccountEnt("UA1234567890123457", 50, "EUR");

        accountService.createAccount(customer1.getCustomerId(),  account1);
        accountService.createAccount(customer2.getCustomerId(),  account2);

        List<AccountEnt> accounts = accountService.getAllAccounts();
        for (AccountEnt account : accounts) {
            System.out.println(account.getIban());
            System.out.println(account.getBalance());
            System.out.println(account.getCurrency());
            System.out.println(account.getOwner().getName());
        }
    }
}