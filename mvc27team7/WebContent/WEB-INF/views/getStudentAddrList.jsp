<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			//전체 체크박스 설정쿼리
			$("[name=checkAll]").click(function(){
				if($("[name=checkAll]").prop("checked")){
					$("[name=getStudentAddrNo]").prop("checked", true);
				}else{
					$("[name=getStudentAddrNo]").prop("checked", false);
				}
			});
		});
	</script>
	<h1 class="cover-heading">주소 목록</h1>
	<form action="${pageContext.request.contextPath}/removeStudentAddr.csu" method="post">
		<input type="hidden" name="studentNo" value="${param.studentNo}">
		<table class="table">
			<thead>
				<tr>
					<th><input type="checkbox" name="checkAll"></th>
					<th>아이디</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<!-- request에 담겨져 있는 employeeList를 가져와 list에 담는다. -->
				<c:forEach var="studentAddr" items="${list}">
					<tr>
						<td><input type="checkbox" name="getStudentAddrNo" value="${studentAddr.studentAddrNo}"></td>
						<td>${studentAddr.studentNo}</td>
						<td>${studentAddr.address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="submit" class="btn btn-lg btn-default" id="delete">삭제</button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>