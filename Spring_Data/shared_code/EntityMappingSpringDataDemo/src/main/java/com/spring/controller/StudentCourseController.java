package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Student;
import com.spring.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapp")
public class StudentCourseController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/student", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping(value="/student", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Student createNewStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
}
