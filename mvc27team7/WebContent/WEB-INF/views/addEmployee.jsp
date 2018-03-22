<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			//no값이 null이면 입력처리 아니면 수정처리
			if($("#employeeNo").val() === ""){
				$("#head").text("직원 추가");
				$("#addEmployeeForm").attr("action", "addEmployee.kks");
				$("#btn").text("추가");
			}else{
				$("#head").text("직원 수정");
				$("#addEmployeeForm").attr("action", "modifyEmployee.kks");
				$("#btn").text("수정");
			}
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
					$("#addEmployeeForm").submit();
				}
				else{
					return;
				}
			});
		});
	</script>
	<h1 id="head" class="cover-heading"></h1>
	<form role="form" id="addEmployeeForm" method="post">
		<input type="hidden" id="employeeNo" name="employeeNo" value="${param.employeeNo}">
		<table class="table">
			<tr>
				<td><label for="InputId">아이디</label></td>
				<td>
					<input type="text" id="employeeId" name="employeeId" class="form-control">
					<span id="idHelper"></span>
				</td>
			</tr>
			<tr>
				<td><label for="InputPw">비밀번호</label></td>
				<td>
					<input type="password" id="employeePw" name="employeePw" class="form-control">
					<span id="pwHelper"></span>
				</td>
			</tr>
			<tr>
				<td><label for="InputPwCheck">비밀번호 확인</label></td>
				<td>
					<input type="password" id="employeePwCheck" name="employeePwCheck" class="form-control">
					<span id="pwCheckHelper"></span>
				</td>
			</tr>
		</table>
		<button id="btn" type="button" class="btn btn-lg btn-default"></button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>