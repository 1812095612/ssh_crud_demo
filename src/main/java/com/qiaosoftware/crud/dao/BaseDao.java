package com.qiaosoftware.crud.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.qiaosoftware.crud.entity.Employee;

public class BaseDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    
    /**
     * 增删改都是使用update()方法
     * @param sql
     * @param args
     */
    public void update(String sql, Object ... args) {
        jdbcTemplate.update(sql, args);
    }
    
    /**
     * 批量插入数据
     * @param sql
     * @param batchArgs
     */
    public void batchUpdate(String sql, List<Object[]> batchArgs) {
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
    
    public void test02() {
        //实验2：将emp_id=5的记录的salary字段更新为1300.00
        String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
        
        //增删改都是使用update()方法
        jdbcTemplate.update(sql, 1300.00, 5);
    }
    
    public void test03() {
        //实验3：批量插入
        String sql = "INSERT INTO employee (emp_name,salary) VALUES(?,?)";
        
        //准备批量操作时需要使用的SQL参数
        //DBUtils中的数据结构：
        //Object[][] params
        //二维数组的第一维：具体某一条SQL语句需要使用的参数数据
        //二维数组的第二位：对应SQL语句执行的次数
        //JdbcTemplate中的数据结构：
        //Object[]表示具体某一条SQL语句需要使用的参数数据
        //List表示SQL语句执行的次数
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"emp01",100});
        batchArgs.add(new Object[]{"emp02",200});
        batchArgs.add(new Object[]{"emp03",300});
        batchArgs.add(new Object[]{"emp04",400});
        batchArgs.add(new Object[]{"emp05",500});
        
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
    
    public void test04() {
        //实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
        String sql = "SELECT emp_id empId,emp_name empName,salary FROM employee WHERE emp_id=?";
        
        //RowMapper类似于DBUtils中的ResultSetHandler
        //BeanPropertyRowMapper类似于BeanHandler
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 5);
        System.out.println(employee);
    }
    
    public void test05() {
        //实验5：查询salary>4000的数据库记录，封装为List集合返回
        String sql = "SELECT emp_id empId,emp_name empName,salary FROM employee WHERE salary>?";
        
        //和查询单个对象是一样的
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        
        List<Employee> empList = jdbcTemplate.query(sql, rowMapper, 4000);
        for (Employee employee : empList) {
            System.out.println(employee);
        }
        
    }
    
    public void test06() {
        //实验6：查询最大salary
        String sql = "SELECT MAX(salary) FROM employee";
        
        //传入最终返回的单一值数据的类型
        Double maxSalary = jdbcTemplate.queryForObject(sql, Double.class);
        System.out.println(maxSalary);
        
    }
    
    public void test07() {
        //实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
        String sql = "INSERT INTO employee (emp_name,salary) VALUES(:empNameParam,:salary)";
        
        //使用Map类型为具名参数传值
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("empNameParam", "empGood");
        paramMap.put("salary", 3000);
        
        //使用namedJdbcTemplate执行带有具名参数的SQL语句
        namedJdbcTemplate.update(sql, paramMap);
        
    }
    
    public void test08() {
        //实验8：重复实验7，以SqlParameterSource形式传入参数值
        String sql = "INSERT INTO employee (emp_name,salary) VALUES(:empName,:salary)";
        
        //使用BeanPropertySqlParameterSource对象封装给具名参数传入的数据
        //传入数据时需要提供一个封装参数数据的实体对象
        //要求具名参数的名称必须与实体类的对应属性一致
        Employee employee = new Employee(null, "empHappy", 5000.00);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        
        namedJdbcTemplate.update(sql, paramSource);
        
    }

}
