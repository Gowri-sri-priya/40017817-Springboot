package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Sri", "Priya");
	}
	//http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("kavya","vankayala"));
		students.add(new Student("sri","yarra"));
		students.add(new Student("teja","pabolu"));
		students.add(new Student("leela","ayala"));
		return students;
	}
	//http://localhost:8080/student/1
	//@pathVariable annotation
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	//build rest API to handle query parameters
	//http://localhost:8080/student/query?firstName=Sripriya&lastName=Yarra
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name= "firstName") String firstName,
			@RequestParam(name="lastName") String lastName) {
		return new Student(firstName, lastName);
	}
}
