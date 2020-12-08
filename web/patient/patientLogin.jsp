<%--
  Created by IntelliJ IDEA.
  User: 86438
  Date: 2020/10/17
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<title>医云</title>

	<meta charset="utf-8">
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>

	<!-- Custom Theme files -->
	<link href="../css/style1.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<!-- //web font -->

</head>
<body>

<!-- main -->
<div class="w3layouts-main">
	<div class="bg-layer">
		<h1>医云</h1>
		<div class="header-main">
			<div class="main-icon">
				<img style="height: 100px;width: 100px" src="../images/logo.jpg">
			</div>

			<div class="header-left-bottom">
				<form action="${pageContext.request.contextPath}/Patient?method=QueryPatientByUsername" method="post" id="loginForm">
					<div class="icon1">
						<span class="fa fa-user"></span>
						<input id="username" name="username" type="text" placeholder="用户名" style="width: 254.2px;height: 19.6px;background: transparent;border:none;font-size: 15px;color: #222;" required=""/>
					</div>
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input id="password" name="password" type="password" placeholder="密码" required=""/>
					</div>

					<c:if test="${msg!=null}">
						<div class="form-group">
							<div class="col-sm-6">
								<span style="color:red">${msg}</span>
							</div>
						</div>
					</c:if>
					<div class="bottom">
						<button class="btn">登录</button>
					</div>
					                    <div class="links">
					                        <p class="left"><a href="patientRegister.jsp">新用户? 注册</a></p>
					                        <div class="clear"></div>
					                    </div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- //main -->

</body>
</html>
<script type="text/javascript">
	function check() {
		if (!document.getElementById("doctor").checked && !document.getElementById("depot_keeper").checked && !document.getElementById("admin").checked) {
			alert("用户类型！")
			return false;
		}
	}
</script>

