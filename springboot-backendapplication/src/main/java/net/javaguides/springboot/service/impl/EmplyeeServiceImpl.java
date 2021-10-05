package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	
	public EmplyeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		/*Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}*/
		return employeeRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Employee", "Id",id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee" , "Id", id));
				existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee" , "Id", id));
		employeeRepository.deleteById(id);
	}
}
