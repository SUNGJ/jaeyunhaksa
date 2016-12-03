<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS link*** -->
<link rel="stylesheet" type="text-css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">
<title>Insert title here</title>
</head>
<body>
	<br />
	<h1>수강신청이 완료되었습니다.</h1>
	<br />
	<form method="get"
		action="${pageContext.request.contextPath}/gradesapplied">
		<br />
		<button class="button" style="vertical-align: middle">
			<span>신청항목 보러가기</span>
		</button>
	</form>
</body>
</html>