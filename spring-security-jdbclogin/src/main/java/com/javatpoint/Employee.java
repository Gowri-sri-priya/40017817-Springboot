package com.javatpoint;
public class Employee {

	private int id;
	private String name;
	private String password;
	public boolean existsByname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + "]";
	
	}
	
	
	}
	
	
	

