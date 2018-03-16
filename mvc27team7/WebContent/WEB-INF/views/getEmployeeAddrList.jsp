<!-- [김기성] -->
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
		<h1>주소 목록</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<EmployeeAddr> list = new ArrayList<>();
				/* request에 담겨져 있는 employeeList를 가져와 list에 담는다. */
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