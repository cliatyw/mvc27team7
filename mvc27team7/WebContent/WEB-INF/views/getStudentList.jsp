<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$(".delete").click(function(){
				if($(this).parents('tr').find('.studentPw').val() === "exist"){
					alert('주소가 존재하여 삭제할 수 없습니다.');
					$(this).attr("href", "#");
				}
			});
		});
	</script>
	<h1 class="cover-heading">학생 목록</h1>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>수정</th>
				<th>삭제</th>
				<th>주소 입력</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="student" items="${list}">
				<tr>
					<td>${student.studentNo}</td>
					<td>${student.studentId}</td>
					<td>****<input type="hidden" class="studentPw" value="${student.studentPw}"></td>
					<td><a href="${pageContext.request.contextPath}/modifyStudent.csu?studentNo=${student.studentNo}">수정</a></td>
					<td><a class="delete" href="${pageContext.request.contextPath}/removeStudent.csu?studentNo=${student.studentNo}">삭제</a></td>
					<td><a href="${pageContext.request.contextPath}/addStudentAddr.csu?studentNo=${student.studentNo}">주소 추가</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
		<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/getStudentList.csu?currentPage=1">[처음으로]</a>
	</c:if>
	
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/getStudentList.csu?currentPage=${currentPage-1}">[이전]</a>
	</c:if>	
	
	&nbsp; 
	
	
	<c:forEach var="a"  begin="1" end="${lastPage}">
		<a href="${pageContext.request.contextPath}/getStudentList.csu?currentPage=${a}">[${a}]</a>
	</c:forEach>
	
	&nbsp; 
	
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/getStudentList.csu?currentPage=${currentPage+1}">[다음]</a>
	</c:if>
	
		<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/getStudentList.csu?currentPage=${lastPage}">[끝으로]</a>
	</c:if>
	<br>
	
	
	
	<button type="button" class="btn btn-lg btn-default" onclick="location.href='${pageContext.request.contextPath}/addStudent.csu'">추가</button>
<jsp:include page="footer.jsp"></jsp:include>