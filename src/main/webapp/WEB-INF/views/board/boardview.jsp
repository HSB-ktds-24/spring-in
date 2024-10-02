<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 조회</h1>
	<div class="gird-view-board">

		<label for="subject">제목</label>
			<div>${BoardVO.subject}</div>
		<label for="email">이메일</label>
		<div>${BoardVO.email}</div>
			<label for="viewCnt">조회수</label>
		<div>${BoardVO.viewCnt}</div>
		
		<label for="originFileName">첨부파일</label>
			<div><a href="/board/file/download/${BoardVO.id}"> ${BoardVO.originFileName}</a></div>
		
		<label for="crtDt">등록일</label>
		<div>${BoardVO.crtDt}</div>
			<label for="mdfyDt">수정일</label>
		<div>${BoardVO.mdfyDt}</div>
			<label for="content">내용</label>
		<div>${BoardVO.content}</div>
		<div class="right-align">
			<a href="/board/modify/${BoardVO.id}">수정</a>
			<a href="/board/delete/${BoardVO.id}">삭제</a>
		</div>
		</div>

</div>
</body>
</html>