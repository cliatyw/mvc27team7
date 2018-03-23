<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html>
<title>AddStudentController.java</title>
<head>
	<script>
		$(document).ready(function() {
			if($("#studentNo").val() === ""){
				$("#head").text("학생 추가");
				$("#addStudentForm").attr("action", "addStudent.csu");
				$("#btn").text("추가");
			}else{
				$("#head").text("학생 수정");
				$("#addStudentForm").attr("action", "modifyStudent.csu");
				$("#btn").text("수정");
			}
			
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
				if($("#studentId").val().length >= 4 && $("#studentPw").val().length >= 4 && $("#studentPwCheck").val() === $("#studentPw").val()){
					$("#addStudentForm").submit();
				} else {
				return;
				}
			});

		});
	</script>
	
</head>
<body>
	<h1 id="head" class="cover-heading"></h1>
		<form role="form" id="addStudentForm" method="post">
		<input type="hidden" name="studentNo" id="studentNo" value="${param.studentNo}">
			<table class="table">
				<tr>
					<td><label for="InputId">아이디</label></td>
					<td>
						<input type="text" id="studentId" name="studentId" class="form-control" placeholder="id">
						<div id = "idHelper">아이디를 4자 이상 적어주세요</div>
					</td>
				</tr>
				<tr>
					<td><label for="InputPw">비밀번호</label></td>
					<td>
						<input type="text" id="studentPw" name="studentPw" class="form-control" placeholder="PW">
						<div id = "pwHelper">비밀번호 4자 이상 적어주세요</div>
					</td>
				</tr>
				<tr>
					<td><label for="InputPwCheck">비밀번호확인</label></td>
					<td>
						<input type="text" id="studentPwCheck" name="studentPwCheck" class="form-control" placeholder="PW CHECK">
						<div id = "pwcheckHelper">비번확인</div>
					</td>
				</tr>
			</table>
			<button id="btn" type="button" class="btn btn-lg btn-default">가입</button>
		</form>
<jsp:include page="footer.jsp"></jsp:include>





