<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	修改员工:
	<br>
	
	<s:form action="doUpdateEmployee.action" >	
		<s:hidden name="empId"/>	
		<s:textfield name="empName" label="员工姓名"/>
		<s:select name="dept.deptId" list="#request.deptList" listKey="deptId" listValue="deptName" label="部门名称"></s:select>
		<s:submit value="更新"/>
	</s:form>

</body>
</html>