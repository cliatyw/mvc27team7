<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<script>
	$(document).ready(function(){
		//폼 유효성 검사 후 폼을 submit
		//id 4글자이상, pw 4글자이상. pw체크확인
		//폼 submit
	});
	</script>
</head>
<body>
	<h1>addStudent</h1>
	<form action = "<%=request.getContextPath() %>/addStudent.csu">
		student_id : 
		<input type = "text" id = "studentId" name = "studentId" class = "">
		student_pw : 
		<input type = "password" id = "studentPw" name = "studentPw" class = "">
		student_pw확인 : 
		<input type = "password" id = "studentPwCheck" name = "studentPwCheck" class = "">
		<button type = "button">학생 추가</button>
		
	</form>
</body>
</html>