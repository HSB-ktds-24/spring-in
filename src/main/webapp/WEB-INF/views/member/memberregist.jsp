<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
	<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="/js/member/memberregist.js"></script>
</head>
<body>
<h1>회원가입</h1>
	<form method="post">
		<div class="grid">
			<label for="email">이메일</label>
			<input id="email" type="email" name="email" value="${memberWriteVO.email}"/>

			<label for="name">이름</label>
			<input id="name" type="text" name="name" value="${memberWriteVO.name}"/>
			
			<label for="password">비밀번호</label>
			<input id="password" type="password" name="password" value="${memberWriteVO.password}"/>
			
			<label for="confirmPassword">비밀번호 확인</label>
			<input id="confirmPassword" type="password" name="confirmPassword" value="${memberWriteVO.confirmPassword}" />
			
			<div class="btn-group">
				<div class="right-align">
				<input type="submit" value="등록" />
				</div>
			</div>
		</div>
	</form>

</body>
</html>