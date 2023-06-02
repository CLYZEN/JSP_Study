<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String loginChk = request.getParameter("loginChk");
		
		// 기존의 사용자 id,pw(db에서 가져왔다고 가정)
		String dbId = "user", dbPw = "1234";
		
		if(dbId.equals(id)) {
			if(dbPw.equals(pw)) {
				// 로그인 성공 -> 세션값 생성
				session.setAttribute("id", id);
				
				// 사용자가 아이디 저장 체크여부 
				if (loginChk != null) { // 체크 한 경우
					Cookie cookie = new Cookie("loginChk", "Y"); // 쿠키 생성 (key, value)
					cookie.setMaxAge(60 * 50); // 60분 동안 쿠키에 값 저장
					cookie.setPath("/"); // 쿠키의 적용 경로
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("loginChk", "N"); // 쿠키 생성 (key, value)
					cookie.setMaxAge(60 * 50); // 60분 동안 쿠키에 값 저장
					cookie.setPath("/"); // 쿠키의 적용 경로
					response.addCookie(cookie);
				}
	%>
				<script type="text/javascript">
				alert("인증되었습니다.");
				location.href = "main.jsp";
				</script>
	<%				
			} else {
	%>
					<script type="text/javascript">
						alert("비밀번호가 다릅니다.");
						location.href = "index.jsp";
					</script>
	<%
			}
		} else {
	%>
			<script type="text/javascript">
				alert("아이디가 다릅니다.");
				location.href = "index.jsp";
			</script>
	<%
		}
	%>	
	%>
</body>
</html>