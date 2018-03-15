<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>modifyEmployee.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="<%=request.getContextPath() %>/kks/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/kks/css/font-awesome.min.css" media="screen" title="no title">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/kks/css/style.css" media="screen" title="no title">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			/* 폼 유효성 검사
			id 4자 이상, pw 4자 이상, 비밀번호 체크
			폼 submit */
			$("#employeeId").blur(function(){
				if($("#employeeId").val().length < 4){
					$("#idHelper").text("아이디는 4글자 이상입니다.");
				}else{
					$("#idHelper").text("");
				}
			});
			$("#employeePw").blur(function(){
				if($("#employeePw").val().length < 4){
					$("#pwHelper").text("비밀번호는 4글자 이상입니다.");
				}else{
					$("#pwHelper").text("");
				}
			});
			$("#employeePwCheck").blur(function(){
				if($("#employeePwCheck").val() !== $("#employeePw").val()){
					$("#pwCheckHelper").text("비밀번호를 확인해주세요.");
				}else{
					$("#pwCheckHelper").text("");
				}
			});
			$("#btn").click(function(){
				if($("#employeeId").val().length >= 4 && $("#employeePw").val().length >= 4 && $("#employeePwCheck").val() === $("#employeePw").val()){
					$("#modifyEmployeeForm").submit();
				}
				else{
					return;
				}
			});
		});
	</script>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1>직원 수정</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form" id="modifyEmployeeForm" method="post" action="<%=request.getContextPath() %>/modifyEmployee.kks">
				<input type="hidden" id="employeeNo" name="employeeNo" value="<%= request.getParameter("employeeNo") %>">
				<div class="form-group">
					<label for="InputId">아이디</label>
					<input type="text" id="employeeId" name="employeeId" class="form-control">
				</div>
				<span id="idHelper"></span>
				<div class="form-group">
					<label for="InputPw">비밀번호</label>
					<input type="password" id="employeePw" name="employeePw" class="form-control">
				</div>
				<span id="pwHelper"></span>
				<div class="form-group">
					<label for="InputPwCheck">비밀번호 확인</label>
					<input type="password" id="employeePwCheck" name="employeePwCheck" class="form-control">
				</div>
				<span id="pwCheckHelper"></span>
				<div class="form-group text-center">
					<button id="btn" type="button" class="btn btn-info">직원 수정<i class="fa fa-check spaceLeft"></i></button>
				</div>
			</form>
		</div>
	</article>
</body>
</html>