<!-- [김도희] -->
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
			<th>수정</th> <!-- TeacherDao.updateTeacher() -->
			<th>삭제</th> <!-- TeacherDao.deleteTeacher() -->
			<th>ADD TEACHER_ADDR</th><!-- TeacherAddrDao.insertGuestAddr() -->
		</tr>
	</thead>
	<tbody>
		<%
		request.setCharacterEncoding("euc-kr");
		/*리턴값(teacher의 no,id,pw)을 list에 담는다 */
		ArrayList<Teacher> list = (ArrayList)request.getAttribute("teacherList");
				
		for(Teacher teacher : list) {
		%>
			<tr>
				<td><%= teacher.getTeacherNo() %></td>
				<td><%= teacher.getTeacherId() %></td>
				<!-- select쿼리문에 비밀번호 값을 가져오지않는다 -->
				<td>****</td>
				<!-- modifyTeacher.kdh를 읽어들일 Controller파일생성 -->
				<td><a href="<%=request.getContextPath() %>/modifyTeacher.kdh?send_no=<%= teacher.getTeacherNo() %>">수정</a></td>
				<!-- removeTeacher.kdh를 읽어들일 Controller파일생성 -->
				<td><a href="<%=request.getContextPath() %>/removeTeacher.kdh?send_no=<%= teacher.getTeacherNo() %>">삭제</a></td>
				<td><a href="<%=request.getContextPath() %>/addTeacherAddr.kdh?send_no=<%= teacher.getTeacherNo() %>">주소추가</a></td>
			</tr>
		<%
		}
		%>
	</tbody>
	</table>
</body>
</html>