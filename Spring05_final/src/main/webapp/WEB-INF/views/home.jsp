<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${empty id }">
				<a href="${pageContext.request.contextPath}/users/loginform.do">로그인</a>
				<a href="${pageContext.request.contextPath}/users/signup_form.do">회원가입</a>
			</c:when>
			<c:otherwise>
				<strong>${id }</strong>님 로그인중...
				<a href="users/private/info.do">${id }</a>
				<a href="${pageContext.request.contextPath}/users/logout.do">로그아웃</a>
			</c:otherwise>
		</c:choose>
		<h1>인덱스 페이지 입니다.</h1>
		<p>Spring Framework 동작중...</p>
		
		<ul>
			<li><a href="file/list.do">자료실 목록 보기</a></li>
			<li><a href="cafe/list.do">카페글 목록 보기</a></li>
	        <li><a href="shop/list.do">상품 목록 보기</a></li>
	        <li><a href="angularjs/test01.jsp">angularjs 테스트</a></li>
	        <li><a href="angularjs/test02.jsp">angularjs2 테스트</a></li>
	        <li><a href="angularjs/test03.jsp">angularjs3 테스트</a></li>
	        <li><a href="angularjs/test04.jsp">angularjs4 테스트</a></li>
	        <li><a href="angularjs/test05.jsp">angularjs5 테스트</a></li>
	        <li><a href="angularjs/test06.jsp">angularjs6 테스트</a></li>
	        <li><a href="angularjs/test07.jsp">angularjs7 테스트</a></li>
	        <li><a href="angularjs/test08.jsp">angularjs8 테스트</a></li>
	        <li><a href="angularjs/test09.jsp">angularjs9 테스트</a></li>
	        <li><a href="css3/Step01_BorderRadius.html">css3 보더레디어스</a></li>
	        <li><a href="css3/Step02_Transition.html">css3 트랜지션</a></li>
	        <li><a href="css3/Step03_Transform.html">css3 트랜스폼/a></li>
	        <li><a href="css3/Step03_Quiz.html.html">css3 테스트3_퀴즈</a></li>
	        <li><a href="css3/Step04_3dTransform.html">css3 3d트랜스폼</a></li>
	        <li><a href="css3/Step04_Example.html">css3 테스트4</a></li>
	        <li><a href="css3/Step04_Cube.html">css3 큐브</a></li>
	        <li><a href="css3/Step04_Cube2.html">css3 큐브2</a></li>
	        <li><a href="css3/Step05_AnimateCss.html">css3 애니메이션</a></li>
	        <li><a href="css3/Step05_AnimateCss2.html">css3 애니메이션css</a></li>
	        <li><a href="css3/Step05_Animation.html">css3 애니메여신css2</a></li>
	        <li><a href="css3/Step06_BoxShadow.html">css3 박스그림자</a></li>
	        <li><a href="css3/Step07_TextShadow.html">css3 텍스트쉐도우</a></li>
	        <li><a href="css3/Step08_3dCarousel.html">css3 텍스트쉐도우</a></li>
		</ul>
	</div>
</body>
</html>
