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
	<form action="<%=request.getContextPath() %>/removeTeacherAddr.kdh" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>teacher_addr_no</th>
				<th>teacher_no</th>
				<th>address</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
	<%
	ArrayList<TeacherAddr> list= (ArrayList<TeacherAddr>)request.getAttribute("list");
	for(int i=0; i<list.size();i++) {
	%>
			<tr>
				<td><%= list.get(i).getTeacherAddrNo()%></td>
				<td><input type="hidden" value="<%= list.get(i).getTeacherNo()%>" name="teacher_no"><%= list.get(i).getTeacherNo()%></td>
				<td><%= list.get(i).getAddress()%></td>
				<td><input type="checkbox" name="del_check" value="<%=list.get(i).getTeacherAddrNo()%>"></td>
			</tr>	
	<%
	}
	%>	
		</table>
	<input type="submit" value="삭제">
	</tbody>
</body>
</html>