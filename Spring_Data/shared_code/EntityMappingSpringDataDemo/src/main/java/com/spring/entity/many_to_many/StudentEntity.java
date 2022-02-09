package com.spring.entity.many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	private long studentId;
	private String studentName;
	
	private Set<CourseEntity> courses = new HashSet<CourseEntity>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	public StudentEntity() {
	}

	public StudentEntity(String studentName) {
		this.studentName = studentName;
	}

	public StudentEntity(String studentName, Set<CourseEntity> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", 
				joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	public Set<CourseEntity> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}

}




