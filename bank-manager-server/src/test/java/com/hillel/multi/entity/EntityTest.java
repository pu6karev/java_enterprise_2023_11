package com.hillel.multi.entity;

import com.hillel.model.AccountDTO;
import com.hillel.model.CustomerDTO;
import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.service.AccountEntityService;
import com.hillel.multi.service.CustomerEntityService;
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
        CustomerDTO customerDTO = new CustomerDTO("Tim Burton", "burtonTim@gmail.com");
        CustomerEntity customerEntity = customerService.createCustomer(customerDTO);
        //CustomerEntity customerEntity = CustomerMapper.INSTANCE.toEntity(createdCustomerDTO);

        AccountDTO accountDTO = new AccountDTO("UA9876543210123456", 200, "GBP");
        AccountEntity accountEntity = accountService.createAccount(customerEntity.getCustomerId(), accountDTO);
        //AccountEntity accountEntity = AccountMapper.INSTANCE.toEntity(createdAccountDTO);

        // get data from database
        CustomerEntity retrievedCustomer = customerService.getCustomerById(customerEntity.getCustomerId());
        assertEquals("Tim Burton", retrievedCustomer.getName());

        AccountEntity retrievedAccount = accountService.getAccountById(accountEntity.getAccountId());
        assertEquals(200, retrievedAccount.getBalance());
        assertEquals("GBP", retrievedAccount.getCurrency());
        assertEquals("Tim Burton", accountEntity.getOwner().getName());
    }
}
