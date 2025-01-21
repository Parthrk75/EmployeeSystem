package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService ;
	
	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getSingleEmployee(@PathVariable Long id) {
		return employeeService.getSingleEmployee(id);
	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetail) {
		Employee updatedEmployee = employeeService.updateEmployee(id,employeeDetail) ;
		if(updatedEmployee != null) {
			return ResponseEntity.ok(updatedEmployee);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/deleteemployee/{id}")
		public ResponseEntity<String> deleteemployee(@PathVariable Long id){
			employeeService.deleteemployee(id);
			String message = "Employee with ID " + id + " has been successfully deleted.";
			return ResponseEntity.ok(message);
		}
	
	
	
}
