<%@ page import="org.hospital.entity.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>请为患者开药方</title>
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
				<h3>请为患者开药方</h3>
<%--				<form action="doctor/queryForm.jsp">--%>
				<div class="checkout-right">
					<table class="timetable_sub">

						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>厂家</th>
							<th>单位</th>
							<th>价格</th>
							<th>操作</th>
						</tr>

						<%
							//获取request域中的数据
							drugPage page0 = (drugPage)request.getAttribute("p") ;
							patient ppatient = (patient)session.getAttribute("ppatient");
							List<drug> drugs = page0.getDrugs();
						%>
						<c:forEach items="${requestScope.p.drugs}" var="drugt">
							<tr class="rem1">
								<td class="invert">${drugt.sno}</td>
								<td class="invert">${drugt.name}</td>
								<td class="invert">${drugt.factory}</td>
								<td class="invert">${drugt.unit}</td>
								<td class="invert">${drugt.price}</td>
								<td class="invert">
									<form action="${pageContext.request.contextPath}/Doctor?method=AddRecipe" method="post">

										<input type="hidden" name="pid" value="${sessionScope.ppatient.id}">
<%--										<input type="hidden" name="pid" value="<%=ppatient.getId() %>">--%>
										<input type="hidden" name="pname" value="${sessionScope.ppatient.name}">
<%--										<input type="hidden" name="pname" value="<%=ppatient.getName() %>">--%>
										<input type="hidden" name="did" value="${drugt.sno}">
										<input type="hidden" name="dname" value="${drugt.name}">
										<input type="hidden" name="price" value="${drugt.price}">
										<input type="submit" value="加入药方">
									</form>
								</td>
							</tr>
						</c:forEach>
						第${requestScope.p.currentPage+1}页/共${requestScope.p.totalPage}页<br>
<%--						第<%=page0.getCurrentPage()+1%>页/共<%=page0.getTotalPage()%>页<br>--%>

					</table>
					<form action="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno2" method="post">
						<input type="text" name="sno">
						<input type="submit" value="按名称查询">
					</form>
					<form action="${pageContext.request.contextPath}/Doctor?method=QueryRecipe" method="post">
						<input type="hidden" name="pid" value="<%=ppatient.getId() %>">
						<input type="submit" value="药方查看">
					</form>
					<%
						if(page0.getCurrentPage()==0 && page0.getTotalPage()!=1){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getCurrentPage()+1%>"&id="">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
					<%
						}
						else if(page0.getCurrentPage()==0 && page0.getTotalPage()==1){}

					else if(page0.getCurrentPage()==page0.getTotalPage()-1){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<%
					}
					else {
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getCurrentPage()+1%>">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Drug?method=QueryAllDrug0&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
					<%
						}
					%>
				</div>
<%--				</form>--%>
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



