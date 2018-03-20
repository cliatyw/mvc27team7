<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addTeacherAddr.jsp</title>
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#address').val("");

			if($("#addressclick").val() === "addressclick"){
				$("#address").click(function(){
					alert("5개까지");
					location.href='/mvc27team7/getStudentListAddr.csu?studentNo=<%=request.getAttribute("studentNo")%>';
				});
			}
		});
	</script>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	%>
	<form action="<%=request.getContextPath()%>/addStudentAddr.csu" method="post">
	<table class="table table-striped table-bordered table-hover">
			<caption>StudentAddrList</caption>
			<thead>
				<tr>
					<th>studentNo</th>
					<th>address</th>
				</tr>			
			</thead>
			<tbody>
				<tr class="success">
					<input type="hidden" id="addressclick" name="addressclick" value="<%= request.getAttribute("addressclick") %>">
					<% System.out.println(request.getAttribute("addressclick"));%>
					<td><input type="text" name="studentNo" value="<%=request.getAttribute("studentNo")%>"></td>
					<td><input type="text" size="20" name="address" id="address" ></td>
					<td><input type="submit" value="등록"></td>
				</tr>				
			</tbody>			
	</table>
	</form>
</body>
</html>