package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll() ;
	}

	public Employee getSingleEmployee(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			Employee EmployeeUpdate = employee.get();
			EmployeeUpdate.setName(employeeDetails.getName());
			EmployeeUpdate.setPhoneNumber(employeeDetails.getPhoneNumber());
			EmployeeUpdate.setAddress(employeeDetails.getAddress());
			return employeeRepository.save(EmployeeUpdate);
		}else {
			
			return null;
		}
		
	}

	public void deleteemployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
}
