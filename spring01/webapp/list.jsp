<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<script src="http://code.jquery.com/jquery-1.12.4.min.js"
			integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
			crossorigin="anonymous"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<style type="text/css">
			.alert {
				display: ${display };
			}
		</style>
	</head>
	<body>
		<div class="alert alert-success" role="alert">${msg }</div>
		<div class="container">
			<div class="row header">
				<div class="col-md-12">
					<h1>TripUs</h1>
				</div>
			</div>
			<div class="row content">
				<!-- content 시작 -->
				<div class="jumbotron">
					<h1>Welcome to TripUs</h1>
					<p>TripUs Hompage</p>
					<p><a class="btn btn-primary btn-lg" href="add.do" role="button">글 쓰기</a></p>
				</div>
				<div class="page-header">
					<h1>게시판 <small>글을 작성합니다.</small></h1>
				</div>
				<table class="table table-striped">
					<tr>
						<th>사 번</th>
						<th>이 름</th>
						<th>날 짜</th>
						<th>금 액</th>
					</tr>
					<c:forEach items="${list }" var="bean">
					<tr>
						<td>${bean.sabun }</td>
						<td><a href="detail.do?sabun=${bean.sabun }">${bean.name }</a></td>
						<td>${bean.nalja }</td>
						<td>${bean.pay }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="row footer">
				<div class="col-md-12">
					<p>ⓒTripUs.corp</p>
				</div>
			</div>
		</div>
	</body>
</html>