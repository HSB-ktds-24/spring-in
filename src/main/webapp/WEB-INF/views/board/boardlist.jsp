<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--JSTL을 위한 디렉트브 선언-->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="grid">
		<div class="right-align">
		총 ${boardListVO.boardCnt}건의 게시글이 검색되었습니다.
		</div>
		<table class="table">
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이메일</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>수정일</th>
		</tr>
		</thead>
		<tbody>
		
		<!-- 
		${boardListVO.boardlist} 가 비어있지 않다
		foreah를 통해 목록 보여줌
		그렇지 앟ㄴ으면 게시글이 없다
		 -->
		<c:choose>
		<c:when test="${not empty boardListVO.boardlist }">
		<c:forEach items="${boardListVO.boardlist}" var="board">
		
		
		<tr>
			<td>${board.id}</td>
			<td>${board.subject}</td>
			<td>${board.email}</td>
			<td>${board.viewCnt}</td>
			<td>${board.crtDt}</td>
			<td>${board.mdfyDt}</td>
		</tr>
		</c:forEach>
		</c:when>
		
		<c:otherwise>
		<tr>
		<td colspan="6"> 게시글이 없습니다 </td>
		</tr>
		</c:otherwise>
		</c:choose>
		
		
		</tbody>
		</table>
		<div class="right-align"></div>
	</div>
</body>
</html>