<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text-css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">

<title>Insert title here</title>
</head>
<body>
<br/>
<h1>이수 구분별 학점 조회</h1>
	<table class="table">
		<tr>
			<th>교필</th>
			<th>핵교</th>
			<th>전지</th>
			<th>전기</th>
			<th>전선</th>
			<th>총학점</th>
		</tr>
		<tr>
			<td>${mandatory1}</td>
			<td>${mandatory2}</td>
			<td>${major1}</td>
			<td>${major2}</td>
			<td>${major3}</td>
			<td>${mandatory1+mandatory2+major1+major2+major3}</td>
		</tr>
	</table>

</body>
</html>