<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app = "acornApp">
<head>
<meta charset="UTF-8">
<title>exam.jsp</title>
<script src="../resources/js/angular.min.js"></script>
<script>
	var acornApp = angular.module("acornApp",[]);
	acornApp.controller("acornCtrl" , function($scope){
		$scope.btnClicked = function(){
			alert("버튼을 눌렀네요 ? ");
		}
	});
</script>
</head>
<body  ng-controller = "acornCtrl">
	<button ng-click="btnClicked()">버튼</button>
	<p ng-click="btnClicked()">버튼2</p>
</body>
</html>