<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addEmployeeAddr.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="<%=request.getContextPath() %>/kks/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/kks/css/font-awesome.min.css" media="screen" title="no title">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/kks/css/style.css" media="screen" title="no title">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			//주소가 5개 이상일시 input박스 클리할때 경고창
			$("#employeeAddr").click(function(){
				if($("#excess").val() === "excess"){
					alert('더이상 추가 할 수 없습니다.');
					location.href='/mvc27team7/getEmployeeAddrList.kks?employeeNo=' + $("#employeeNo").val();
				}
			});
			
			$("#btn").click(function(){
				$("#addEmployeeAddr").submit();
			});
		});
	</script>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1 id="head">주소 추가</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form" id="addEmployeeAddr" method="post" action="${pageContext.request.contextPath}/addEmployeeAddr.kks">
				<input type="hidden" id="employeeNo" name="employeeNo" value="${param.employeeNo}">
				<input type="hidden" id="excess" name="excess" value="${excess}">
				<div class="form-group">
					<label for="InputAddr">주소 추가</label>
					<input type="text" id="employeeAddr" name="employeeAddr" class="form-control">
				</div>
				<div class="form-group text-center">
					<button id="btn" type="button" class="btn btn-info">추가<i class="fa fa-check spaceLeft"></i></button>
				</div>
			</form>
		</div>
	</article>
</body>
</html>