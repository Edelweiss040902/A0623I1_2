package com.example.library_management.utils.annotation.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint,String> {
    @Override
    public void initialize(PasswordConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=|{}[\\\\]:;<>?,./])(?=.*[a-z]).{8,}$");
    }
}
