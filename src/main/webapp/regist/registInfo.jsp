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
	<h2>고객 정보</h2> [<a href="/jsp_study/RegistControllers">새로고침</a> ]
	<hr>
	<table border = "1">
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>
		
		<c:forEach items="${regists}" var="r" varStatus="i">
			<tr>
				<td>${r.id}</td>
				<td><a href="/jsp_study/RegistControllers?action=detail&id=${r.id}">${r.name}</a></td>
				<td>${r.phone}</td>
			</tr>
		</c:forEach>		
	</table>
	
	<h2>고객 추가</h2>
	<hr>
	<form action="/jsp_study/RegistControllers?action=insert" method = "post">
		<label>이름</label><input type="text" name="name" id="name" /> <br />
		<label>주소</label><input type="text" name="address" id="address" /> <br />
		<label>전화번호</label><input type="text" name="phone" id="phone" /> <br />
		<label>등급</label><input type="text" name="grade" id="grade" /> <br />
		<button type = "submit">등록</button>
	</form>
</body>
</html>