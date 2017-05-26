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
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
				<th>금액</th>
			</tr>
		</thead>
		<c:forEach items="${alist }" var="bean">
		<tbody>
			<tr>
				<td>${bean.sabun }</td>
				<td>${bean.name }</td>
				<td>${bean.nalja }</td>
				<td>${bean.pay }</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	<a href="add.do">입력</a>
</body>
</html>