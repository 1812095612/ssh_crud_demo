package com.qiaosoftware.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.crud.dao.EmployeeDao;
import com.qiaosoftware.crud.entity.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao ;
	
	@Override
	public List<Employee> queryAll() throws Exception {
		return employeeDao.queryAll();
	}

	@Override
	public void save(Employee emp) throws Exception {
		employeeDao.save(emp);
	}

	@Override
	public Employee get(Integer empId) throws Exception {		
		return employeeDao.get(empId);
	}

	@Override
	public void update(Employee emp) throws Exception {
		employeeDao.update(emp);
	}

	@Override
	public void delete(Integer empId) throws Exception {
		Employee emp = employeeDao.get(empId);
		if(emp!=null){
			employeeDao.delete(emp);
		}
	}

}
