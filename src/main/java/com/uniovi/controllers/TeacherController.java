package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value="/teacher/add",method=RequestMethod.POST )
	public String add(@RequestParam String dni, @RequestParam String name, @RequestParam String surname,
			@RequestParam String category) {
		Teacher t = new Teacher();
		t.setDni(dni);
		t.setName(name);
		t.setSurname(surname);
		t.setCategory(category);
		this.teacherService.addTeacher(t);
		return "Profesor añadido";
	}
	
	@RequestMapping("/teacher/delete/{dni}")
	public String delete(@PathVariable String dni) {
		this.teacherService.deleteTeacher(dni);
		return "Profesor borrado";
	}
	
	@RequestMapping("/teacher/details/{dni}")
	public String details(@PathVariable String dni) {
		return "profesor encontrado";
	}

	@RequestMapping(value="/teacher/edit",method=RequestMethod.POST )
	public String edit(@RequestParam String dni, @RequestParam String name, @RequestParam String surname,
			@RequestParam String category) {
		this.teacherService.deleteTeacher(dni);
		Teacher t = new Teacher();
		t.setDni(dni);
		t.setName(name);
		t.setSurname(surname);
		t.setCategory(category);
		this.teacherService.addTeacher(t);
		return "Profesor editado";
	}
}
