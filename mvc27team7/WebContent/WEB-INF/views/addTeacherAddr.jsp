<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addTeacherAddr.jsp</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	%>
	<form action="<%=request.getContextPath()%>/addTeacherAddr.kdh" method="post">
	<table border="1">
			<thead>
				<tr>
					<th>address</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<input type=hidden name="teacher_no" value="<%=request.getAttribute("teacher_no")%>">
					<td><input type="text" size="20" name="address"></td>
					<input type="submit" value="등록">
				</tr>				
			</tbody>			
	</table>
	</form>
</body>
</html>