package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;
import com.uniovi.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;

	public List<Teacher> getTeachers() {
		List<Teacher> teachers = new ArrayList<Teacher>();
		repository.findAll().forEach(teachers::add);
		return teachers;
	}

	public Teacher getTeacher(Long id) {
		return repository.findById(id).get();
	}

	public void addTeacher(Teacher teacher) {
		repository.save(teacher);
	}

	public void deleteTeacher(Long id) {

		repository.deleteById(id);
	}

}
