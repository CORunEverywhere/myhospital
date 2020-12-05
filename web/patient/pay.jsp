<%@page import="org.hospital.entity.recipe"%>
<%@page import="org.hospital.entity.patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>付款成功</title>
</head>
<body>
付款成功，请打印此份凭证前往药房取药。
<table border="1px">
			<tr>
				<th>处方编号</th>
				<th>患者id</th>
				<th>患者姓名</th>
				<th>药品id</th>
				<th>药品名称</th>
				<th>数量</th>
				<th>单价</th>
			</tr>
			
			<%
				//获取request域中的数据
				List<recipe> recipes = (List<recipe>)session.getAttribute("recipes") ;
				for(recipe rrecipe:recipes){
			%>
			<tr>
					<td><%=rrecipe.getId() %></td>
					<td><%=rrecipe.getPid() %></td>
					<td><%=rrecipe.getPname() %></td>
					<td><%=rrecipe.getDid() %></td>
					<td><%=rrecipe.getDname() %></td>
					<td><%=rrecipe.getAmount() %></td>
					<td><%=rrecipe.getPrice() %></td>
			</tr>
			<%
				}
			%>
			
		</table>
			<form action="patient/patientSuccess.jsp">
    	<input type="submit" value="返回">
    </form>
</body>
</html>