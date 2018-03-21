<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>index.jsp</title>
	<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="http://bootstrapk.com/examples/cover/cover.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/ie10-viewport-bug-workaround.js"></script>
	
</head>
<body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Cover</h3>
						<nav>
							<ul class="nav masthead-nav">
								<li class="active"><a href="#">직원</a></li>
								<li><a href="#">학생</a></li>
								<li><a href="#">선생님</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="inner cover">
					<h1 class="cover-heading">팀 구성</h1>
					<p class="lead">
						<table class="table">
							<tr>
								<th>이름</th>
								<th>목록</th>
							</tr>
							<tr>
								<th>김기성</th>
								<th>직원</th>
							</tr>
							<tr>
								<th>김도희</th>
								<th>선생님</th>
							</tr>
							<tr>
								<th>최상욱</th>
								<th>학생</th>
							</tr>
						</table>
					</p>
				</div>
				<div class="mastfoot">
					<div class="inner">
						<p>
							Cover template for <a href="http://getbootstrap.com">Bootstrap</a>,
							by <a href="https://twitter.com/mdo">@mdo</a>.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
