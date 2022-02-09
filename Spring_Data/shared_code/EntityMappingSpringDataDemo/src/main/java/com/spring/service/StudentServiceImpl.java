package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.many_to_many.StudentEntity;
import com.spring.json.Student;
import com.spring.repo.StudentRepo;
import com.spring.util.StudentUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student createStudent(Student student) {
		StudentEntity studentEntity = StudentUtil.convertStudentIntoStudentEntity(student);
		studentEntity = studentRepo.save(studentEntity);
		return StudentUtil.convertStudentEntityIntoStudent(studentEntity);
	}

	@Override
	public List<Student> getAllStudents() {
		return StudentUtil.convertStudentEntityListIntoStudentList(studentRepo.findAll());
	}

}
