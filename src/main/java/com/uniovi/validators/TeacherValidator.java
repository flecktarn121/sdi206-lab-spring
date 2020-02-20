package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Teacher;
import com.uniovi.services.UsersService;

@Controller
public class TeacherValidator implements Validator {
	@Autowired
	private UsersService usersService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Teacher.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Teacher teacher = (Teacher) target;
		String dni = teacher.getDni();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (usersService.getUserByDni(dni) != null) {
			errors.rejectValue("dni", "Error.teacher.dni.duplicate");
		}
		
		if(dni.length() != 9) {
			errors.rejectValue("dni", "Error.teacher.dni.length");
		}
		
		String letter = dni.substring(dni.length() -1);
		if(!letter.chars().allMatch(Character::isLetter)) {
			errors.rejectValue("dni", "Error.teacher.dni.letter");
		}
	}

}
