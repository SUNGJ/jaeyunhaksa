<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
	<h1>이수 과목 조회</h1>
	<table class="table">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>
		<c:forEach var="grades" items="${grades}">

			<tr>
				<td><c:out value="${grades.year}"></c:out></td>
				<td><c:out value="${grades.semester}"></c:out></td>
				<td><c:out value="${grades.code}"></c:out></td>
				<td><c:out value="${grades.name}"></c:out></td>
				<td><c:out value="${grades.division}"></c:out></td>
				<td><c:out value="${grades.point}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>