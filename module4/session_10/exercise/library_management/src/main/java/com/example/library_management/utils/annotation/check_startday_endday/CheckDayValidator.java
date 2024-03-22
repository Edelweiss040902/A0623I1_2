package com.example.library_management.utils.annotation.check_startday_endday;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class CheckDayValidator implements ConstraintValidator<CheckDayContraint,LocalDate> {

    @Override
    public void initialize(CheckDayContraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return false;
    }
}
