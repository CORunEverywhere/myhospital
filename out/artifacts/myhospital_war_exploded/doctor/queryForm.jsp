<%@ page import="org.hospital.entity.DepotKeeper" %>
<%@ page import="org.hospital.entity.DepotKeeperPage" %>
<%@ page import="org.hospital.entity.form" %>
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
<%@include file="doctor_nav.jsp"%>

<div class="inner_page-banner one-img">
</div>
<section class="checkout py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<div class="shop_inner_inf">
			<div class="privacy about">
				<h3>挂号单</h3>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
						<tr>
							<th>挂号单号</th>
							<th>患者id</th>
							<th>患者姓名</th>
							<th>挂号时间</th>
							<th>操作</th>
						</tr>
						</thead>
						<%
							List<form> forms = (List<form>)request.getAttribute("forms") ;
							for(form fform:forms){
						%>
						<tbody>
						<tr class="rem1">
							<td class="invert"><%=fform.getId() %></td>
							<td class="invert"><%=fform.getPid() %></td>
							<td class="invert"><%=fform.getPname() %></td>
							<td class="invert"><%=fform.getTime() %></td>
							<td class="invert">
								<a style="color: mediumslateblue" onclick="window.confirm('确定接诊?')?this.href='${pageContext.request.contextPath}/Drug?method=QueryAllDrug&id=<%=fform.getId() %>&pid=<%=fform.getPid() %>':this.href='javascript:void()';">接诊</a>
							</td>

						</tr>
						<%
							}//
						%>
						</tbody>
					</table>
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