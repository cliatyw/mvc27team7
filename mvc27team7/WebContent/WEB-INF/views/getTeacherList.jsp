<!-- [�赵��] -->
<%@page import = "model.Teacher" %>
<%@page import = "model.TeacherDao" %>
<%@page import = "java.util.ArrayList" %>
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
			<th>����</th> <!-- TeacherDao.updateTeacher() -->
			<th>����</th> <!-- TeacherDao.deleteTeacher() -->
			<th>ADD TEACHER_ADDR</th><!-- TeacherAddrDao.insertGuestAddr() -->
		</tr>
	</thead>
	<tbody>
		<%
		request.setCharacterEncoding("euc-kr");
		/*���ϰ�(teacher�� no,id,pw)�� list�� ��´� */
		ArrayList<Teacher> list = (ArrayList)request.getAttribute("teacherList");
				
		for(Teacher teacher : list) {
		%>
			<tr>
				<td><%= teacher.getTeacherNo() %></td>
				<td><%= teacher.getTeacherId() %></td>
				<!-- select�������� ��й�ȣ ���� ���������ʴ´� -->
				<td>****</td>
				<!-- modifyTeacher.kdh�� �о���� Controller���ϻ��� -->
				<td><a href="<%=request.getContextPath() %>/modifyTeacher.kdh?send_no=<%= teacher.getTeacherNo() %>">����</a></td>
				<!-- removeTeacher.kdh�� �о���� Controller���ϻ��� -->
				<td><a href="<%=request.getContextPath() %>/removeTeacher.kdh?send_no=<%= teacher.getTeacherNo() %>">����</a></td>
				<td><a href="<%=request.getContextPath() %>/addTeacherAddr.kdh?send_no=<%= teacher.getTeacherNo() %>">�ּ��߰�</a></td>
			</tr>
		<%
		}
		%>
	</tbody>
	</table>
</body>
</html>