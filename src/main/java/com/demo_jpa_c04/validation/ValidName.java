package com.demo_jpa_c04.validation;


import com.demo_jpa_c04.model.Product;
import com.demo_jpa_c04.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ValidName implements Validator {
    @Autowired
    IProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Product productCheckName = productService.findByName(product.getName());
        if (productCheckName != null){
            errors.rejectValue("name", "", "name da ton tai");
        }

    }
}
