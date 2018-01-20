package com.ny.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.EscapedErrors;

public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "姓名必填");
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
//        Errors errors = new DirectFieldBindingResult(customer, "customer");
//        ValidationUtils.invokeValidator(new CustomerValidator(), customer,
//                errors);
//        System.out.println(errors);
        BeanWrapperImpl wrapper = new BeanWrapperImpl(customer);
        CustomNumberEditor editor = (CustomNumberEditor) wrapper.getDefaultEditor(CustomNumberEditor.class);
        System.out.println(editor.getAsText());

    }
}
