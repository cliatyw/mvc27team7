<%@page import="model.TeacherAddr"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>getTeacherAddrList.jsp</title>
</head>
<body>
	<table border="1">
	<thead>
		<tr>
			<th>teacher_addr_no</th>
			<th>teacher_no</th>
			<th>address</th>
		</tr>
	</thead>
	<tbody>
	<%
	ArrayList<TeacherAddr> list= (ArrayList<TeacherAddr>)request.getAttribute("list");
	for(TeacherAddr teacheraddr : list) {
	%>
		<tr>
			<td><%= teacheraddr.getTeacherAddrNo()%></td>
			<td><%= teacheraddr.getTeacherNo()%></td>
			<td><%= teacheraddr.getAddress()%></td>
		</tr>
	<%
	}
	%>	
	</tbody>
</body>
</html>