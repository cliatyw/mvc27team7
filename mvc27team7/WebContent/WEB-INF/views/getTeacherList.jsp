<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- java code�� taglib���� ��� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:include page="header.jsp"></jsp:include>
	<script>	
		$(document).ready(function(){				
			 var ccheck = $(".ccheck");
			 var tcheck = $(".tcheck"); 
			$(".btn").click(function(){				
				 for(var i=0;i<ccheck.length;i++){
					 if($(ccheck[i]).val()=== $(this).parents('tr').find('.tcheck').val()){
							alert('�ּҰ��� �־� ������ �Ұ����մϴ�');
						}
				 }	
			});					
		});  
	</script>
	<h1 class="cover-heading">TeacherList</h1>
	<table class="table">
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
			<c:forEach var="count" items="${list}">			
				<input type="hidden" value="${count.teacherNo}" class="ccheck">					
			</c:forEach>
			<c:forEach var="teacher" items="${teacherList}">
				<tr>
					<input type="hidden" value="${teacher.teacherNo}" class="tcheck">
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
	<c:if test="${currentPage>1}">	
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage-currentPage}">��ó��</a>
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage-1}">����</a>
	</c:if>	
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage+1}">����</a>
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${lastPage}">�ǳ�</a>
	</c:if><br>
	<button type="button" class="btn btn-lg btn-default" onclick="location.href='${pageContext.request.contextPath}/addTeacher.kdh'">�߰�</button>
<jsp:include page="footer.jsp"></jsp:include>