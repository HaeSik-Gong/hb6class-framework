<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>입력 페이지</h1>
		
		<form action="insert.action">
			<div>
				<label for="name">이름</label>
				<input type="text" name="name"/>
			</div>
			<div>
				<label for="nalja">날짜</label>
				<input type="date" name="nalja"/>
			</div>
			<div>
				<label for="pay">금액</label>
				<input type="number" name="pay"/>
			</div>
			<div>
				<button type="submit">입력</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</body>
</html>