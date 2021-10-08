package com.javatpoint.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.ltts.springboot.exception.ResorceNotFoundException;
import com.javatpoint.Employee;
import com.javatpoint.mapper.EmployeeRowMapper;

@Repository
public class EmployeeRepository 
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Transactional(readOnly = true)

    public  Employee findByname(String name, String password )
  
    {
    	String sql ="SELECT * FROM EMPLOYEE WHERE name =? and password =? ";
    	
    	//Employee employee =jdbcTemplate.queryForObject(sql, new Object[] { id },
    	Employee employee =jdbcTemplate.queryForObject(sql, new Object[] {name , password},
    			new EmployeeRowMapper());
		return employee;
    	
    	//return employee;

}
		
		
		
		
		
		
	
    			
    
    
}
