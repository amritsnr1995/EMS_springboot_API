package com.amrit_dev.emp.mapper;

import com.amrit_dev.emp.dto.EmployeeDto;
import com.amrit_dev.emp.entity.Employee;

public class EmployeeMapper {

	//	 maptoentity
	public static Employee mapToEntity(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail());
	}
//	maptoDto
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

}
