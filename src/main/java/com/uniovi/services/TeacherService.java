package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeacherService {

	private List<Teacher> teachers;

	@PostConstruct
	private void init() {
		Teacher t1 = new Teacher();
		t1.setName("Paco");
		t1.setSurname("García");
		t1.setDni("1");
		t1.setCategory("Profesor titular");

		Teacher t2 = new Teacher();
		t1.setName("Carmen");
		t1.setSurname("Polo");
		t1.setDni("2");
		t1.setCategory("Profesor contratado");

		this.teachers = new ArrayList<Teacher>();
		this.teachers.add(t1);
		this.teachers.add(t2);
	}

	public List<Teacher> getTeachers() {
		return this.teachers;
	}

	public Teacher getTeacher(String dni) {

		Teacher t = null;

		for (Teacher teacher : this.teachers) {
			if (teacher.getDni().equals(dni)) {
				t = teacher;
				break;
			}
		}
		return t;
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}

	public void deleteTeacher(String dni) {

		this.teachers.removeIf((t) -> t.getDni().equals(dni));
	}

}
