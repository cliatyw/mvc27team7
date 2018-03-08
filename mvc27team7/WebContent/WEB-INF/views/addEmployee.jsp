<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<h1>addEmployee</h1>
	<form method="post" action="<%=request.getContextPath() %>/addEmployee.kks">
		guest_id : 
		<input type="text" id="guestId" name="guestId" class="">
		guestPw : 
		<input type="password" id="guestPw" name="guestPw" class="">
		guestPwCheck : 
		<input type="password" id="guestPwCheck" name="guestPwCheck" class="">
		
		<button type="button">게스트 추가</button>
	</form>
</body>
</html>