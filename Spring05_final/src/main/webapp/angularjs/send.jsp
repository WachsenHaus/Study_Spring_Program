<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String msg = request.getParameter("msg");
 	System.out.println("ajax 전송된 msg: " +msg);
 %>
{"toClient":"hello"}