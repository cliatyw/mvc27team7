<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
			} else {
				$("#idHelper").text("");
			}
		});
		$('#studentPw').on('keyup', function() {
			if ($('#studentPw').val().length < 4) {
				$("#pwHelper").text("비밀번호를 4자 이상 적어주세요");
			} else {
				$("#pwHelper").text("");
			}
		});
		$('#studentPwCheck').on('keyup', function() {
			if ($('#studentPw').val() != $('#studentPwCheck').val()) {
				$("#pwcheckHelper").text("비밀번호가 다릅니다.");
			} else {
				$("#pwcheckHelper").text("비밀번호가 일치합니다.");
			}

		});
		$("#btn").click(function() {
			if ($("#idHelper").val()=="" && $("#pwHelper").val()=="" && $("#pwcheckHelper").val()=="비밀번호가 일치합니다.") {
				$("#myform").submit();
			} else  {
				$("#check").text("확인해주세요");
			}
		});
	});
</script>
</head>
<body>
<h2>addStudent</h2>
	<div class="row">
		<div class="col-md-3" ></div>
		
			<div class="col-sm-6">
			<form action="<%=request.getContextPath()%>/addStudent.csu" id="myform">
				<div class="panel panel-default">
					<div class="panel-body form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentId">studentid</label>
							<div class="col-sm-6">
								<input type="text" name="studentId" id="studentId" class="form-control" placeholder="id">
							</div>
							<span id = "idHelper"></span>
						</div>
	  						<div class="form-group">
	  							<label class="col-sm-2 control-label" for="studentPd">STUDENT PW</label>
							<div class="col-sm-6">
								<input class="form-control" id="studentPw" type="password" placeholder="PW" name="password" >
							</div>
							<span id = "pwHelper"></span>
						</div>	
						<div class="form-group">
	  							<label class="col-sm-2 control-label" for="inputEmail">PW CHECK</label>
							<div class="col-sm-6">
								<input class="form-control" id="studentPwCheck" type="password" placeholder="PW 재입력" value="" >
								<span id = "pwcheckHelper"></span>
							</div>
						</div>
						<button id = "btn" class="btn btn-primary" type="submit">회원가입</button>
						<span id = "check"></span>
					</div>
				</div>
				</form>	
			</div>	
		
		<div class="col-sm-3"></div>
	</div>
</body>
</html>

