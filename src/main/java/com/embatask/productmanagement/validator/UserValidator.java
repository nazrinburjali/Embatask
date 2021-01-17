package com.embatask.productmanagement.validator;
import com.embatask.productmanagement.domain.User;
import com.embatask.productmanagement.repository.UserRepository;
import com.embatask.productmanagement.service.UserService;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String regexAz = "^[a-zA-ZıIiİöÖüÜəƏçÇşŞğĞ]+$";
        String regexNumbers = "^[0-9]*$";
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "user.name.empty");
        if (!errors.hasFieldErrors("userName")) {
            if (!GenericValidator.isInRange(user.getUserName().length(), 3, 100)) {
                errors.rejectValue("userName", "user.name.length");
            } else if (!GenericValidator.matchRegexp(user.getUserName(), regexAz)) {
                errors.rejectValue("userName", "user.name.invalid");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userSurname", "user.surname.empty");
        if (!errors.hasFieldErrors("userSurname")) {
            if (!GenericValidator.isInRange(user.getUserSurname().length(), 3, 100)) {
                errors.rejectValue("userSurname", "user.surname.length");
            } else if (!GenericValidator.matchRegexp(user.getUserSurname(), regexAz)) {
                errors.rejectValue("userSurname", "user.surname.invalid");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPhone", "user.phone.empty");
        if (!errors.hasFieldErrors("userPhone")) {
            if (!GenericValidator.isInRange(user.getUserPhone().length(), 7, 35)) {
                errors.rejectValue("userPhone", "user.phone.length");
            } else if (!GenericValidator.matchRegexp(user.getUserPhone(), regexNumbers)) {
                errors.rejectValue("userPhone", "user.phone.invalid");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "user.email.empty");
        if (!errors.hasFieldErrors("userEmail")) {
            if (!GenericValidator.isEmail(user.getUserEmail())) {
                errors.rejectValue("userEmail", "user.email.invalid");
            }else if (userService.checkDuplicate(user.getUserEmail())){
                errors.rejectValue("userEmail", "user.email.duplicate");
            }
                  }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "user.password.empty");
        if (!errors.hasFieldErrors("userPassword")) {
            if ((!GenericValidator.isInRange(user.getUserPassword().length(), 8, 150))) {
                errors.rejectValue("userPassword", "user.password.length");
            }
        }


    }
}
