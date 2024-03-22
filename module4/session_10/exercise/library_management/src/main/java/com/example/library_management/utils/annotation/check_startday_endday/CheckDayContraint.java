package com.example.library_management.utils.annotation.check_startday_endday;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckDayValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDayContraint {
    String message() default "ngày kết thúc không được trước ngày bắt đầu";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
