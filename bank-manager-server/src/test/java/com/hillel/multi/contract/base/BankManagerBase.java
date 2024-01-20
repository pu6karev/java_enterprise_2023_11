package com.hillel.multi.contract.base;


import com.hillel.model.Account;
import com.hillel.multi.configuration.exception.BankManagerDatabaseAccessException;
import com.hillel.multi.controller.AccountController;
import com.hillel.multi.service.AccountService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc
public class BankManagerBase {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AccountService accountService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.webAppContextSetup(context);

        // positive
        Account testAccount1 = new Account(1, "UA12345678901234567890123456", 100, "UAH", 1);
        Mockito.doReturn(testAccount1).when(accountService).getAccountById(1);
        Mockito.doReturn(testAccount1).when(accountService).createAccount(1, testAccount1);

        // negative, when invalid accountId
        Mockito.doReturn(null).when(accountService).getAccountById(999);
        // negative, when no db access
        Mockito.doThrow(new BankManagerDatabaseAccessException("Database error")).when(accountService).getAccountById(2);
    }
}
