<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>수정 페이지</h1>
		<form action="../update" method="post">
			<input type="number" name="sabun" value="${bean.sabun }" readonly="readonly"/>
			<input type="text" name="name" value="${bean.name }"/>
			<input type="number" name="pay" value="${bean.pay }"/>
			<button>수정</button>
		</form>	
	</body>
</html>