package com.amrit_dev.emp.service;

import java.util.List;

import com.amrit_dev.emp.dto.EmployeeDto;

public interface EmployeeService {
//	to create employee
	EmployeeDto createEmployee(EmployeeDto employeeDto);
//	to get employee by ID
	EmployeeDto getEmployeeById(Long employeeId);
//	to get allEmployee
	List<EmployeeDto> getAllEmployee();
//	to update the employee
	EmployeeDto updateEmployee(Long id,EmployeeDto updateEmployee);
//	to delete employee
	void deleteEmployee(Long id);

}
