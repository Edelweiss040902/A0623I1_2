package com.example.library_management.utils.annotation.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface PasswordConstraint {
    String message() default "password phải có ít nhất một kí tự đặt biệt, ít nất một kí tự in hoa, ex:User@123 ";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
