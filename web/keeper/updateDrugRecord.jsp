<%@page import="org.hospital.entity.drug"%>
<%@page import="org.hospital.entity.DepotKeeper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品出入库</title>
</head>
<body>
	<%
			drug ddrug = (drug)request.getAttribute("ddrug") ;
			DepotKeeper keeper = (DepotKeeper)session.getAttribute("keeper");
		%>
		<!--  通过表单展示此人信息 -->
		<form action="${pageContext.request.contextPath}/Drug?method=UpdateDrugRecord" method="post">
				<input type="hidden" name="number" value="<%=ddrug.getNumber()%>">
				<input type="hidden" name="sno" value="<%=ddrug.getSno()%>" required="required"/><br/>
				<input type="hidden" name="id" value="<%=keeper.getId()%>">
				<input type="hidden" name="sname" value="<%=ddrug.getName()%>" required="required"/>
				编号：<%=ddrug.getSno()%><br/>
				名称：<%=ddrug.getName()%><br/>
				出入库数量：<input type="text" name="snumber" required="required"/><br/>
				<input type="submit" value="修改"/>
				<a href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage" method="post">返回</a>
				
		</form>
</body>
</html>