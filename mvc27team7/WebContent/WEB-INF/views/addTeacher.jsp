<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>addTeacher</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<script>
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#teacherId").val().length<4){
					$("#idHelper").text("이름은 4자 이상");
				}else if($("#teacherPw").val().length<4){
					$("#pwHelper").text("비밀번호 4자 이상");
				}else if($("#teacherPwCheck").val()!=$("#teacherPw").val()){
					$("#checkHelper").text("비밀번호 일치 재확인");																				
				}else{
					$("#form").submit();
				}
			});
		});
	</script>
	<style>
		body {
	    	background-color: #FFD9EC;
		}
	</style>
</head>
<body>
	<img src="${pageContext.request.contextPath} class="img-circle" alt="Responsive image" width = "30%">
	<h1>addTeacher</h1>
		<div class="col-lg-4">	
			<form id="form" method="post" action="${pageContext.request.contextPath}/addTeacher.kdh">
				<div class="bs-example"  data-example-id="contextual-table">
					<table class="table">				       
						<tr class="info">
							<th scope="row">teacher_id</th>
				          <td>
				          	<input type="text" id="teacherId" name="teacherId" class="id"><span id="idHelper"></span>
				          </td>
				        </tr>				        
				        <tr class="warning">
				          <th scope="row">teacher_pw</th>
				          <td>
				          	<input type="text" id="teacherPw" name="teacherPw" class="pw"><span id="pwHelper"></span>
				          </td>
				        </tr>				       
				        <tr class="danger">
				          <th scope="row">teacher_pw확인</th>
				          <td>
				          	<input type="text" id="teacherPwCheck" name="teacherPwCheck" class="check"><span id="checkHelper"></span>	
				          </td>
				        </tr>				       
				    </table>
			  	</div>			
				<button id="btn" type="button" class="btn btn-default btn-lg btn-block">선생님추가</button>
			</form>
		</div>
</body>
</html>