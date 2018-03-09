<!-- [최상욱] -->
<%@page import="model.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>getStudentList.jsp</title>
</head>
	<% 
	ArrayList<Student>list = (ArrayList<Student>)request.getAttribute("list");
	%> 

	<body>
		<table class="table table-striped table-bordered table-hover">
		<caption>StudentList</caption>
			<thead>
				<tr>
					<th>studentNo</th>
					<th>studentId</th>
					<th>studentPw</th>
				</tr>
			</thead>
			<% 
			for(Student student : list){ 
			%> 
			<tbody>
				<tr class="success">
					<td><%=student.getStudentNo()%></td>
					<td><%=student.getStudentId()%></td>
					<td><%=student.getStudentPw()%></td>
				</tr>
			</tbody>
			<% 
			} 
			%> 
			
		</table>
	</body>
</html>

