package com.example.e1_blog_upgrade.untils.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DoBValidator.class)
//Nếu muốn tạo annotation cho class thì dùng type
//Tạo annotation cho thuộc tính thì dùng field
//Tạo annotation cho phương thức thì dùng method
@Target({ElementType.TYPE_USE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoBConstraint {
    String message() default "bạn không đủ tuổi (phải trên hoặc bằng 18 tuổi)";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
