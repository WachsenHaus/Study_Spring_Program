<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/friedns.jsp</title>
</head>
<body>
<ul>
	<c:forEach var="tmp" items="${friends }">
		<li>${tmp }</li>
	</c:forEach>
	<c:forEach var="tmp" items="${friends.list }">
		<li>${tmp }</li>
	</c:forEach>
	
</ul>
</body>
</html>