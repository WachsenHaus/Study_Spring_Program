<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/private/delete</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<p>
			<strong>${id }님 탈퇴 처리 되었습니다</strong>
			<a href="${pageContext.request.contextPath}/home.do">확인</a>
		</p>
	</div>
</body>
</html>