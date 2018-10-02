package com.qiaosoftware.crud.entity;

public class Employee {

	private Integer empId;
	private String empName;

	private Department dept;

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	public Employee(Integer empId, String empName, Double salary) {
	    super();
	    this.empId = empId;
	    this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
