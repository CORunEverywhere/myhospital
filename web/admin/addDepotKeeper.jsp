
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
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
    <%@include file="../header.jsp"%>
    <title>增加仓库管理员</title>
</head>
<body>
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">新增仓库管理员</h5>
            <a type="button" class="close" data-dismiss="modal" aria-label="Close" href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">
                <span aria-hidden="true">&times;</span>
            </a>
        </div>
        <div class="modal-body">
            <div class="register-form">
                <form action="${pageContext.request.contextPath}/DepotKeeper?method=AddDepotKeeper" method="post" onsubmit="return check()">
                    <div class="fields-grid">
                        <div class="styled-input">
                            <input type="text" placeholder="姓名"name="sname" id="sname" required="required"/>
                        </div>
                        <div class="styled-input">
                            <input type="text" placeholder="性别"name="ssex" id="ssex" required="required"/><br/>
                        </div>
                        <div class="styled-input">
                            <input type="text" placeholder="手机号" name="sphonenumber" id="sphonenumber" required="required"/>
                        </div>
                        <div class="styled-input" >
                            <input type="text" placeholder="地址" name="saddress" id="saddress" required="required"/>
                        </div>
                        <div class="styled-input"style="margin-bottom: 30px">
                            <a style="color:#5a5656;font-size:16px">生日</a>
                            <input type="date" placeholder="生日" name="sbirthyear" id="sbirthyear" required="required"/>
                        </div>
                        <button type="submit" class="btn subscrib-btnn">新增</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <a type="button" class="btn btn-secondary" data-dismiss="modal" href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">返回</a>
        </div>
    </div>
</div>
</body>
</html>


<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        function check()//onsubmit： return true：表单正常提交   return false:表单终止提交--%>
<%--        {--%>
<%--            var sname = $("#sname").val();--%>
<%--            if (!(sname.length >1 && sname.length<10)){--%>
<%--                alert("姓名长度有误！必须是2-10位")--%>
<%--                return false ;--%>
<%--            }--%>

<%--            //if(...) return false ;--%>

<%--            return true ;--%>
<%--        }--%>

<%--        $(document).ready(function(){--%>
<%--        });--%>

<%--    </script>--%>
<%--    <title>增加仓库管理员</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="${pageContext.request.contextPath}/DepotKeeper?method=AddDepotKeeper" method="post" onsubmit="return check()">--%>
<%--    姓名：<input type="text" name="sname" id="sname" required="required"/><br/>--%>
<%--    性别：<input type="text" name="ssex" id="ssex" required="required"/><br/>--%>
<%--    出生年份：<input type="text" name="sbirthyear" id="sbirthyear" required="required"/><br/>--%>
<%--    地址：<input type="text" name="saddress" id="saddress" required="required"/><br/>--%>
<%--    电话：<input type="text" name="sphonenumber" id="sphonenumber" required="required"/><br/>--%>
<%--    <input type="submit" value="新增" />--%>
<%--    <a href="${pageContext.request.contextPath}/DepotKeeper?method=QueryDepotKeeperByPage">返回</a>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>