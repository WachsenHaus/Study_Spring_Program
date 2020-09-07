<%@page import="java.util.Map"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>/file/private/upload.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<p class="alert alert-success">
			<strong>${id }</strong>님이 업로드한 파일
			<strong>${dto.orgFileName }</strong>이 성공적으로 저장되었습니다.
			파일의 크기는 <strong>${dto.fileSize }</strong>byte입니다.
			<a href="${pageContext.request.contextPath}/file/list.do" class="alert-link">목록보기</a>
		</p>
	</div>
</body>
</html>


