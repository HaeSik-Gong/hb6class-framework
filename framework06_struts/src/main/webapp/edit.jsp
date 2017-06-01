<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>수정 페이지</h1>
		<s:form action="update">
		    <s:textfield name="sabun" label="sabun" size="20" />
		    <s:textfield name="name" label="name" size="20" />
		    <s:textfield name="pay" label="pay" size="20" />
		    <s:submit name="submit" label="Submit" align="center" />
	   	</s:form>
	   	<form action="update.action">
			<div>
				<label for="sabun">사번</label>
				<input type="number" name="bean.sabun" value="${bean.sabun }"/>
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" name="bean.name" value="${bean.name }"/>
				${errname }
				<s:fielderror name="errname"/>
			</div>
			<div>
				<label for="pay">금액</label>
				<input type="number" name="bean.pay" value="${bean.pay }"/>
			</div>
			<div>
				<button>수정</button>
			</div>
		</form>
	</body>
</html>