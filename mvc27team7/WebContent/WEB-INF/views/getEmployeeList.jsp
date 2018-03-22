<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#delete").click(function(){
				if($("#employeePw") === "null"){
					console.log($("#employeePw").val());
					alert('주소가 존재하여 삭제할 수 없습니다.');
				}
			});
		});
	</script>
	<h1 class="cover-heading">직원 목록</h1>
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
			<!-- request에 담겨져 있는 employeeList를 가져와 list에 담는다. -->
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>${employee.employeeNo}</td>
					<td>${employee.employeeId}</td>
					<td>****<input type="hidden" id="employeePw" value="${employee.employeePw}"></td>
					<td><a href="${pageContext.request.contextPath}/modifyEmployee.kks?employeeNo=${employee.employeeNo}">수정</a></td>
					<td><a id="delete" href="${pageContext.request.contextPath}/removeEmployee.kks?employeeNo=${employee.employeeNo}">삭제</a></td>
					<td><a href="${pageContext.request.contextPath}/addEmployeeAddr.kks?employeeNo=${employee.employeeNo}">주소 추가</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="footer.jsp"></jsp:include>
