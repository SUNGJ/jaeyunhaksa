<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text-css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">

<title>Home</title>
</head>
<body>
	<h1>성재윤의 학사정보!</h1>

	<P>현재 시간은 ${serverTime}.</P>
	<P>
	<form method="get" action="${pageContext.request.contextPath}/semester">
		<button class="button" style="vertical-align: middle">
			<span>학기별 이수 학점 조회</span>
		</button>
	</form>
	<form method="get" action="${pageContext.request.contextPath}/division">
		<button class="button" style="vertical-align: middle">
			<span>이수 구분별 학점 조회</span>
		</button>
	</form>
	<form method="get"
		action="${pageContext.request.contextPath}/applygrade">
		<button class="button" style="vertical-align: middle">
			<span>수강 신청하기</span>
		</button>
	</form>
	<form method="get"
		action="${pageContext.request.contextPath}/gradesapplied">
		<button class="button" style="vertical-align: middle">
			<span>수강 신청 조회</span>
		</button>
	</form>

</body>
</html>
