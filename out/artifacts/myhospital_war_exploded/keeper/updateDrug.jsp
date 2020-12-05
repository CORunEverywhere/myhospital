<%@page import="org.hospital.entity.drug"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品基本信息修改</title>
</head>
<body>
	<%
			drug ddrug = (drug)request.getAttribute("ddrug") ;
		%>
		<!--  通过表单展示此人信息 -->
		<form action="${pageContext.request.contextPath}/Drug?method=UpdateDrug" method="post">
				编号：<input type="text" name="sno" value="<%=ddrug.getSno()%>" required="required"/><br/>
				名称：<input type="text" name="sname" value="<%=ddrug.getName()%>" required="required"/><br/>
				厂家：<input type="text" name="sfactory" value="<%=ddrug.getFactory()%>" required="required"/><br/>
				单位：<input type="text" name="sunit" value="<%=ddrug.getUnit() %>" required="required"/><br/>
				价格：<input type="text" name="sprice" value="<%=ddrug.getPrice() %>" required="required"/><br/>	
				<input type="submit" value="修改"/>
				<a href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage" method="post">返回</a>
				
		</form>
</body>
</html>