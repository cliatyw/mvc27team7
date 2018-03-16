<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/modifyStudent.csu" method="post">
		<table border="1">
		<input type="hidden" name="studentNo" value="<%=request.getParameter("studentNo")%>">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="studentId" size="20" ></td>
		<tr>
		<tr>
			<td>암호</td>
			<td><input type="password" name="studentPw" size="20" ></td>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정완료"></td>
		</tr>
		</table>
	</form>
</body>
</html>