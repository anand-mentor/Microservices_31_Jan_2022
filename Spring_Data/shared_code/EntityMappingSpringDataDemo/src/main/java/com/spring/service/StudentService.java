package com.spring.service;

import java.util.List;

import com.spring.json.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getAllStudents();
}
