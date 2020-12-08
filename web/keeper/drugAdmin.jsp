<%@ page import="org.hospital.entity.DepotKeeper" %>
<%@ page import="org.hospital.entity.DepotKeeperPage" %>
<%@ page import="org.hospital.entity.drug" %>
<%@ page import="org.hospital.entity.drugPage" %>
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
	<title>药品管理</title>
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
				<h3>药品管理</h3>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>厂家</th>
							<th>单位</th>
							<th>数量</th>
							<th>价格</th>
							<th>操作</th>
						</tr>
						</thead>
						<%
							//获取request域中的数据
							drugPage page0 = (drugPage)request.getAttribute("p") ;
							for(drug ddoctor:page0.getDrugs()){
						%>
						<tbody>
						<tr class="rem1">
							<td class="invert">
								<a style="color: mediumslateblue"href="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno&sno=<%=ddoctor.getSno() %>"><%=ddoctor.getSno() %></a>
							</td>
							<td class="invert"> <%=ddoctor.getName() %></td>
							<td class="invert"><%=ddoctor.getFactory() %></td>
							<td class="invert"><%=ddoctor.getUnit() %></td>
							<td class="invert"><%=ddoctor.getNumber() %></td>
							<td class="invert"><%=ddoctor.getPrice() %></td>
							<td class="invert"><a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno3&sno=<%=ddoctor.getSno() %>">出入库</a></td>
						</tr>
						<%
							}//
						%>
						第<%=page0.getCurrentPage()+1%>页/共<%=page0.getTotalPage()%>页<br>
						</tbody>
					</table>
					<form action="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno4" method="post">
						<input type="text" name="sno">
						<input type="submit" value="按名称查询">
					</form>


					<a style="color: mediumslateblue" href="keeper/addDrug.jsp">新增</a>
					<%
						if(page0.getCurrentPage()==0){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getCurrentPage()+1%>">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
					<%
					}
					else if(page0.getCurrentPage()==page0.getTotalPage()-1){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<%
					}
					else{
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getCurrentPage()+1%>">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
					<%
						}
					%>
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
