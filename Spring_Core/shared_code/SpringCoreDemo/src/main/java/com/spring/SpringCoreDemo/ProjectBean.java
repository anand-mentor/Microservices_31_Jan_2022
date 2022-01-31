package com.spring.SpringCoreDemo;

public class ProjectBean {

	private String name;
	private String department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String toString() {
		return "Project: " + name + " - " + department;
	}
}
