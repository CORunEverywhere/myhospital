<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>操作成功</title>
<%--	<%--%>
<%--		String basePath = request.getScheme()--%>
<%--				+ "://"--%>
<%--				+ request.getServerName()--%>
<%--				+ ":"--%>
<%--				+ request.getServerPort()--%>
<%--				+ request.getContextPath()--%>
<%--				+ "/";--%>

<%--		pageContext.setAttribute("basePath",basePath);--%>
<%--	%>--%>
<%--	<base href="<%=basePath%>">--%>
</head>
<body>
	操作成功<br>
<%--	<%--%>
<%--		String  = (String)request.getAttribute("msg") ;--%>
<%--		if(msg!=null){--%>
<%--	%>--%>
<%--		<%=msg %>--%>
<%--	<%--%>
<%--		}--%>
<%--	%>--%>
<%--	<a href="DepotKeeper?method=QueryDepotKeeperByPage">返回</a>--%>
	<a href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">返回</a>
</body>
</html>