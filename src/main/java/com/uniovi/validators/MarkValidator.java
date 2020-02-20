package com.uniovi.validators;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;

@Controller
public class MarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
		if (mark.getScore() < 0 || mark.getScore()> 10) {
			errors.rejectValue("score", "Error.mark.score.length");
		}
		
		if(mark.getDescription().length() < 20){
			errors.rejectValue("description", "Error.mark.description.length");
		}

	}
}
