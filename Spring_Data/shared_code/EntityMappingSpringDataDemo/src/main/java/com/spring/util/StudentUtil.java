package com.spring.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.spring.entity.many_to_many.CourseEntity;
import com.spring.entity.many_to_many.StudentEntity;
import com.spring.json.Course;
import com.spring.json.Student;

public class StudentUtil {

	public static Course convertCourseEntityIntoCourse(CourseEntity courseEntity) {
		return new Course(courseEntity.getCourseId(), courseEntity.getCourseName());
	}
	
	public static CourseEntity convertCourseIntoCourseEntity(Course course) {
		return new CourseEntity(course.getCourseName());
	}
	
	public static Student convertStudentEntityIntoStudent(StudentEntity studentEntity) {
		Set<CourseEntity> courseEntities = studentEntity.getCourses();
		Set<Course> courses = new HashSet<Course>();
		Student student = new Student(studentEntity.getStudentName());
		for(CourseEntity courseEntity: courseEntities)
			courses.add(convertCourseEntityIntoCourse(courseEntity));
		student.setStudentId(studentEntity.getStudentId());
		student.setCourses(courses);
		return student;
	}

	public static StudentEntity convertStudentIntoStudentEntity(Student student) {
		StudentEntity studentEntity = new StudentEntity(student.getStudentName());
		Set<StudentEntity> studentEntities = new HashSet<StudentEntity>();
		studentEntities.add(studentEntity);
		Set<Course> courses = student.getCourses();
		Set<CourseEntity> courseEntities = new HashSet<CourseEntity>();
		for(Course course: courses)
			courseEntities.add(convertCourseIntoCourseEntity(course));
		studentEntity.setCourses(courseEntities);
		return studentEntity;
	}

	public static List<Student> convertStudentEntityListIntoStudentList(List<StudentEntity> studentEntityList) {
		List<Student> students = new ArrayList<Student>();
		for(StudentEntity studentEntity: studentEntityList) {
			students.add(convertStudentEntityIntoStudent(studentEntity));
		}
		return students;
	}
}
