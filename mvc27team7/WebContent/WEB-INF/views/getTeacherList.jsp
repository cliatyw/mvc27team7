<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- java code를 taglib으로 사용 -->
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
			 var ccheck = $(".ccheck");
			 var tcheck = $(".tcheck"); 
			$(".btn").click(function(){				
				 for(var i=0;i<ccheck.length;i++){
					 if($(ccheck[i]).val()=== $(this).parents('tr').find('.tcheck').val()){
							alert('주소값이 있어 삭제가 불가능합니다');
						}
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
				<th>수정</th> <!-- TeacherDao.updateTeacher() -->
				<th>삭제</th> <!-- TeacherDao.deleteTeacher() -->
				<th>ADD TEACHER_ADDR</th><!-- TeacherAddrDao.i
				nsertGuestAddr() -->
			</tr>
		</thead>
		<tbody>
			<!-- 리턴값(teacher의 no,id,pw)을 list에 담는다 -->
			<c:forEach var="count" items="${list}">			
				<input type="hidden" value="${count.teacherNo}" class="ccheck">					
			</c:forEach>
			<c:forEach var="teacher" items="${teacherList}">
				<tr>
					<input type="hidden" value="${teacher.teacherNo}" class="tcheck">
					<td><c:out value="${teacher.teacherNo}"/></td>
					<td><c:out value="${teacher.teacherId}"/></td>
					<!-- select쿼리문에 비밀번호 값을 가져오지않는다 -->
					<td>****</td>
					<!-- modifyTeacher.kdh를 읽어들일 Controller파일생성 -->
					<td><a href="${pageContext.request.contextPath}/modifyTeacher.kdh?send_no=${teacher.teacherNo}">수정</a></td>
					<!-- removeTeacher.kdh를 읽어들일 Controller파일생성 -->
					<td><a href="${pageContext.request.contextPath}/removeTeacher.kdh?send_no=${teacher.teacherNo}" class="btn">삭제</a></td>
					<td><a href="${pageContext.request.contextPath}/addTeacherAddr.kdh?send_no=${teacher.teacherNo}">주소추가</a></td>
				</tr>
			</c:forEach>						
		</tbody>
	</table>
	<c:if test="${currentPage>1}">	
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage-currentPage}">맨처음</a>
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage-1}">이전</a>
	</c:if>	
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${currentPage+1}">다음</a>
		<a href="${pageContext.request.contextPath}/getTeacherList.kdh?currentPage=${lastPage}">맨끝</a>
	</c:if>
</body>
</html>