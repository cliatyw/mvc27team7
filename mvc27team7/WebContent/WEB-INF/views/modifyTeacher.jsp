<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#teacherId").val().length<4){
					$("#idHelper").text("���̵�� 4���̻�");
				}else if($("#teacherPw").val().length<4){
					$("#pwHelper").text("��й�ȣ 4���̻�");
				}else{
					$("#form").submit();
				}
			});
		});
	</script>
	<h3>����ȭ��</h3>
	<form id="form" action="${pageContext.request.contextPath}/modifyTeacher.kdh" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>teacher_no</th>
					<th>teacher_id</th>
					<th>teacher_pw</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<td><input type=hidden name="teacherNo" value="${teacher_no}">${teacher_no}</td>
					<td><input type="text" size="20" name="teacherId" id="teacherId"><span id="idHelper"></span></td>
					<td><input type="text" size="20" name="teacherPw" id="teacherPw"><span id="pwHelper"></span></td>
					<button id="btn" type="button">����Ȯ��</button>
				</tr>				
			</tbody>			
		</table>
	</form>
<jsp:include page="footer.jsp"></jsp:include>