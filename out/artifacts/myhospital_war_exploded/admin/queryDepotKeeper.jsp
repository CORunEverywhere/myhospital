<%@page import="org.hospital.entity.DepotKeeper"%>
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
        <th>姓名</th>
        <th>性别</th>
        <th>出生年份</th>
        <th>地址</th>
        <th>电话</th>
        <th>密码</th>
        <th>操作</th>
    </tr>

    <%
        List<DepotKeeper> DepotKeepers = (List<DepotKeeper>)request.getAttribute("DepotKeepers") ;
        for(DepotKeeper depotKeeper:DepotKeepers){
    %>
    <tr>
        <td><a href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperBySno&sno=<%=depotKeeper.getId() %>"><%=depotKeeper.getId() %></a></td>

        <td><%=depotKeeper.getName() %></td>
        <td><%=depotKeeper.getSex() %></td>
        <td><%=depotKeeper.getBirthYear() %></td>
        <td><%=depotKeeper.getAddress() %></td>
        <td><%=depotKeeper.getPhonenumber() %></td>
        <td><%=depotKeeper.getPassword() %></td>
<td><a onclick="window.confirm('确定删除?')?this.href='${pageContext.request.contextPath}/DepotKeeper?method=DeleteDepotKeeper&sno=<%=depotKeeper.getId() %> ':this.href='javascript:void()';">删除</a> </td>

    </tr>
    <%
        }//
    %>
</table>
<br>
<a href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">返回</a>
</body>
</html>
