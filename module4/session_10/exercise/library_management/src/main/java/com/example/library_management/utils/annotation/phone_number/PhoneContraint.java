package com.example.library_management.utils.annotation.phone_number;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneContraint {
    String message() default "phone không đúng định dạng ex:0905156093 ";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
