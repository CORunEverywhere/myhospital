<%@page import="org.hospital.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询医生</title>
</head>
<body>
<table border="1px">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生年份</th>
				<th>地址</th>
				<th>电话</th>
				<th>密码</th>
				<th>部门</th>
				<th>职务</th>
				<th>操作</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<Doctor> doctors = (List<Doctor>)request.getAttribute("doctors") ;
				for(Doctor ddoctor:doctors){
			%>
					<tr>
						<td><a href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorBySno&sno=<%=ddoctor.getId() %>"><%=ddoctor.getId() %></a></td>
						
						<td><%=ddoctor.getName() %></td>
						<td><%=ddoctor.getSex() %></td>
						<td><%=ddoctor.getBirthYear() %></td>
						<td><%=ddoctor.getAddress() %></td>
						<td><%=ddoctor.getPhonenumber() %></td>
						<td><%=ddoctor.getPassword() %></td>
						<td><%=ddoctor.getDepartment() %></td>
						<td><%=ddoctor.getTitle() %></td>
						
						<td><a onclick="window.confirm('确定删除?')?this.href='deleteDoctorServlet&sno=<%=ddoctor.getId() %> ':this.href='javascript:void()';">删除</a> </td>				 
					
					</tr>
			<%
				}//
			%>
		</table>
		<br>
		<a href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage">返回</a>
</body>
</html>