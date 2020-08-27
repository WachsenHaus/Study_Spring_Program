<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test03.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
</head>
<body ng-app>
	<div class="container">
		<h1 ng-init="a='btn-primary'">클래스 속성 조작하기</h1>
		<input ng-model="msg"  type="text"  placeholder="메세지 입력..." />
		<button class="btn btn-primary">버튼1</button>
		<button class="btn {{a}}">버튼2</button>
		<button class="btn {{msg}}">버튼3</button>
		<button ng-class="['btn','btn-primary']">버튼4</button>
		<button ng-class="{'btn':true, 'btn-primary':{{isLarge}}}">버튼5</button>
		<br />
		<input type="checkbox"  ng-model = "isLarge"/>
		<button class="btn btn-success" ng-class="{'btn-lg' : isLarge}">버튼6</button>
	</div>
</body>
</html>