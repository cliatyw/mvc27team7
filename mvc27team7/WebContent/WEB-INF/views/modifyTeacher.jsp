<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>modifyTeacher.jsp</title>
</head>
<body>
	<%
	String teacher_no =(String)request.getAttribute("teacher_no");
	%>
	<h3>수정화면</h3>
	<form action="<%=request.getContextPath()%>/modifyTeacher.kdh" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<td><input type=hidden name="teacherNo" value="<%=teacher_no%>"><%=teacher_no%></td>
					<td><input type="text" size="20" name="teacherId"></td>
					<td><input type="text" size="20" name="teacherPw"></td>
					<input type="submit" value="확인">
				</tr>				
			</tbody>			
		</table>
	</form>
</body>
</html>