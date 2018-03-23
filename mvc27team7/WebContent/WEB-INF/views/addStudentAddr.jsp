<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#studentAddr").click(function(){
				if($("#excess").val() === "excess"){
					alert('더이상 추가 할 수 없습니다.');
					location.href='/mvc27team7/getStudentAddrList.csu?studentNo=' + $("#studentNo").val();
				}
			});
			
			$("#btn").click(function(){
				$("#addStudentAddr").submit();
			});
		});
	</script>
	<h1 id="cover-heading">주소 추가</h1>
	<form action="${pageContext.request.contextPath}/addStudentAddr.csu" method="post" role="form" id="addStudentAddr" >
	<input type="hidden" id="studentNo" name="studentNo" value="${param.studentNo}">
		<input type="hidden" id="excess" name="excess" value="${excess}">
		<table class="table">
			<tr>
				<td>주소 추가</td>
				<td><input type="text" id="studentAddr" name="studentAddr" class="form-control"></td>				
			</tr>
		</table>
		<button id="btn" type="button" class="btn btn-lg btn-default">추가</button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>