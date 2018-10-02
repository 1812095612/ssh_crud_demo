package com.qiaosoftware.crud.dao;

import java.util.List;

import com.qiaosoftware.crud.entity.Employee;

public interface EmployeeDao {

	List<Employee> queryAll() throws Exception ;
	
	void save(Employee emp) throws Exception ;
	
	Employee get(Integer empId) throws Exception ;
	
	void update(Employee emp) throws Exception ;
	
	void delete(Employee emp) throws Exception ;
	
}
