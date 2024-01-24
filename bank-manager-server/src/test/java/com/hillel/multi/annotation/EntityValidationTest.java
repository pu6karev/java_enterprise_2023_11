package com.hillel.multi.annotation;

import com.hillel.multi.persistent.entity.AccountEntity;
import com.hillel.multi.persistent.entity.CustomerEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityValidationTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        Locale.setDefault(Locale.ENGLISH);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidEmailDomain() {
        // customer with correct email
        CustomerEntity customerCorrect = new CustomerEntity("Mike Smith", "smith@gmail.com");
        // customer with prohibited email
        CustomerEntity customerWrong = new CustomerEntity("Peter Ivanov", "petIvanov@mail.ru");

        Set<ConstraintViolation<CustomerEntity>> violationsCorrect = validator.validate(customerCorrect);
        Set<ConstraintViolation<CustomerEntity>> violationsWrong = validator.validate(customerWrong);

        assertEquals(0, violationsCorrect.size());
        assertEquals(1, violationsWrong.size());
        assertEquals("Email domain must not be .ru", violationsWrong.iterator().next().getMessage());
    }

    @Test
    public void testInvalidCurrency() {
        AccountEntity account = new AccountEntity("DE12345678901234567890", 1000, "usd");
        Set<ConstraintViolation<AccountEntity>> violations = validator.validate(account);

        assertEquals(1, violations.size());
        assertEquals("Currency must be three uppercase letters", violations.iterator().next().getMessage());
    }
}