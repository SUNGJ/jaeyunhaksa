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
	<h1>신청한 과목</h1>

	<form method="get"
		action="${pageContext.request.contextPath}/appliedsuccess">
		<table class="table">
			<tr>
				<th>교필</th>
				<th>핵교</th>
				<th>전지</th>
				<th>전기</th>
				<th>전선</th>
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
	</form>
</body>
</html>