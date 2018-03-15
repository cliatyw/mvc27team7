<!-- [��⼺] -->
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
		<h1>���� ���</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>���̵�</th>
					<th>��й�ȣ</th>
					<th>����</th>
					<th>����</th>
					<th>�ּ� �Է�</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Employee> list = new ArrayList<>();
				/* request�� ����� �ִ� employeeList�� ������ list�� ��´�. */
				list = (ArrayList)request.getAttribute("employeeList");
				
				for(Employee employee : list){
				%>
					<tr>
						<td><%= employee.getEmployeeNo() %></td>
						<td><%=	employee.getEmployeeId() %></td>
						<td>****</td>
						<td><a href="<%=request.getContextPath() %>/modifyEmployee.kks?employeeNo=<%= employee.getEmployeeNo() %>">����</a></td>
						<td><a href="<%=request.getContextPath() %>/removeEmployee.kks?employeeNo=<%= employee.getEmployeeNo() %>">����</a></td>
						<td><a href="<%=request.getContextPath() %>/addEmployeeAddr.kks?employeeNo=<%= employee.getEmployeeNo() %>">�ּ� �߰�</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>