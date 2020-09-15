<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test01.jsp</title>
</head>
<!-- angularjs 로딩 시키기 -->
<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
<body ng-app>
	<h1>hello angular js!</h1>
	<input ng-model="msg"  type="text"  placeholder="메세지 입력..." />
	<button>전송</button>
	<p>{{msg}}</p>
	
	<h1 ng-init="friends=['김구라', '해골', '원숭이']">친구 목록입니다.</h1>
	<ul>
		<li ng-repeat="tmp in friends">{{tmp}}</li>
	</ul>
	
	<h1>체크박스를 체크해 보세요.</h1>
	<input type="checkbox"  ng-model = "isShow" /><br />
	<img src="../resources/images/kim1.png" ng-show="isShow" alt="" />
</body>
</html>