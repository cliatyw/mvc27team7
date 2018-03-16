<!-- [최상욱] -->
<%@page import="model.StudentAddr"%>
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
	ArrayList<StudentAddr>list = (ArrayList<StudentAddr>)request.getAttribute("list");
	%> 

	<body>
		<table class="table table-striped table-bordered table-hover">
		<caption>StudentList</caption>
			<thead>
				<tr>
					<th>student_addr_no</th>
					<th>student_no</th>
					<th>address</th>
					<th>삭제</th>
				</tr>
			</thead>
			<% 
			for(StudentAddr studentAddr : list){ 
			%> 
			<tbody>
				<tr class="success">
					<td><%=studentAddr.getStudentAddrNo()%></td>
					<td><%=studentAddr.getStudentNo()%></td>
					<td><%=studentAddr.getAddress()%></td>
					<td><a href="<%=request.getContextPath()%>/removeStudent.csu?studentNo=<%=studentAddr.getStudentNo()%>">삭제</a></td>
				</tr>
			</tbody>
			<% 
			} 
			%> 			
		</table>
	</body>
</html>