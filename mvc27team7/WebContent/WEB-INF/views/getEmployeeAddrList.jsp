<!-- [��⼺] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>getEmployeeList.jsp</title>
</head>
<body>
	<div>
		<h1>�ּ� ���</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>���̵�</th>
					<th>�ּ�</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<EmployeeAddr> list = new ArrayList<>();
				/* request�� ����� �ִ� employeeList�� ������ list�� ��´�. */
				list = (ArrayList)request.getAttribute("employeeList");
				
				for(EmployeeAddr employeeAddr : list){
				%>
					<tr>
						<td><%=	employeeAddr.getAddress() %></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>