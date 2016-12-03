<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<br/>
<h1>학기별 이수 학점 조회</h1>
	<table class="table">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="grades" items="${grades}">
			<tr>
				<td>${grades.year}</td>
				<td>${grades.semester}</td>
				<td>${grades.point}</td>
				<td><a href="${pageContext.request.contextPath }/detailview?year=${grades.year}&semester=${grades.semester}">링크</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>