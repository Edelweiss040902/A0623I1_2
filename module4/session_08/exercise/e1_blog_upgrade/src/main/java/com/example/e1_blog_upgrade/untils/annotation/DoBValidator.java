package com.example.e1_blog_upgrade.untils.annotation;

import com.example.e1_blog_upgrade.repository.IInforRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

public class DoBValidator implements ConstraintValidator<DoBConstraint, LocalDate> {

    @Autowired
    private IInforRepository inforRepository;
    @Override
    public void initialize(DoBConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return Period.between(value, LocalDate.now()).getYears() >= 18;
    }
}
