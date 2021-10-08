package com.javatpoint;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.javatpoint.repository.EmployeeRepository;

@SpringBootApplication
public class SpringSecurityJdbcloginApplication  implements CommandLineRunner
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcloginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside run ....");
		//Optional<Employee> employee;
		
		Scanner name = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter username");
	    String uname = name.nextLine();
	    
	    Scanner password = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter Password");
	    String pass = password.nextLine();
	    
	Employee employee =employeeRepository.findByname(uname, pass);
       String a=employee.getName();
       String b=employee.getPassword();
      
       if(uname.equals(a) && pass.equals(b)) {
    	   	 System.out.print("success");
       }
	}

	}


