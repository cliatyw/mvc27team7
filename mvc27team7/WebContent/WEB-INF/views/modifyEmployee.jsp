<!-- [��⼺] -->
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
			/* �� ��ȿ�� �˻�
			id 4�� �̻�, pw 4�� �̻�, ��й�ȣ üũ
			�� submit */
			$("#employeeId").blur(function(){
				if($("#employeeId").val().length < 4){
					$("#idHelper").text("���̵�� 4���� �̻��Դϴ�.");
				}else{
					$("#idHelper").text("");
				}
			});
			$("#employeePw").blur(function(){
				if($("#employeePw").val().length < 4){
					$("#pwHelper").text("��й�ȣ�� 4���� �̻��Դϴ�.");
				}else{
					$("#pwHelper").text("");
				}
			});
			$("#employeePwCheck").blur(function(){
				if($("#employeePwCheck").val() !== $("#employeePw").val()){
					$("#pwCheckHelper").text("��й�ȣ�� Ȯ�����ּ���.");
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
			<h1>���� ����</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form" id="modifyEmployeeForm" method="post" action="<%=request.getContextPath() %>/modifyEmployee.kks">
				<input type="hidden" id="employeeNo" name="employeeNo" value="<%= request.getParameter("employeeNo") %>">
				<div class="form-group">
					<label for="InputId">���̵�</label>
					<input type="text" id="employeeId" name="employeeId" class="form-control">
				</div>
				<span id="idHelper"></span>
				<div class="form-group">
					<label for="InputPw">��й�ȣ</label>
					<input type="password" id="employeePw" name="employeePw" class="form-control">
				</div>
				<span id="pwHelper"></span>
				<div class="form-group">
					<label for="InputPwCheck">��й�ȣ Ȯ��</label>
					<input type="password" id="employeePwCheck" name="employeePwCheck" class="form-control">
				</div>
				<span id="pwCheckHelper"></span>
				<div class="form-group text-center">
					<button id="btn" type="button" class="btn btn-info">���� ����<i class="fa fa-check spaceLeft"></i></button>
				</div>
			</form>
		</div>
	</article>
</body>
</html>