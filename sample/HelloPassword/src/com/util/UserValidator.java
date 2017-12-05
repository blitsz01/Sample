package com.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bean.User;

public class UserValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
				"username", "required.username", "Field username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
				"password", "required.password", "Field password is required.");
	}

}
