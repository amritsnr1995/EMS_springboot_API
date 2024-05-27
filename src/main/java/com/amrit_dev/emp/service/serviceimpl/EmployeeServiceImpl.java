package com.amrit_dev.emp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amrit_dev.emp.dto.EmployeeDto;
import com.amrit_dev.emp.entity.Employee;
import com.amrit_dev.emp.exceptions.ResourceNotFoundException;
import com.amrit_dev.emp.mapper.EmployeeMapper;
import com.amrit_dev.emp.repository.EmployeeRepository;
import com.amrit_dev.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// Logic to convert DTO to entity
		Employee employee = EmployeeMapper.mapToEntity(employeeDto);
		//		save it
		Employee savedEmployee = employeeRepository.save(employee);
		//		convert back to DTO
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);

	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("not found employee with id" + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee donot exist with id" + id));
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		Employee savedEmployee = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("no found employee with id"+ id));
		employeeRepository.deleteById(id);		
	}

}
