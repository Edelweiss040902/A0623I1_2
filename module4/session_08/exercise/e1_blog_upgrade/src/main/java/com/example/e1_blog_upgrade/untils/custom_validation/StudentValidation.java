package com.example.e1_blog_upgrade.untils.custom_validation;

import com.example.e1_blog_upgrade.model.Blog;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Blog student = (Blog) target;
        if(!student.getBlogTitle().matches("^[a-z ]{4,100}$")) {
            errors.rejectValue("nameStudent", "", "Ngày kết thúc không ");
        }


    }
}
