<%@page import="org.hospital.entity.recipe"%>
<%@page import="org.hospital.entity.patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药方</title>
</head>
<body>
<table border="1px">
			<tr>
				<th>处方编号</th>
				<th>患者id</th>
				<th>患者姓名</th>
				<th>药品id</th>
				<th>药品名称</th>
				<th>数量</th>
				<th>单价</th>
				<th>操作</th>
				<th>操作</th>
				<th>操作</th>
			</tr>
			
<%--			<%--%>
<%--				//获取request域中的数据--%>
<%--				List<recipe> recipes = (List<recipe>)request.getAttribute("recipes") ;--%>
<%--				for(recipe rrecipe:recipes){--%>
<%--			%>--%>
			<c:forEach items="${requestScope.recipes}" var="rrecipe">
				<tr>
<%--					<td><%=rrecipe.getId() %></td>--%>
<%--					<td><%=rrecipe.getPid() %></td>--%>
<%--					<td><%=rrecipe.getPname() %></td><%System.out.println(rrecipe.getPname());%>--%>
<%--					<td><%=rrecipe.getDid() %></td>--%>
<%--					<td><%=rrecipe.getDname() %></td>--%>
<%--					<td><%=rrecipe.getAmount() %></td>--%>
<%--					<td><%=rrecipe.getPrice() %></td>--%>
					<td>${rrecipe.id}</td>
					<td>${rrecipe.pid}</td>
					<td>${rrecipe.pname}</td>
					<td>${rrecipe.did}</td>
					<td>${rrecipe.dname}</td>
					<td>${rrecipe.amount}</td>
					<td>${rrecipe.price}</td>

					<td><a onclick="window.confirm('确定删除?')?this.href='${pageContext.request.contextPath}/Doctor?method=DeleteRecipe&id=${rrecipe.id}':this.href='javascript:void()';">删除</a> </td>
					<td><a href="${pageContext.request.contextPath}/Doctor?method=UpdateRecipe&id=${rrecipe.id}&amount=1">增加</a> </td>
					<td><a href="${pageContext.request.contextPath}/Doctor?method=UpdateRecipe&id=${rrecipe.id}&amount=-1">减少</a> </td>

				</tr>
			</c:forEach>

<%--			<%--%>
<%--				}--%>
<%--			%>--%>
			
		</table>
		<br>
		<%
patient ppatient = (patient)session.getAttribute("ppatient");
		int id = (int)session.getAttribute("id");
%>
	<a href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug&pid=<%=ppatient.getId() %>&id=<%=id %>">返回</a>
	<a href="${pageContext.request.contextPath}/Form?method=UpdateFormByDid&id=<%=id %>">提交药方</a>
</body>
</html>