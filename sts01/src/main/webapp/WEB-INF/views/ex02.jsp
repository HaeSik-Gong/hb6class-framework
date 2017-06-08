<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Ex02</h1>
		<p>${msg }</p>
		<form action="ex10" method="post">
			<input type="text" name="id" placeholder=" ID 입력">
			<input type="password" name="pw" placeholder=" PW 입력">
			<button>입력</button>
		</form>
	</body>
</html>