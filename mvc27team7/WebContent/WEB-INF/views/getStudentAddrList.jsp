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
		<form method="post" action="/mvc27team7/studentAddrDelete.csu">
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
			for(int i=0; i<list.size(); i++){ 
			%> 
			<tbody>
				<tr class="success">
					<td><%=list.get(i).getStudentAddrNo()%></td>
					<td><%=list.get(i).getStudentNo()%></td>
					<td><%=list.get(i).getAddress()%></td>
					<td><input type ="checkbox" name=addrcheck value="<%=list.get(i).getStudentAddrNo()%>"></td>
					</tr>				
							
			<% 
			} 
			%> 		
			<tr class="success">
					<td>-------</td>
					<td>-------</td>
					<td>-------</td>
					<td><button>삭제</button></td>
					</tr>	
			
				
			</tbody>
		</table>
		</form>
	</body>
</html>