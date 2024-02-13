package com.hillel.multi.contract.base;


import com.hillel.model.AccountDTO;
import com.hillel.multi.configuration.exception.BankManagerDatabaseAccessException;
import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import com.hillel.multi.service.AccountEntityService;
import com.hillel.multi.service.CustomerEntityService;
import com.hillel.multi.service.mapper.AccountMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class BankManagerBase {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AccountEntityService accountService;
    @MockBean
    private CustomerEntityService customerService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.webAppContextSetup(context);
         // --- create customer for account
        CustomerEntity customerEntity = new CustomerEntity("Tom Hart", "tom@gmail.com");
        customerEntity.setCustomerId(1);
         // --- create account
        AccountDTO accountDTO = new AccountDTO("UA12345678901234567890123456", 100, "UAH");
        AccountEntity accountEntity = AccountMapper.INSTANCE.toEntity(accountDTO);
        accountEntity.setOwner(customerEntity);

        Mockito.doReturn(accountEntity).when(accountService).createAccount(1, accountDTO);
        Mockito.doReturn(accountEntity).when(accountService).getAccountById(1);

        // negative, when invalid accountId
        Mockito.doReturn(null).when(accountService).getAccountById(999);
        // negative, when no db access
        Mockito.doThrow(new BankManagerDatabaseAccessException("Database error")).when(accountService).getAccountById(2);
    }
}
