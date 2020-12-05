<%@page import="org.hospital.entity.drug"%>
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
				<th>数量</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<%
				//获取request域中的数据
				List<drug> drugs = (List<drug>)request.getAttribute("drugs") ;
				String msg = (String)request.getAttribute("msg");
			%>
				<h4><%=msg %></h4>
			<% 
				for(drug ddoctor:drugs){
			%>
					<tr>
						<td><a href="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno&sno=<%=ddoctor.getSno() %>"><%=ddoctor.getSno() %></a></td>
						
						<td><%=ddoctor.getName() %></td>
						<td><%=ddoctor.getFactory() %></td>
						<td><%=ddoctor.getUnit() %></td>
						<td><%=ddoctor.getNumber() %></td>
						<td><%=ddoctor.getPrice() %></td>
						
						<td><a href="${pageContext.request.contextPath}/Drug?method=QueryDrugBySno3&sno=<%=ddoctor.getSno() %>">出入库</a></td>
						
						
					</tr>
			<%
				}//
			%>
			
		</table>
		<br>
		<a href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage">返回</a>
</body>
</html>