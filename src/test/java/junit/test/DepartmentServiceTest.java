package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaosoftware.crud.entity.Department;
import com.qiaosoftware.crud.service.DepartmentService;

public class DepartmentServiceTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	DepartmentService departmentService = ioc.getBean(DepartmentService.class);
	
	@Test
	public void testQueryAll() throws Exception {		
		List<Department> deptList = departmentService.queryAll();
		for (Department department : deptList) {
			System.out.println(department);
		}
	}

}
