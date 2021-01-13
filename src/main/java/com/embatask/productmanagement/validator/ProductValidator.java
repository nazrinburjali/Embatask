package com.embatask.productmanagement.validator;

import com.embatask.productmanagement.domain.Product;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Product.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "product.name.empty");

        if (!errors.hasFieldErrors("productName")){
            if (!GenericValidator.isInRange(product.getProductName().length(),3, 150)){
                errors.rejectValue("productName", "product.name.length");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "product.category.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productDescription", "product.description.empty");

    }
}
