<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp"%>
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
	<title>用户注册</title>
</head>
<body>
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">用户注册</h5>
			<a type="button" class="close" data-dismiss="modal" aria-label="Close" href="patientLogin.jsp">
				<span aria-hidden="true">&times;</span>
			</a>
		</div>
		<div class="modal-body">
			<div class="register-form">
				<form action="${pageContext.request.contextPath}/Patient?method=AddPatient" method="post" onsubmit="return check()">
					<div class="fields-grid">
						<div class="styled-input">
							<input type="text" placeholder="用户名"name="username" id="username" required="required"/>
						</div>
						<div class="styled-input">
							<input type="text" placeholder="姓名"name="name" id="name" required="required"/><br/>
						</div>
						<div class="styled-input">
							<input type="text" placeholder="性别" name="sex" id="sex" required="required"/>
						</div>
						<div class="styled-input" >
							<input type="text" placeholder="出生年份" name="year" id="year" required="required"/>
						</div>
						<div class="styled-input" >
							<input type="text" placeholder="电话" name="phone" id="phone" required="required"/>
						</div>
						<div class="styled-input" >
							<input type="text" placeholder="密码" name="password" id="password" required="required"/>
						</div>
						<button type="submit" class="btn subscrib-btnn">注册</button>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<a type="button" class="btn btn-secondary" data-dismiss="modal" href="patientLogin.jsp">返回</a>
		</div>
	</div>
</div>
</body>
</html>