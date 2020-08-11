<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${isSuccess }">
				<p>
					<strong>${sessionScope.id }</strong>님 로그인 되었습니다.
					<a href="${requestScope.url }">확인</a> <!-- modelandview는 기본적으로 리퀘스트스코프 --> 
				</p>
			</c:when>
			<c:otherwise>
				<p>
					아이디 혹은 비밀번호가 틀려요
					<a href="loginform.do?url=${encodedUrl }">다시 시도</a>
				</p>		
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>