<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/pwd_update_form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h1>비밀번호 수정 폼</h1>
		<form action="pwd_update.do" method="post" id="myForm">
			<div class="form-group">
				<label for="pwd">기존 비밀번호</label>
				<input class="form-control"  type="text" name="pwd" id="pwd" />
			</div>
			<div class="form-group">
				<label for="newPwd">새 비밀번호</label>
				<input class="form-control" type="password" name="newPwd" id="newPwd" />
			</div>
			<div class="form-group">
				<label for="newPwd2">새 비밀번호 확인</label>
				<input class="form-control" type="password" name="newPwd2" id="newPwd2" />
			</div>
			<button id="buttonSubmit" class="btn btn-outline-primary" type="submit">수정하기</button>
		</form>
	</div>
	<script src="${pageContext.request.contextPath }/resources/js/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>
	<script>
		const buttonSubmit = document.getElementById("buttonSubmit");
		buttonSubmit.addEventListener("click",pwdConfirm);
		function pwdConfirm(e)
		{
			e.preventDefault();
			const newPwd = document.getElementById("newPwd");
			const newPwd2 = document.getElementById("newPwd2");
			const myForm = document.getElementById("myForm");
			
			if(newPwd.value == newPwd2.value)
			{
				alert("수정하러간다~");
				myForm.submit();
				return;
			}
			alert("비밀번호가 일치하지않아요");
			newPwd.value = "";
			newPwd2.value ="";
			newPwd.focus();
		}
	</script>
</body>
</html>