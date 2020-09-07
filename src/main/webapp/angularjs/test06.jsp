<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test06.jsp</title>

<link href="../resources/css/bootstrap.css" rel="stylesheet"/>
<!-- angularjs 로딩 시키기 -->
<script src="../resources/js/angular.min.js"></script>

<script>
	//"myApp" 이라는 이름의 모듈 만들기
	var myApp = angular.module("myApp",[]);
	// 모듈을 이용해서 myCtrl 이라는 이름의 컨트롤러 만들기
	myApp.controller("myCtrl",function($scope){
		/*
			- 이 함수는 페이지가 로딩되는 시점에 최초 한 번 호출된다.
			- $scope에는 angular가 관리하는 특별한 개체가 전달된다.
			- $scope는 해당 컨트롤러에서 사용하는 영역 개체이다.
			- $scope에는 각각의 컨트롤렁서 사용하는 모델가 저장된다.
		*/
		console.log("myCtrl에있는 함수 호출됨");
		console.log($scope);
		//$scope object에 nick이라는 방(모델)을 만들고 문자열 넣어주기
		$scope.nick="김구라";
		
		$scope.btnClicked=function(){
			alert("버튼을 눌렀네요?");
		};
		
	});
	//모듈을 이용해서 yourCtrl 이라는 이름의 컨트롤러 만들기
	myApp.controller("yourCtrl",function($scope){
		console.log("yourCtrl에 있는 함수 호출됨");
		console.log($scope);
		$scope.nick="해골";
		$scope.onMouseover = function(){
			alert("들어왔구나!");
		};
		
	});
	
</script>

</head>
<body ng-app="myApp">
		<div ng-controller="myCtrl">
			<h3>myCtrl 컨트롤러가 관리하는 모델</h3>
			<p>별명 : <strong>{{nick}}</strong></p>
			<button ng-click="nick='개구라'">눌러보셈</button>
			<button ng-click="btnClicked()">눌러보셈2</button>
		</div>
		<div ng-controller="yourCtrl" class="yourCtrl">
			<h3>yourCtrl 컨트롤러가 관리하는 영역</h3>
			<p>별명 : <strong ng-bind="nick"></strong></p>
			<button ng-click="nick=원숭이">눌러보셈</button>
			<button ng-mouseover = "onMouseover()">마우스를 올리셈</button>
		</div>
</body>
</html>