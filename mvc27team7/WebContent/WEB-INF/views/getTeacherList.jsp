<!-- [�赵��] -->
<%@page import = "java.util.ArrayList" %>
<%@page import = "model.TeacherDao" %>
<%@page import = "model.Teacher" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>getTeacherList.jsp</title>
</head>
<body>
	<h1>TeacherList</h1>
	<table border="1">
	<thead>
		<tr>
			<th>teacher_no</th>
			<th>teacher_id</th>
			<th>teacher_pw</th>
		</tr>
	</thead>
	<tbody>
		<%
		/*list��ȸ �޼ҵ� ȣ���� ���ϰ�(teacher�� no,id,pw)�� list�� ��´� */
		TeacherDao teacherdao = new TeacherDao();
		ArrayList<Teacher> list = teacherdao.selectTeacherList();
		
		for(Teacher teacher : list) {
		%>
			<tr>
				<td><%= teacher.getTeacherNo() %></td>
				<td><%= teacher.getTeacherId() %></td>
				<td><%= teacher.getTeacherPw() %></td>
			</tr>
		<%
		}
		%>
	</tbody>
	</table>
</body>
</html>