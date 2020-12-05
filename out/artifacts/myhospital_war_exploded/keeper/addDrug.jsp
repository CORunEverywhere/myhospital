<%@ page import="org.hospital.entity.DepotKeeper" %>
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
			<h5 class="modal-title" id="exampleModalLabel">增加药品</h5>
			<a type="button" class="close" data-dismiss="modal" aria-label="Close" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage">
				<span aria-hidden="true">&times;</span>
			</a>
		</div>
		<div class="modal-body">
			<div class="register-form">
				<%
					DepotKeeper keeper = (DepotKeeper)session.getAttribute("keeper");
				%>
				<form action="${pageContext.request.contextPath}/Drug?method=AddDrug" method="post" onsubmit="return check()">
					<div class="fields-grid">
						<div class="styled-input">
							<input type="hidden" name="id" value="<%=keeper.getId()%>">
						</div>
						<div class="styled-input">
							<input type="text" placeholder="编号" name="sno" id="sno" required="required"/>
						</div>
						<div class="styled-input">
							<input type="text" placeholder="名称" name="sname" id="sname" required="required"/>
						</div>
						<div class="styled-input" >
							<input type="text" placeholder="厂家" name="sfactory" id="sfactory" required="required"/>
						</div>
						<div class="styled-input"style="margin-bottom: 30px">
							<input type="text" placeholder="单位" name="sunit" id="sunit" required="required"/><br/>
						</div>
						<div class="styled-input" >
							<input type="text" placeholder="数量" name="snumber" id="snumber" required="required"/>
						</div>
						<div class="styled-input"style="margin-bottom: 30px">
							<input type="text" placeholder="价格" name="sprice" id="sprice" required="required"/>
						</div>

						<button type="submit" class="btn subscrib-btnn">新增</button>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<a type="button" class="btn btn-secondary" data-dismiss="modal" href="${pageContext.request.contextPath}/Drug?method=QueryDrugByPage">返回</a>
		</div>
	</div>
</div>
</body>
</html>

