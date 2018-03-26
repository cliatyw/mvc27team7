<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:include page="header.jsp"></jsp:include>
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
	<h1 id="head" class="cover-heading">addTeacher</h1>
			<form id="form" method="post" action="${pageContext.request.contextPath}/addTeacher.kdh">
					<table class="table">				       
						<tr>
				          <td><label for="InputId">아이디</label></td>
				          <td>
				          	<input type="text" id="teacherId" name="teacherId" class="form-control"><span id="idHelper"></span>
				          </td>
				        </tr>				        
				        <tr>
				          <td><label for="InputPw">비밀번호</label></td>
				          <td>
				          	<input type="text" id="teacherPw" name="teacherPw" class="form-control"><span id="pwHelper"></span>
				          </td>
				        </tr>				       
				        <tr>
				          <td><label for="InputPwCheck">비밀번호 확인</label></td>
				          <td>
				          	<input type="text" id="teacherPwCheck" name="teacherPwCheck" class="form-control"><span id="checkHelper"></span>	
				          </td>
				        </tr>				       
				    </table>
				<button id="btn" type="button" class="btn btn-default btn-lg">선생님추가</button>
			</form>	
<jsp:include page="footer.jsp"></jsp:include>