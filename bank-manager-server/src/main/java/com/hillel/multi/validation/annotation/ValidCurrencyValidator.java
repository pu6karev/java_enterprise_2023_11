package com.hillel.multi.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCurrencyValidator implements ConstraintValidator<ValidCurrency, String> {

    @Override
    public boolean isValid(String currency, ConstraintValidatorContext context) {
        return currency.length() == 3 && currency.matches("[A-Z]{3}");
    }
}