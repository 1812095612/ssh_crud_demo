package com.qiaosoftware.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.crud.dao.DepartmentDao;
import com.qiaosoftware.crud.entity.Department;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao ;
	
	@Transactional(readOnly=true)
	@Override
	public List<Department> queryAll() throws Exception {		
		return departmentDao.queryAll();
	}

}
