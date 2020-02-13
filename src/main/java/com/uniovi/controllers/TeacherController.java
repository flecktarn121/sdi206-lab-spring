package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value="/teacher/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "redirect:/teacher/list";
	}

	@RequestMapping(value="/teacher/add")
	public String getTeacher() {
		return "teacher/add";
	}

	@RequestMapping("/teacher/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.teacherService.deleteTeacher(id);
		return "redirect:/teacher/list";
	}

	@RequestMapping("/teacher/details/{id}")
	public String details(@PathVariable Long id) {
		return teacherService.getTeacher(id).toString();
		//return "profesor encontrado";
	}

	@RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, @PathVariable Long id, @ModelAttribute Teacher teacher) {
		teacher.setId(id);
		teacherService.addTeacher(teacher);
		return "Profesor editado";
	}
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", teacherService.getTeachers());
		return "teacher/list";
	}
}
