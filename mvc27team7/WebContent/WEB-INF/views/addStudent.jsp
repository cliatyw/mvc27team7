<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<title>AddStudentController.java</title>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		body{padding: 0; margin: 0; background-color: #efefef !important;}
		.panel{margin-botton:0 !important;}
		h2{text-align: center}
	</style>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#studentId').on('keyup', function() {
				if ($('#studentId').val().length < 4) {
					$("#idHelper").text("아이디를 4자 이상 적어주세요");
					$("div.studentId").addClass("has-error").removeClass("has-success");
				} else {
					$("#idHelper").text(""); 
					$("div.studentId").removeClass("has-error").addClass("has-success");
				}
			});
			$('#studentPw').on('keyup', function() {
				if ($('#studentPw').val().length < 4) {
					$("#pwHelper").text("비밀번호를 4자 이상 적어주세요");
					$("div.studentPw").addClass("has-error").removeClass("has-success");
				} else {
					$("#pwHelper").text("");
					$("div.studentPw").removeClass("has-error").addClass("has-success");
				}
			});
			$('#studentPwCheck').on('keyup', function() {
				if ($('#studentPw').val() != $('#studentPwCheck').val()) {
					$("#pwcheckHelper").text("비밀번호가 다릅니다.");
					$("div.studentPwCheck").addClass("has-error").removeClass("has-success");
				} else {
					$("#pwcheckHelper").text("비밀번호가 일치합니다.");
					$("div.studentPwCheck").removeClass("has-error").addClass("has-success");
				}
	
			});
			$("#btn").click(function() {
				if($("#studentId").val().length >= 4 && $("#studentPw").val().length >= 4 && $("#studentPwCheck").val() === $("#studentPw").val()){
					$("#myform").submit();
				} else {
				return;
				}
			});
			
		});
	</script>
	
</head>
<body>
	<div class="row">
		<div class="col-md-3" ></div>		
			<div class="col-sm-6">
			<h2>addStudent</h2>
			<form action="<%=request.getContextPath()%>/addStudent.csu" id="myform" method = "post">
				<div class="panel panel-default">
					<div class="panel-body form-horizontal">
						<div class="studentId form-group has-error">
							<label class="col-sm-4 control-label" for="studentId">STUDENT ID</label>
							<div class="col-sm-8">
								<input type="text" name="studentId" id="studentId" class="form-control" placeholder="id">
								<div id = "idHelper">아이디를 4자 이상 적어주세요</div>
							</div>
						</div>
  						<div class="studentPw form-group has-error">
  							<label class="col-sm-4 control-label" for="studentPd">STUDENT PW</label>
							<div class="col-sm-8">
								<input class="form-control" name="studentPw" id="studentPw" type="password" placeholder="PW">							
								<div id = "pwHelper">비밀번호를 4자 이상 적어주세요</div>
							</div>
						</div>	
						<div class="studentPwCheck form-group has-error">
  							<label class="col-sm-4 control-label" for="inputEmail">PW CHECK</label>
							<div class="col-sm-8">
								<input class="form-control" id="studentPwCheck" type="password" placeholder="PW CHECK" >
								<div id = "pwcheckHelper"></div>
							</div>
						</div>
						<button id = "btn" class="btn btn-primary" type="button">회원가입</button>
						<span id = "check"></span>
					</div>
				</div>
			</form>	
			</div>	
		<div class="col-sm-3"></div>
	</div>
</body>
</html>

