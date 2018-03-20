<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addTeacherAddr.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
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
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	int count = (int)request.getAttribute("count");
	%>
	<form action="<%=request.getContextPath()%>/addTeacherAddr.kdh" method="post">
	<table border="1">
			<thead>
				<tr>
					<th>address</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<input type=hidden name="count" id="countId" value="<%=count%>">
					<input type=hidden name="teacher_no" value="<%=request.getParameter("send_no")%>">
					<td><input type="text" id="addressId"size="20" name="address"></td>
					<input type="submit" value="등록">
				</tr>				
			</tbody>			
	</table>
	</form>
</body>
</html>