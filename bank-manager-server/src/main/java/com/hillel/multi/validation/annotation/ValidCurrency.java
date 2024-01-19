package com.hillel.multi.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidCurrencyValidator.class)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrency {

    String message() default "Currency must be three uppercase letters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
