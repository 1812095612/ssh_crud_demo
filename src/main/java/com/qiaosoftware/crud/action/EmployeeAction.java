package com.qiaosoftware.crud.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qiaosoftware.crud.entity.Department;
import com.qiaosoftware.crud.entity.Employee;
import com.qiaosoftware.crud.service.DepartmentService;
import com.qiaosoftware.crud.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("employeeAction")
@Scope("prototype")
public class EmployeeAction extends BaseAction implements ModelDriven<Employee> {

    private static final long serialVersionUID = 3040163729806165279L;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    private Employee employee;

    private Integer empId;
    
    public String queryAll() throws Exception {
        
        List<Employee> empList = employeeService.queryAll();

        request.setAttribute("empList", empList);
        
        return "success";
    }

    // 跳转添加页面，查询部门作为下拉列选
    public String toAdd() throws Exception {

        List<Department> deptList = departmentService.queryAll();

        request.setAttribute("deptList", deptList);

        return "add";
    }

    public void prepareAdd() {
        employee = new Employee();
    }

    public String add() throws Exception {
        employeeService.save(employee);
        return "list";
    }

    public String delete() throws Exception {
        employeeService.delete(empId);
        return "list";
    }

    public void prepareToUpdate() throws Exception {
        employee = employeeService.get(empId); // 查询数据库，有模型驱动压栈，然后表单页面就可以自动回显了
    }

    public String toUpdate() throws Exception {

        List<Department> deptList = departmentService.queryAll();

        request.setAttribute("deptList", deptList);

        return "toUpdate";
    }

    public void prepareDoUpdate() {
        employee = new Employee(); // 创建临时状态对象，有模型驱动压栈，由参数拦截器封装表单参数，为游离对象。
    }

    public String doUpdate() throws Exception {
        employeeService.update(employee);
        return "list";
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public Employee getModel() {
        return employee;
    }

}
