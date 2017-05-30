<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>리스트 페이지</h1>
		
		<table>
			<tr>
				<th>사 번</th>
				<th>이 름</th>
				<th>날 짜</th>
				<th>금 액</th>
			</tr>
			<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.sabun }</td>
				<td>${bean.name }</td>
				<td>${bean.nalja }</td>
				<td>${bean.pay }</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>