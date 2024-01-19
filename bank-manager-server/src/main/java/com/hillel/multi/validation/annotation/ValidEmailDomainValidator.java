package com.hillel.multi.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailDomainValidator implements ConstraintValidator<ValidEmailDomain, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !email.endsWith(".ru");
    }
}