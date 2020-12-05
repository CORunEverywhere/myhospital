<%@ page import="org.hospital.entity.admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx">
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function check()//onsubmit： return true：表单正常提交   return false:表单终止提交
		{
			var sname = $("#sname").val();
			if (!(sname.length >1 && sname.length<10)){
				alert("姓名长度有误！必须是2-10位")
				return false ;
			}

			//if(...) return false ;

			return true ;
		}

		$(document).ready(function(){
		});

	</script>
	<%@include file="../header.jsp"%>
	<title>增加仓库管理员</title>
</head>
<body>
<%
	admin aadmin = (admin)session.getAttribute("aadmin");
%>
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">修改密码</h5>
			<a type="button" class="close" data-dismiss="modal" aria-label="Close" href="admin_login.jsp">
				<span aria-hidden="true">&times;</span>
			</a>
		</div>
		<div class="modal-body">
			<div class="register-form">
				<form action="${pageContext.request.contextPath}/login?method=updatePassword" method="post">
					<div class="fields-grid">
						<div class="styled-input">
							<input type="hidden" name="username" value="<%=aadmin.getName() %>"><br>
							用户名:<%=aadmin.getName() %><br>
							<c:if test="${not empty requestScope.err}" >${requestScope.err}</c:if>
						</div>
						<div class="styled-input">
							<input type="text" placeholder="原密码" name="password" required="required"><br>
						</div>
						<div class="styled-input">
							<input type="text" placeholder="新密码" name="newPassword" required="required"><br>
						</div>
						<button type="submit" class="btn subscrib-btnn">修改密码</button>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<a type="button" class="btn btn-secondary" data-dismiss="modal" href="admin_login.jsp">返回</a>
		</div>
	</div>
</div>
</body>
</html>
