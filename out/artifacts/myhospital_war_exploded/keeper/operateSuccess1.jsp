<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作成功</title>
</head>
<body>
	操作成功<br>
	<%
		String msg = (String)request.getAttribute("msg") ;
		if(msg!=null){
	%>
		<%=msg %>
	<%
		}
	%>
	<a href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage">返回</a>
</body>
</html>