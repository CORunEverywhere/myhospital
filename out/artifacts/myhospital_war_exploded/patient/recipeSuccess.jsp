<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作成功</title>
</head>
<body>
	付款成功，请前往药方等待取药<br>
	<%
		String msg = (String)request.getAttribute("msg") ;
		if(msg!=null){
	%>
		<%=msg %>
	<%
		}
	%>
	<form action="patient/patientSuccess.jsp">
    	<input type="submit" value="返回">
    </form>
</body>
</html>