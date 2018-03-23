<!-- [�ֻ��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html>
<title>AddStudentController.java</title>
<head>
	<script>
		$(document).ready(function() {
			if($("#studentNo").val() === ""){
				$("#head").text("�л� �߰�");
				$("#addStudentForm").attr("action", "addStudent.csu");
				$("#btn").text("�߰�");
			}else{
				$("#head").text("�л� ����");
				$("#addStudentForm").attr("action", "modifyStudent.csu");
				$("#btn").text("����");
			}
			
			$('#studentId').on('keyup', function() {
				if ($('#studentId').val().length < 4) {
					$("#idHelper").text("���̵� 4�� �̻� �����ּ���");
				} else {
					$("#idHelper").text(""); 
				}
			});
			$('#studentPw').on('keyup', function() {
				if ($('#studentPw').val().length < 4) {
					$("#pwHelper").text("��й�ȣ�� 4�� �̻� �����ּ���");
				} else {
					$("#pwHelper").text("");
				}
			});
			$('#studentPwCheck').on('keyup', function() {
				if ($('#studentPw').val() != $('#studentPwCheck').val()) {
					$("#pwcheckHelper").text("��й�ȣ�� �ٸ��ϴ�.");
				} else {
					$("#pwcheckHelper").text("��й�ȣ�� ��ġ�մϴ�.");
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
					<td><label for="InputId">���̵�</label></td>
					<td>
						<input type="text" id="studentId" name="studentId" class="form-control" placeholder="id">
						<div id = "idHelper">���̵� 4�� �̻� �����ּ���</div>
					</td>
				</tr>
				<tr>
					<td><label for="InputPw">��й�ȣ</label></td>
					<td>
						<input type="text" id="studentPw" name="studentPw" class="form-control" placeholder="PW">
						<div id = "pwHelper">��й�ȣ 4�� �̻� �����ּ���</div>
					</td>
				</tr>
				<tr>
					<td><label for="InputPwCheck">��й�ȣȮ��</label></td>
					<td>
						<input type="text" id="studentPwCheck" name="studentPwCheck" class="form-control" placeholder="PW CHECK">
						<div id = "pwcheckHelper">���Ȯ��</div>
					</td>
				</tr>
			</table>
			<button id="btn" type="button" class="btn btn-lg btn-default">����</button>
		</form>
<jsp:include page="footer.jsp"></jsp:include>





