<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>modifyTeacher.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#teacherId").val().length<4){
					$("#idHelper").text("아이디는 4자이상");
				}else if($("#teacherPw").val().length<4){
					$("#pwHelper").text("비밀번호 4자이상");
				}else{
					$("#form").submit();
				}
			});
		});
	</script>
</head>
<body>
	<h3>수정화면</h3>
	<form id="form" action="${pageContext.request.contextPath}/modifyTeacher.kdh" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<td><input type=hidden name="teacherNo" value="${teacher_no}">${teacher_no}</td>
					<td><input type="text" size="20" name="teacherId" id="teacherId"><span id="idHelper"></span></td>
					<td><input type="text" size="20" name="teacherPw" id="teacherPw"><span id="pwHelper"></span></td>
					<button id="btn" type="button">수정확인</button>
				</tr>				
			</tbody>			
		</table>
	</form>
</body>
</html>