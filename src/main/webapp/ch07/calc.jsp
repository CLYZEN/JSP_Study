<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Calculator calc = new Calculator() -->
<jsp:useBean id="calc" class = "ch07.Calculator" />
<!-- clacFrom.html 에서 입력받은 값 모두를 Calculator 클래스의 알맞는 필드에 넣어준다. -->
<jsp:setProperty property="*" name="calc"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과 : <%=calc.calc() %>
</body>
</html>