<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#addressId").click(function(){
				if($("#countId").val()>=5){
					alert('�ּҰ� 5�� �̻��Դϴ�');
					location.href='/mvc27team7/getTeacherAddrList.kdh?teacher_no=<%=request.getParameter("send_no")%>';
				}
			});
		});
	</script>
	<h1 id="cover-heading">�ּ� �߰�</h1>
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
					<input type="submit" value="���">
				</tr>				
			</tbody>			
	</table>
	</form>
<jsp:include page="footer.jsp"></jsp:include>