<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- java code�� taglib���� ��� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>getTeacherList.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<script>	
		$(document).ready(function(){				
			$(".btn").click(function(){
				if($("#address").val()!=""){
					alert('�ּҰ��� �־� ������ �Ұ����մϴ�');
				}	
			});							
		});  
	</script>
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
			<th>ADD TEACHER_ADDR</th><!-- TeacherAddrDao.i
			nsertGuestAddr() -->
		</tr>
	</thead>
	<tbody>
		<!-- ���ϰ�(teacher�� no,id,pw)�� list�� ��´� -->
		<input type="hidden" value="${address}" id="address">
		${address}
		<c:forEach var="teacher" items="${teacherList}">
			<tr>
				<td><c:out value="${teacher.teacherNo}"/></td>
				<td><c:out value="${teacher.teacherId}"/></td>
				<!-- select�������� ��й�ȣ ���� ���������ʴ´� -->
				<td>****</td>
				<!-- modifyTeacher.kdh�� �о���� Controller���ϻ��� -->
				<td><a href="${pageContext.request.contextPath}/modifyTeacher.kdh?send_no=${teacher.teacherNo}">����</a></td>
				<!-- removeTeacher.kdh�� �о���� Controller���ϻ��� -->
				<td><a href="${pageContext.request.contextPath}/removeTeacher.kdh?send_no=${teacher.teacherNo}" class="btn">����</a></td>
				<td><a href="${pageContext.request.contextPath}/addTeacherAddr.kdh?send_no=${teacher.teacherNo}">�ּ��߰�</a></td>
			</tr>
		</c:forEach>						
	</tbody>
	</table>
</body>
</html>