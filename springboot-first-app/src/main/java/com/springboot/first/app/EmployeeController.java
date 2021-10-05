package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/employee")
	public Employee getEmployee() {
		return new Employee("100","sri","Associate");
	}
}
