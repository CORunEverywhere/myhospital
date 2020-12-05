<%@ page import="org.hospital.entity.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: 86438
  Date: 2020/11/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-outs" id="home">
    <div class="header-bar">
        <%@ include file="doctorTop.jsp" %>
        <nav class="navbar navbar-expand-lg navbar-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%Doctor ddoctor = (Doctor)session.getAttribute("ddoctor"); %>
            <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                <ul class="navbar-nav ">
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Form?method=QueryFormByDid&id=<%=ddoctor.getId() %>">接诊</a>
                    </li>
                    <li class="nav-item">
                        <a href="../register.jsp" class="nav-link">退出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>