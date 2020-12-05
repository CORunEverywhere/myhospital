<%@ page import="org.hospital.entity.DepotKeeper" %>
<%@ page import="org.hospital.entity.DepotKeeperPage" %>
<%@ page import="org.hospital.entity.doctorPage" %>
<%@ page import="org.hospital.entity.Doctor" %>
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
				<h3>医生</h3>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>出生年份</th>
							<th>地址</th>
							<th>电话</th>
							<th>密码</th>
							<th>部门</th>
							<th>职务</th>
							<th>操作</th>
						</tr>
						</thead>
						<%
							doctorPage page0 = (doctorPage)request.getAttribute("p") ;
							for(Doctor ddoctor:page0.getDoctors()){
						%>
						<tbody>
						<tr class="rem1">
							<td class="invert">
								<a style="color: mediumslateblue"href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorBySno&sno=<%=ddoctor.getId() %>"><%=ddoctor.getId() %></a>
							</td>
							<td class="invert"><%=ddoctor.getName() %></td>
							<td class="invert"><%=ddoctor.getSex() %></td>
							<td class="invert"><%=ddoctor.getBirthYear() %></td>
							<td class="invert"><%=ddoctor.getAddress() %></td>
							<td class="invert"><%=ddoctor.getPhonenumber() %></td>
							<td class="invert"><%=ddoctor.getPassword() %></td>
							<td class="invert"><%=ddoctor.getDepartment() %></td>
							<td class="invert"><%=ddoctor.getTitle() %></td>

							<td class="invert">
								<a style="color: mediumslateblue"onclick="window.confirm('确定删除?')?this.href='${pageContext.request.contextPath}/Doctor?method=DeleteDoctor&sno=<%=ddoctor.getId() %> ':this.href='javascript:void()';">删除</a>
							</td>
						</tr>
						<%
							}//
						%>
						第<%=page0.getCurrentPage()+1%>页/共<%=page0.getTotalPage()%>页<br>
						</tbody>
					</table>
					<form action="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByName" method="post">
						<input type="text" name="sname">
						<input type="submit" value="按姓名查询">
					</form>
					<a style="color: mediumslateblue" href="admin/addDoctor.jsp">新增</a>
					<%
						if(page0.getCurrentPage()==0 && page0.getTotalPage()!=1){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getCurrentPage()+1%>">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
					<%
					}
						else if(page0.getCurrentPage()==0 && page0.getTotalPage()==1){}
					else if(page0.getCurrentPage()==page0.getTotalPage()-1){
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<%
					}
					else{
					%>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=0">首页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getCurrentPage()-1%>">上一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getCurrentPage()+1%>">下一页</a>
					<a style="color: mediumslateblue" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage&currentPage=<%=page0.getTotalPage()-1%>">尾页</a>
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




