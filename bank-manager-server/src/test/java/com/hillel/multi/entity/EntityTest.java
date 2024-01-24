package com.hillel.multi.entity;

import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.persistent.service.AccountEntityService;
import com.hillel.multi.persistent.service.CustomerEntityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class EntityTest {
    @Autowired
    private CustomerEntityService customerService;

    @Autowired
    private AccountEntityService accountService;

    @Test
    public void testApplication() {
        CustomerEntity customer1 = new CustomerEntity("Tim Burton", "burtonTim@gmail.com");
        customerService.createCustomer(customer1);

        AccountEntity account1 = new AccountEntity("UA9876543210123456", 200, "GBP");
        accountService.createAccount(customer1.getCustomerId(), account1);

        // get data from database
        CustomerEntity retrievedCustomer = customerService.getCustomerById(customer1.getCustomerId());
        assertEquals("Tim Burton", retrievedCustomer.getName());

        AccountEntity retrievedAccount = accountService.getAccountById(account1.getAccountId());
        assertEquals(200, retrievedAccount.getBalance());
        assertEquals("GBP", retrievedAccount.getCurrency());
        assertEquals("Tim Burton", retrievedAccount.getOwner().getName());
    }
}
