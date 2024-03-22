package com.example.library_management.utils.annotation.phone_number;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneContraint,String> {
    @Override
    public void initialize(PhoneContraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^(0|\\+84)[-.\\s]?([1-9][0-9]{8})$");
    }
}
