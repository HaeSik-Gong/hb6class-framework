<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link href="css/table.css" rel="stylesheet">
	</head>
	<body>
		<h1>리스트 페이지</h1>
		
		<div id="table">
			<div class="tr">
				<span>사 번</span>
				<span>이 름</span>
				<span>날 짜</span>
				<span>금 액</span>
			</div>
			<c:forEach items="${alist}" var="bean">
			<a href="edit.do?idx=${bean.sabun }">
				<div class="tr">
					<span>${bean.sabun }</span>
					<span>${bean.name }</span>
					<span>${bean.nalja }</span>
					<span>${bean.pay }</span>
				</div>
			</a>
			</c:forEach>
		</div>
		<a href="add.do">입력</a>
	</body>
</html>