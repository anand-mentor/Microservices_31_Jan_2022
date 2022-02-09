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
@Table(name="COURSE")
public class CourseEntity {
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
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
		CourseEntity other = (CourseEntity) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}
*/
	private long courseId;
	private String courseName;
	private Set<StudentEntity> students = new HashSet<StudentEntity>();

	public CourseEntity() {}
	
	public CourseEntity(String courseName) {
		this.courseName = courseName;
	}

	public CourseEntity(String courseName, Set<StudentEntity> students) {
		this.courseName = courseName;
		this.students = students;
	}

	@Id
	@GeneratedValue
	@Column(name="COURSE_ID")
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", 
				joinColumns = { @JoinColumn(name = "COURSE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID") })
	public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}

}