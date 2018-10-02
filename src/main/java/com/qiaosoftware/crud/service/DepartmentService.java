package com.qiaosoftware.crud.service;

import java.util.List;

import com.qiaosoftware.crud.entity.Department;

public interface DepartmentService {
	
	List<Department> queryAll() throws Exception ;
	
}
