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
		String userid = (String)session.getAttribute("userid");
		session.invalidate(); 
	%>
	<script type="text/javascript">
		alert("로그아웃 되었습니다.");
		document.location.href = "Index.do";
	</script>
</body>
</html>