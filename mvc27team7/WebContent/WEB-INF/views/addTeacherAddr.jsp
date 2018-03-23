<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#addressId").click(function(){
				if($("#countId").val()>=5){
					alert('주소가 5개 이상입니다');
					location.href='/mvc27team7/getTeacherAddrList.kdh?teacher_no=<%=request.getParameter("send_no")%>';
				}
			});
		});
	</script>
	<h1 id="cover-heading">주소 추가</h1>
	<form action="${pageContext.request.contextPath}/addTeacherAddr.kdh" method="post">
	<table border="1">
			<thead>
				<tr>
					<th>address</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<input type=hidden name="count" id="countId" value="${count}">
					<input type=hidden name="teacher_no" value="${param.send_no}">
					<td><input type="text" id="addressId"size="20" name="address"></td>
					<input type="submit" value="등록">
				</tr>				
			</tbody>			
	</table>
	</form>
<jsp:include page="footer.jsp"></jsp:include>