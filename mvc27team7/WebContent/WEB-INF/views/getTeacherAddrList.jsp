<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/removeTeacherAddr.kdh" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>teacher_addr_no</th>
				<th>teacher_no</th>
				<th>address</th>
				<th>����</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teacher" items="${list}">
				<tr>
						<td><c:out value="${teacher.teacherAddrNo}"/></td>
						<td><input type="hidden" value="${teacher.teacherNo}" name="teacher_no"><c:out value="${teacher.teacherNo}"/></td>
						<td><c:out value="${teacher.address}"/></td>
						<td><input type="checkbox" name="del_check" value="${teacher.teacherAddrNo}"></td>
					</tr>	
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" value="����">
<jsp:include page="footer.jsp"></jsp:include>