<%@page import="org.hospital.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>医生信息修改</title>
</head>
<body>
		<%
			Doctor ddoctor = (Doctor)request.getAttribute("ddoctor") ;
		%>
		<!--  通过表单展示此人信息 -->
		<form action="${pageContext.request.contextPath}/Doctor?method=UpdateDoctor" method="post">
<%--				编号不可修改！<br>--%>
					<input type="hidden" name="sno" value="<%=ddoctor.getId() %>"  required="required"/>
				姓名：<input type="text" name="sname" value="<%=ddoctor.getName() %>"  required="required"/><br/>
				性别：<input type="text" name="ssex" value="<%=ddoctor.getSex() %>"  required="required"/><br/>
				出生年份：<input type="text" name="sbirthyear" value="<%=ddoctor.getBirthYear() %>"  required="required"/><br/>
				地址：<input type="text" name="saddress" value="<%=ddoctor.getAddress() %>"  required="required"/><br/>
				电话：<input type="text" name="sphonenumber" value="<%=ddoctor.getPhonenumber() %>"  required="required"/><br/>
				部门：<input type="text" name="sdepartment" value="<%=ddoctor.getDepartment() %>"  required="required"/><br/>
				职务：<input type="text" name="stitle" value="<%=ddoctor.getTitle() %>"  required="required"/><br/>		
				<input type="submit" value="修改"/>
				<a href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage">返回</a>
				
		</form>
</body>
</html>