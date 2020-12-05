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
	<title>药品出入库</title>
</head>
<body>
<!--headder-->
<%@include file="keeper_nav.jsp"%>

<div class="inner_page-banner one-img">
</div>
<section class="checkout py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<div class="shop_inner_inf">
			<div class="privacy about">
				<h3>药品出入库</h3>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
						<tr>
							<th>编号</th>
							<th>药品编号</th>
							<th>药品名称</th>
							<th>操作人编号</th>
							<th>操作人名称</th>
							<th>出入库数量</th>
							<th>时间</th>
						</tr>
						</thead>
						<%
							//获取request域中的数据
							List<record> doctor = (List<record>)request.getAttribute("records") ;
							for(record ddoctor:doctor){
						%>
						<tbody>
						<tr class="rem1">
							<td class="invert"><%=ddoctor.getSno() %></td>
							<td class="invert"><%=ddoctor.getDrugSno() %></td>
							<td class="invert"><%=ddoctor.getDrugSname() %></td>
							<td class="invert"><%=ddoctor.getPersonSno() %></td>
							<td class="invert"><%=ddoctor.getPersonSname() %></td>
							<td class="invert"><%=ddoctor.getNumber() %></td>
							<td class="invert"><%=ddoctor.getTime() %></td>
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
