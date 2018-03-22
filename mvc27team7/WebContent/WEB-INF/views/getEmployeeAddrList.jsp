<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getEmployeeList.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("[name=checkAll]").click(function(){
				if($("[name=checkAll]").prop("checked")){
					$("[name=getEmployeeAddrNo]").prop("checked", true);
				}else{
					$("[name=getEmployeeAddrNo]").prop("checked", false);
				}
			});
		});
	</script>
</head>
<body>
	<div>
		<h1>주소 목록</h1>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/removeEmployeeAddr.kks" method="post">
			<input type="hidden" name="employeeNo" value="${param.employeeNo}">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" name="checkAll"></th>
						<th>아이디</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
					<!-- request에 담겨져 있는 employeeList를 가져와 list에 담는다. -->
					<c:forEach var="employeeAddr" items="${list}">
						<tr>
							<td><input type="checkbox" name="getEmployeeAddrNo" value="${employeeAddr.employeeAddrNo}"></td>
							<td>${employeeAddr.employeeNo}</td>
							<td>${employeeAddr.address}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" id="delete" value="삭제버튼">
		</form>
	</div>
</body>
</html>