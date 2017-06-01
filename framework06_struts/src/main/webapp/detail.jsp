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
		<div>
			<div>
				<span>사 번 : </span>
				<span>${bean.sabun }</span>
			</div>
			<div>
				<span>이 름 : </span>
				<span>${bean.name }</span>
			</div>
			<div>
				<span>날 짜 : </span>
				<span>${bean.nalja }</span>
			</div>
			<div>
				<span>금 액 : </span>
				<span>${bean.pay }</span>
			</div>
		</div>
		<div>
			<a href="edit.action?sabun=${bean.sabun }">수정</a>
			<a href="delete.action?sabun=${bean.sabun }">삭제</a>
		</div>
	</body>
</html>