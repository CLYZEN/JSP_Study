<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	height: 100%;
	margin: 0;
}

form {
	height: 100%;
	display: flex;
	align-items: center;
}

div {
	width: 300px;
	margin: 0 auto;
}

label {
	width: 70px;
	display: inline-block;
}

h1 {
	font-size: 20px;
}
</style>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
	<%
		Cookie[] cookie = request.getCookies();
		if (cookie != null) { // 쿠키가 존재하면
			for(Cookie c : cookie) {
				if(c.getName().equals("loginChk") && c.getValue().equals("Y")) {
					%>
						<script type="text/javascript">
							$(function(){
								$("#loginChk").prop("checked", true); // 체크
							});
						</script>
					<%
				} else {
					%>
						<script type="text/javascript">
							$(function(){
								$("#loginChk").prop("checked", false); // 체크 해제
							});
						</script>
					<%
				}
			}
		}
	%>
	<form action="login.jsp" method="post">
		<div>
			<h1>관리시스템 로그인</h1>
			<label for="id">아이디</label><input type="text" id="id" name="id" /> <br>
			<label for="pw">비밀번호</label><input type="password" id="pw" name="pw" />
			<br>
			<br> <input type="checkbox" name="loginChk" id="loginChk" />
			아이디 기억 <br> <input type="submit" value="로그인" /> <input
				type="reset" value="취소" />
		</div>
	</form>
</body>
</html>