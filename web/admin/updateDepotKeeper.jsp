<%--
  Created by IntelliJ IDEA.
  User: 84016
  Date: 2020/12/5
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>仓库管理员信息修改</title>
</head>
<body>
<form action="DepotKeeper?method=UpdateDepotKeeperBySno" method="post">
    <input type="hidden" name="id" value="${requestScope.depotKeeper.id}">
    姓名：<input type="text" name="name" value="${requestScope.depotKeeper.name}" required="required"><br>
    性别：<input type="text" name="sex" value="${requestScope.depotKeeper.sex}" required="required"><br>
    出生年份：<input type="text" name="birthyear" value="${requestScope.depotKeeper.birthYear}"  required="required"><br>
    密码：<input type="text" name="password" value="${requestScope.depotKeeper.password}" required="required"><br>
    地址：<input type="text" name="address" value="${requestScope.depotKeeper.address}" required="required"><br>
    电话号码：<input type="text" name="phonenumber" value="${requestScope.depotKeeper.phonenumber}" required="required"><br>
    <input type="submit" value="修改"><br>
    <a href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">返回</a>
</form>
</body>
</html>
