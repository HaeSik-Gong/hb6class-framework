<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>리스트 페이지</h1>
		<div>
			<div>
				<span>사 번</span>
				<span>이 름</span>
				<span>날 짜</span>
				<span>금 액</span>
			</div>
			<c:forEach items="${list }" var="bean">
			<div>
				<a href="detail.action?sabun=${bean.sabun }">
					<span>${bean.sabun }</span>
					<span>${bean.name }</span>
					<span>${bean.nalja }</span>
					<span>${bean.pay }</span>
				</a>
			</div>
			</c:forEach>
		</div>
	</body>
	<a href="add.action">입력</a>
</html>