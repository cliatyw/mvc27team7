<!-- [�赵��] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#btn").click(function(){
				if($("#teacherId").val().length<4){
					$("#idHelper").text("�̸��� 4�� �̻�");
				}else if($("#teacherPw").val().length<4){
					$("#pwHelper").text("��й�ȣ 4�� �̻�");
				}else if($("#teacherPwCheck").val()!=$("#teacherPw").val()){
					$("#checkHelper").text("��й�ȣ ��ġ ��Ȯ��");																				
				}else{
					$("#form").submit();
				}
			});
		});
	</script>
	<h1 id="head" class="cover-heading">addTeacher</h1>
			<form id="form" method="post" action="${pageContext.request.contextPath}/addTeacher.kdh">
					<table class="table">				       
						<tr>
				          <td><label for="InputId">���̵�</label></td>
				          <td>
				          	<input type="text" id="teacherId" name="teacherId" class="form-control"><span id="idHelper"></span>
				          </td>
				        </tr>				        
				        <tr>
				          <td><label for="InputPw">��й�ȣ</label></td>
				          <td>
				          	<input type="text" id="teacherPw" name="teacherPw" class="form-control"><span id="pwHelper"></span>
				          </td>
				        </tr>				       
				        <tr>
				          <td><label for="InputPwCheck">��й�ȣ Ȯ��</label></td>
				          <td>
				          	<input type="text" id="teacherPwCheck" name="teacherPwCheck" class="form-control"><span id="checkHelper"></span>	
				          </td>
				        </tr>				       
				    </table>
				<button id="btn" type="button" class="btn btn-default btn-lg">�������߰�</button>
			</form>	
<jsp:include page="footer.jsp"></jsp:include>