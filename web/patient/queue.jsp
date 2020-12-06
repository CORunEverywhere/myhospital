<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
	<%@include file="../header.jsp"%>
</head>
<body>
<%@include file="patient_nav.jsp"%>
<div class="inner_page-banner one-img">
</div>
<section class="about py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<h3>请选择挂号部门</h3>

		<form method= "post" action="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByDepart">
			<input type="hidden" name="depart" value="内科">
			<input type="submit" value="内科"><br>
		</form>
		<form method= "post" action="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByDepart">
			<input type="hidden" name="depart"  value="外科">
			<input type="submit" value="外科"><br>
		</form>
		<form method= "post" action="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByDepart">
			<input type="hidden" name="depart"  value="中医科">
			<input type="submit" value="中医科"><br>
		</form>
		<div class="about-innergrid-agile text-center">
			<p class="mb-3">
				数据库大作业
			</p>
			<p class="mb-3">
				<a Style="color:cadetblue"href="https://github.com/Lxydouble7">View On GitHub</a>
			</p>
		</div>
	</div>
</section>
</body>
</html>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>挂号</title>
</head>
<body>
