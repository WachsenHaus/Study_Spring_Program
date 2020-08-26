<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="../resources/js/angular.min.js"></script>

<script>
	const myApp = angular.module("myApp",[]);
	myApp.controller("myCtrl",function($scope){
		$scope.nums=[10,20,30,40,50];
		$scope.mem = {num:1,name:"김구라"};
		$scope.msg = "empty";
		$scope.obj = {height: 168,weight:74.6};
	});
</script>


</head>
<body ng-app ="myApp">
	<div  ng-controller="myCtrl"  class="myCtrl">
		<ul>
			<li ng-repeat="tmp in nums" ng-bind="tmp"></li>
		</ul>
		<p>번호 : {{mem.num}}</p>
		<p>이름 : <span ng-bind="mem.name"></span></p>
		<input type="text" ng-model ="msg" />
		<p>msg : <strong ng-bind="msg"></strong></p>
		<p>obj : <strong> {{obj}}</strong></p>
		<input type="text" ng-model="obj.height" placeholder="키 입력..." />
		<input type="text"  ng-model="obj.weight" placeholder="몸무게 입력..." />
	</div>
</body>
</html>