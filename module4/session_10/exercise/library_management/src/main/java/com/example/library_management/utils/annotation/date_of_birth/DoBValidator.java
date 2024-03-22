package com.example.library_management.utils.annotation.date_of_birth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

public class DoBValidator implements ConstraintValidator<DoBConstraint, LocalDate> {

    @Override
    public void initialize(DoBConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return Period.between(value, LocalDate.now()).getYears() >= 18;
    }
}
