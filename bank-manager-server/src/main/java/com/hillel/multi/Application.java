package com.hillel.multi;

import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.service.AccountEntityService;
import com.hillel.multi.persistent.service.CustomerEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello for Maven");

        var context = SpringApplication.run(Application.class, args);
        CustomerEntityService customerService = context.getBean(CustomerEntityService.class);

        CustomerEntity customer1 = new CustomerEntity("Tim Burton", "burton@gmail.com");
        CustomerEntity customer2 = new CustomerEntity("Rob Snider", "snider1968@yahoo.us");

        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);

        List<CustomerEntity> customers = customerService.getAllCustomers();
        for (CustomerEntity customer : customers) {
            System.out.println(customer.getName());
        }

        AccountEntityService accountService = context.getBean(AccountEntityService.class);

        AccountEntity account1 = new AccountEntity("UA1234567890123456", 100, "USD");
        AccountEntity account2 = new AccountEntity("UA1234567890123457", 50, "EUR");

        accountService.createAccount(customer1.getCustomerId(),  account1);
        accountService.createAccount(customer2.getCustomerId(),  account2);

        List<AccountEntity> accounts = accountService.getAllAccounts();
        for (AccountEntity account : accounts) {
            System.out.println(account.getIban());
            System.out.println(account.getBalance());
            System.out.println(account.getCurrency());
            System.out.println(account.getOwner().getName());
        }
    }
}

