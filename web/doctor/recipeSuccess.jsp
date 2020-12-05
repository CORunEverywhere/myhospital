<%@page import="org.hospital.entity.patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
加入药方成功
<%
patient ppatient = (patient)session.getAttribute("ppatient");
int id = (int)session.getAttribute("id");
%>
	<a href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug&pid=<%=ppatient.getId() %>&id=<%=id%>">返回</a>
</body>
</html>