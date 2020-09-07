<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test10.jsp</title>
<script src="../resources/js/angular.min.js"></script>
</head>
<body ng-app>
	<h1>과일을 선택하세요</h1>
	<select ng-model = "selectedFruit"
	ng-change = "selectedFruit2 = selectedFruit"
	>
		<option value="">선택</option>
		<option value="orange">오렌지</option>
		<option value="apple">사과</option>
		<option value="banana">바나나</option>
	</select>
	<p>선택된 과일 : <strong ng-bind = "selectedFruit" ></strong></p>
	<select ng-model = "selectedFruit2">
		<option value="">선택</option>
		<option value="orange">오렌지</option>
		<option value="apple">사과</option>
		<option value="banana">바나나</option>
	</select>
	<h1>체크 박스를 테스트 해 보세요.</h1>
	<label for="">
		<input type="checkbox"  ng-model = "isShow"/> isShow
	</label>
	<label>
		<input type="checkbox" ng-model = "isMake"  /> isMake
	</label>
	<p ng-show="isShow" >안녕하세요</p>
	<!-- 문서개체를 동적으로 만드는것이다. -->
	<p ng-if="isMake">또 만났군요</p>
</body>
</html>