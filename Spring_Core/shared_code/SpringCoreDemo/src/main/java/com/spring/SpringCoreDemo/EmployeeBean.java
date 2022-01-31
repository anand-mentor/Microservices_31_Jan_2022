package com.spring.SpringCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {

	private String name;
	
	private ProjectBean project;
	
	public EmployeeBean() {
	}

	public EmployeeBean(ProjectBean project) {
		this.project = project;
		System.out.println("Inside parameterized constructor...");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectBean getProject() {
		return project;
	}
	public void setProject(ProjectBean project) {
		this.project = project;
	}
}
