package com.qiaosoftware.crud.dao;

import java.util.List;

import com.qiaosoftware.crud.entity.Department;

public interface DepartmentDao {

	List<Department> queryAll() throws Exception ;
	
}
