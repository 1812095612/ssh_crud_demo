package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaosoftware.crud.entity.Department;
import com.qiaosoftware.crud.entity.Employee;
import com.qiaosoftware.crud.service.EmployeeService;

public class EmployeeServiceTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	EmployeeService  employeeService = ioc.getBean(EmployeeService.class);
	
	@Test
	public void testQueryAll() throws Exception {		
		List<Employee> empList = employeeService.queryAll();
		for (Employee employee : empList) {
			System.out.println(employee);
			System.out.println(employee.getDept().getDeptName());
		}
	}
	
	@Test
	public void testSave() throws Exception {
		Employee emp = new Employee(null,"李老师");
		
		Department dept = new Department();
		dept.setDeptId(1);
		
		emp.setDept(dept);
		
		employeeService.save(emp);
	}
	
	@Test
	public void testGet() throws Exception {
		Employee employee = employeeService.get(2);
		System.out.println(employee);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Employee emp = new Employee(1,"张老师(转)");
		
		Department dept = new Department();
		dept.setDeptId(2);
		
		emp.setDept(dept);
		
		employeeService.update(emp);
	}
	
	@Test
	public void testDelete() throws Exception {
		employeeService.delete(1);		
	}
	
	@Test
	public void test001() throws Exception {
	}

}
