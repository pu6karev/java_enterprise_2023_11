package com.hillel.multi.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = ValidEmailDomainValidator.class)
@Target({CONSTRUCTOR, METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailDomain {

    String message() default "Email domain must not be .ru";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}