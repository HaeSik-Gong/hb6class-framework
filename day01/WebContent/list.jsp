<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bbs_table.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>목록 페이지</h1>
	<table class="t1">
		<thead>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</thead>
		<c:forEach items="${alist }" var="map">
		<tbody>
			<td>${map.sabun }</td>
			<td><a href="detail.do?idx=${map.sabun }">${map.name }</a></td>
			<td>${map.nalja }</td>
			<td>${map.pay }</td>
		</tbody>
		</c:forEach>
	</table>
	<a href="add.do">입력</a>
</body>
</html>