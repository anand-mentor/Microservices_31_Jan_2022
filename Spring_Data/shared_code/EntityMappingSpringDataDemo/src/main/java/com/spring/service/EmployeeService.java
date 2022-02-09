package com.spring.service;

import java.util.List;

import com.spring.json.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public List<Employee> getEmployeesByExperience(double experience);
}
