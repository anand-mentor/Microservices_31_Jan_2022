package com.spring.json;

public class Employee {

	private Long employeeId;

	private String name;
	
	private double sal;

	private Profile profile;
	
	public Employee() {
		
	}
	
	public Employee(String name, double sal) {
		this.name = name;
		this.sal = sal;
	}

	public Employee(String name, double sal, Profile profile) {
		this.name = name;
		this.sal = sal;
		this.profile = profile;
	}

	public Employee(Long employeeId, String name, double sal, Profile profile) {
		this.employeeId = employeeId;
		this.name = name;
		this.sal = sal;
		this.profile = profile;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	public String toString() {
		return employeeId + " - " + name + " - " + sal + " - profile: " + profile;
	}
	
}
