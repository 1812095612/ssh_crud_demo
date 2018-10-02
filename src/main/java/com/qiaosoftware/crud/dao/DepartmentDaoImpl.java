package com.qiaosoftware.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qiaosoftware.crud.entity.Department;

@Repository("departmentDao")
@SuppressWarnings("unchecked") //去除泛型警告
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	@Override
	public List<Department> queryAll() throws Exception {
		return getSession().createQuery("FROM Department")
		                   .setCacheable(true)
		                   .list();
	}

}
