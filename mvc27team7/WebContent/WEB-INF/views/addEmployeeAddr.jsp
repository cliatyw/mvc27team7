<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			//주소가 5개 이상일시 input박스 클리할때 경고창
			$("#employeeAddr").click(function(){
				if($("#excess").val() === "excess"){
					alert('더이상 추가 할 수 없습니다.');
					location.href='/mvc27team7/getEmployeeAddrList.kks?employeeNo=' + $("#employeeNo").val();
				}
			});
		});
	</script>
	<h1 id="cover-heading">주소 추가</h1>
	<form role="form" id="addEmployeeAddr" method="post" action="${pageContext.request.contextPath}/addEmployeeAddr.kks">
		<input type="hidden" id="employeeNo" name="employeeNo" value="${param.employeeNo}">
		<input type="hidden" id="excess" name="excess" value="${excess}">
		<table class="table">
			<tr>
				<td>주소 추가</td>
				<td><input type="text" id="employeeAddr" name="employeeAddr" class="form-control"></td>				
			</tr>
		</table>
		<button id="btn" type="submit" class="btn btn-lg btn-default">추가</button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>