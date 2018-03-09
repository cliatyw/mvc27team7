<!-- [��⼺] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Employee" %>
<%
	ArrayList<Employee> list = new ArrayList<>();
	list = (ArrayList)request.getAttribute("employeeList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>getEmployeeList.jsp</title>
</head>
<body>
	<div>
		<h1>���� ���</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>���̵�</th>
					<th>��й�ȣ</th>
				</tr>
			</thead>
			<tbody>
				<% 
					for(Employee employee : list){
				%>
				<tr>
					<td><%=	employee.getEmployeeId() %></td>
					<td><%= employee.getEmployeePw() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	
</body>
</html>