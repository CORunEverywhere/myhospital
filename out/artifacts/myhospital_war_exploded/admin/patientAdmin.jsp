<%@ page import="org.hospital.entity.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
	<%@include file="../header.jsp"%>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:odd").css("background-color","lightgray");//隔行变色
		});
	</script>
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
	<meta charset="UTF-8">
	<title>管理员信息</title>
</head>
<body>
<!--headder-->
<%@include file="admin_nav.jsp"%>

<div class="inner_page-banner one-img">
</div>
<section class="checkout py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<div class="shop_inner_inf">
			<div class="privacy about">
				<h3>患者</h3>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
						<tr>
							<th>编号</th>
							<th>用户名</th>
							<th>姓名</th>
							<th>性别</th>
							<th>出生年份</th>
							<th>电话</th>
							<th>密码</th>
							<th>操作</th>
						</tr>
						</thead>
						<%
							//获取request域中的数据
							List<patient> patients = (List<patient>)request.getAttribute("patients") ;
							for(patient ppatient:patients){
						%>
						<tbody>
						<tr class="rem1">
							<td class="invert"><%=ppatient.getId() %></td>
							<td class="invert"><%=ppatient.getUsername() %></td>
							<td class="invert"><%=ppatient.getName() %></td>
							<td class="invert"><%=ppatient.getSex() %></td>
							<td class="invert"><%=ppatient.getYear() %></td>
							<td class="invert"><%=ppatient.getPhone() %></td>
							<td class="invert"><%=ppatient.getPassword() %></td>
							<td class="invert">
								<a style="color: mediumslateblue"onclick="window.confirm('确定删除?')?this.href='${pageContext.request.contextPath}/Patient?method=DeletePatientById&sno=<%=ppatient.getId() %> ':this.href='javascript:void()';">删除</a>
							</td>
						</tr>
						<%
							}//
						%>
						</tbody>
					</table>
					<form action="${pageContext.request.contextPath}/Patient?method=QueryPatientByName" method="post">
						<input type="text" name="sname">
						<input type="submit" value="按姓名查询">
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script src='js/jquery-2.2.3.min.js'></script>
<script src="js/minicart.js"></script>
<script>
	toys.render();

	toys.cart.on('toys_checkout', function (evt) {
		var items, len, i;

		if (this.subtotal() > 0) {
			items = this.items();

			for (i = 0, len = items.length; i < len; i++) {}
		}
	});
</script>

<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>

<script src="js/bootstrap.min.js"></script>
</body>
</html>
