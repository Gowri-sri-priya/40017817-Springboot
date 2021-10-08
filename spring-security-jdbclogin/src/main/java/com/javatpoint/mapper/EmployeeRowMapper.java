package com.javatpoint.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(rs.getInt("ID"));
		employee.setName(rs.getString("NAME"));
		employee.setPassword(rs.getString("PASSWORD"));
		return employee;
	}
	

}
