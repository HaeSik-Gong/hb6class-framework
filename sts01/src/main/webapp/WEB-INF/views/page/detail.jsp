<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>상세 페이지</h1>
		<table>
			<tr>
				<th>사 번</th>
				<td>${bean.sabun }</td>
			</tr>
			<tr>
				<th>이 름</th>
				<td>${bean.name }</td>
			</tr>
			<tr>
				<th>날 짜</th>
				<td>${bean.nalja }</td>
			</tr>
			<tr>
				<th>금 액</th>
				<td>${bean.pay }</td>
			</tr>
		</table>
		<a href="../edit/${bean.sabun }">수정</a>
		<a href="../delete/${bean.sabun }">삭제</a>
	</body>
</html>