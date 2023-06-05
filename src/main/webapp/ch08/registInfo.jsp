<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객정보 조회</h2>
	<hr>
	<ul>
		<li>고객아이디 : ${p.id}  </li>
		<li>고객명 : ${p.name} </li>
		<li>주소 : ${p.address} </li>
		<li>등급 : ${p.grade} </li>
		<li>전화번호 : ${p.phone} </li>		
	</ul>
</body>
</html>