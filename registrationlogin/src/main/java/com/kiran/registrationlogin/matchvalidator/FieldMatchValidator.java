package com.kiran.registrationlogin.matchvalidator;

import org.springframework.beans.BeanWrapperImpl;

import com.kiran.registrationlogin.fieldmatch.FieldMatch;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator  implements ConstraintValidator<FieldMatch, Object> {
	 private String firstFieldName;
	 private String secondFieldName;
	 private String message;
	
	 public void initialize(final FieldMatch constraintAnnotation) {
	 firstFieldName = constraintAnnotation.first();
	 secondFieldName = constraintAnnotation.second();
	 message = constraintAnnotation.message();
	 }
	 @Override
	 public boolean isValid(final Object value, final ConstraintValidatorContext context) {
	 boolean valid = true;
	 try
	 {
	 final Object firstObj = new
	 BeanWrapperImpl(value).getPropertyValue(firstFieldName);
	 final Object secondObj = new
	 BeanWrapperImpl(value).getPropertyValue(secondFieldName);
	 valid = firstObj == null && secondObj == null || firstObj != null &&
	 firstObj.equals(secondObj);
	 }
	 catch (final Exception ignore)
	 {
		 // we can ignore
		 }
		 if (!valid){
		 context.buildConstraintViolationWithTemplate(message)
		 .addPropertyNode(firstFieldName)
		 .addConstraintViolation()
		 .disableDefaultConstraintViolation();
		 }
		 return valid;
		 }
	
		 

}
