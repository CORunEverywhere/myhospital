<%--
  Created by IntelliJ IDEA.
  User: 86438
  Date: 2020/11/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-outs" id="home">
    <div class="header-bar">
        <%@ include file="adminTop.jsp" %>
        <nav class="navbar navbar-expand-lg navbar-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                <ul class="navbar-nav ">
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Doctor?method=QueryDoctorByPage ">医生信息管理 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage ">仓管员信息管理 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/Patient?method=QueryAllPatient " class="nav-link">患者信息管理</a>
                    </li>
                    <li class="nav-item">
                        <a href="../admin/updateAdmin.jsp" class="nav-link">修改密码</a>
                    </li>
                    <li class="nav-item">
                        <a href="../register.jsp" class="nav-link">退出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>