<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>수강 신청하기</h1>
	<!-- 버튼 click 하면 docreate request 발생 (controller 추가)-->
	<!-- 사용자가 입력한 내용 Model에 저장되어 controller -> DispatcherServlet ->view로 전송되어 다시 display 가능!!-->
	<!-- buffering에 관한 태그는 spring tag(sf:)사용! -->
	<sf:form method="get"
		action="${pageContext.request.contextPath}/doapply"
		modelAttribute="grade">

		<table class="table">
			<tr>
				<td class="label">수강년도</td>
				<td><sf:input path="year" type="text" /></td>
				<td><sf:errors cssClass="error" path="year"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">학기</td>
				<td><sf:input path="semester" type="text" /></td>
				<td><sf:errors cssClass="error" path="semester"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">과목 코드</td>
				<td><sf:input path="code" type="text"></sf:input></td>
				<td><sf:errors cssClass="error" path="code"></sf:errors>
				<td>
			</tr>
			<tr>
				<td class="label">과목 이름</td>
				<td><sf:input path="name" type="text"></sf:input></td>
				<td><sf:errors cssClass="error" path="name"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">과목 구분</td>
				<td><sf:select path="division" class="select">
						<optgroup label="구분">
							<sf:option value="교필">교필</sf:option>
							<sf:option value="핵교A">핵교A</sf:option>
							<sf:option value="핵교B">핵교B</sf:option>
							<sf:option value="전지">전지</sf:option>
							<sf:option value="전기">전기</sf:option>
							<sf:option value="전선">전선</sf:option>
						</optgroup>
					</sf:select></td>

				<td><sf:errors cssClass="error" path="division"></sf:errors></td>

			</tr>
			
			<tr>
				<td class="label">학점</td>
				<td><sf:input path="point" type="text"></sf:input></td>
				<td><sf:errors cssClass="error" path="point"></sf:errors></td>
			</tr>
		</table>

		<form method="get" action="${pageContext.request.contextPath}/doapply" modelAttribute="grade">
			<button class="buttons">
				<span>신청하기</span>
			</button>
		</form>
	</sf:form>
</body>
</html>