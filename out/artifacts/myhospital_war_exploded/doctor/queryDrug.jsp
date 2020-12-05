<%@page import="org.hospital.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
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
				List<drug> drugs = (List<drug>)request.getAttribute("drugs") ;
				patient ppatient = (patient)session.getAttribute("ppatient");
				String msg = (String)request.getAttribute("msg");
			%>
				<h4><%=msg %>${requestScope.msg}</h4>
<%--				<h4><%=msg %></h4>--%>
			<%
				for(drug ddoctor:drugs){
			%>
					<tr>
						<td><%=ddoctor.getSno() %></td>

						<td><%=ddoctor.getName() %></td>
						<td><%=ddoctor.getFactory() %></td>
						<td><%=ddoctor.getUnit() %></td>
<%--						<td><%=ddoctor.getNumber() %></td>--%>
						<td><%=ddoctor.getPrice() %></td>
						<td>
							<form action="${pageContext.request.contextPath}/Doctor?method=AddRecipe" method="post">
								<%--								<form action="#" method="post">--%>
								<input type="hidden" name="pid" value="<%=ppatient.getId() %>">
								<input type="hidden" name="pname" value="<%=ppatient.getName() %>">
								<input type="hidden" name="did" value="<%=ddoctor.getSno()%>">
								<input type="hidden" name="dname" value="<%=ddoctor.getName()%>">
								<input type="hidden" name="price" value="<%=ddoctor.getPrice()%>">
								<input type="submit" value="加入药方">
							</form>
						</td>
						
						
					</tr>
			<%
				}//
			%>
			
		</table>
		<br>
</body>
</html>