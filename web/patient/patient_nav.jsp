<%@ page import="org.hospital.entity.Doctor" %>
<%@ page import="org.hospital.entity.patient" %><%--
  Created by IntelliJ IDEA.
  User: 86438
  Date: 2020/11/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-outs" id="home">
    <div class="header-bar">
        <%@ include file="patientTop.jsp" %>
        <nav class="navbar navbar-expand-lg navbar-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%patient ppatient = (patient)session.getAttribute("ppatient");%>
            <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                <ul class="navbar-nav ">
                    <li class="nav-item ">
                        <a class="nav-link" href="patient/queue.jsp">挂号</a>
                    </li>
                    <li class="nav-item">

                        <form method= "post" action="${pageContext.request.contextPath}/Patient?method=QueryRecipe">
                            <input type="hidden" name="pid" value="<%=ppatient.getId()%>">

                            <input class="nav-link" style="border-style:none;background: transparent" type="submit" value="取药"><br>
                        </form>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="patient/updatePatient.jsp">修改信息<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a href="patient/patientLogin.jsp" class="nav-link">退出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
