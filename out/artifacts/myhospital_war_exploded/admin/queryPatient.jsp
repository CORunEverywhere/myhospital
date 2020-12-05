<%@page import="org.hospital.entity.patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询患者</title>
</head>
<body>
<table border="1px">
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生年份</th>
				<th>电话</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<patient> patients = (List<patient>)request.getAttribute("patients") ;
				for(patient ppatient:patients){
			%>
					<tr>
						<td><%=ppatient.getId() %></td>
						<td><%=ppatient.getUsername() %></td>
						<td><%=ppatient.getName() %></td>
						<td><%=ppatient.getSex() %></td>
						<td><%=ppatient.getYear() %></td>
						<td><%=ppatient.getPhone() %></td>
						<td><%=ppatient.getPassword() %></td>
						
						<td><a onclick="window.confirm('确定删除?')?this.href='${pageContext.request.contextPath}/Patient?method=DeletePatientById&sno=<%=ppatient.getId() %> ':this.href='javascript:void()';">删除</a> </td>				 
					
					</tr>
			<%
				}//
			%>
		</table>
		<a href="${pageContext.request.contextPath}/Patient?method=QueryAllPatient">返回</a>
</body>
</html>