package com.hillel.multi.contract.base;

import com.hillel.multi.controller.AccountController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc
public class BankManagerBase {

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.webAppContextSetup(context);
    }
}
