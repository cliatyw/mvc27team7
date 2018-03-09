<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Employee" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>getEmployeeList.jsp</title>
</head>
<body>
	<div>
		<h1>직원 목록</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Employee> list = new ArrayList<>();
				/* request에 담겨져 있는 employeeList를 가져와 list에 담는다. */
				list = (ArrayList)request.getAttribute("employeeList");
				
				for(Employee employee : list){
				%>
					<tr>
						<td><%= employee.getEmployeeNo() %></td>
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