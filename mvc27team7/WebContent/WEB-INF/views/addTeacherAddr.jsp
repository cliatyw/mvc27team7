<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#addressId").click(function(){
				if($("#countId").val()>=5){
					alert('주소가 5개 이상입니다');
					location.href='/mvc27team7/getTeacherAddrList.kdh?teacher_no=<%=request.getParameter("send_no")%>';
				}
			});
		});
	</script>
	<h1 id="cover-heading">주소 추가</h1>
	<form action="${pageContext.request.contextPath}/addTeacherAddr.kdh" method="post">
	<table class="table">
			<thead>
				<tr>
					<th>address</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<input type=hidden name="count" id="countId" value="${count}" class="form-control">
					<input type=hidden name="teacher_no" value="${param.send_no}" class="form-control">
					<td><input type="text" id="addressId"size="20" name="address" class="form-control"></td>		
				</tr>				
			</tbody>			
	</table>
	<button id="btn" type="submit" class="btn btn-lg btn-default">추가</button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>