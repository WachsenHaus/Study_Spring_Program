<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>안녕하세요 스프링 페이지입니다.</h1>
	<ul>
		<li><a href="member/list.do">회원 목록 보기</a></li>
		<li><a href="todo/list.do">할일 목록 보기</a></li>
		<li><a href="json01.do">json 응답01</a></li>
		<li><a href="json02.do">json 응답02</a></li>
		<li><a href="json03.do">json 응답03</a></li>
		<li><a href="json04.do">json 응답04</a></li>
		<li><a href="json05.do">json 응답05</a></li>
		<li><a href="json06.do">json 응답06</a></li>
		<li><a href="json07.do">json 응답07</a></li>
		<li><a href="json08.do">json 응답08</a></li>
		<li><a href="xml01.do">xml1 응답08</a></li>
		<li><a href="xml02.do">xml2 응답09</a></li>
		<li><a href="xml03.do">xml2 응답09</a></li>
	</ul>
	<button id="testBtn">ajax 테스트(콘솔확인)</button>
	<button id="testBtn2">ajax 테스트(콘솔확인) - no jquery</button>
	
	<h2>파일 업로드 테스트</h2>
	<form action="upload.do" method="post" enctype="multipart/form-data" >
		제목<input type="text" name="title" /><br />
		첨부파일<input type="file" name="myFile" /><br />
		<button type="submit">업로드</button>
	</form>
	
	
	
	<h2>파일 업로드 테스트2</h2>
	<form action="upload2.do" method="post" enctype="multipart/form-data" >
		제목<input type="text" name="title" /><br />
		첨부파일<input type="file" name="myFile" /><br />
		<button type="submit">업로드</button>
	</form>
	
	
	
	
	
	
	
	<script src="resources/js/jquery-3.5.1.js"></script>
	<script>
		$("#testBtn").on("click",function() {
		$.ajax({
			url: "json08.do",
			method: "GET",
			success:function(data){
			//data는 plain object or array이다.
			console.log(data);
			}
		})}) ;
		
	</script>
	<script>
		document.getElementById("testBtn2").addEventListener("click",function(e){
		e.preventDefault();
		fetch('json08.do',{
			method: 'GET',
		}).then(function (response){
			return response.json();
		}).then(function (text){
			console.log(text);
		}).catch(function(error){
			console.error(error);
		});
		});
	</script>
	
</body>
</html>


