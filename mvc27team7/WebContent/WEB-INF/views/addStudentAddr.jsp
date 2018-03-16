<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addTeacherAddr.jsp</title>
</head>
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
					<td><input type="text" name="studentNo" value="<%=request.getAttribute("studentNo")%>"></td>
					<td><input type="text" size="20" name="address"></td>
					<td><input type="submit" value="등록"></td>
				</tr>				
			</tbody>			
	</table>
	</form>
</body>
</html>