<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	</head>
	<body>
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
					<h1>상세보기 <small>${bean.sabun }님의 결과</small></h1>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">사 번</div>
					<div class="col-md-4">${bean.sabun }</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">이 름</div>
					<div class="col-md-4">${bean.name }</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">날 짜</div>
					<div class="col-md-4">${bean.nalja }</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">금 액</div>
					<div class="col-md-4">${bean.pay }</div>
				</div>
				</div>
				<div class="row">
					<div class="col-md-9 col-md-offset-3">
						<a class="btn btn-default" role="button" href="edit.do?sabun=${bean.sabun }">수정</a>
						<a class="btn btn-default" role="button" href="delete.do?sabun=${bean.sabun }">삭제</a>
					</div>
				</div>
			</div>
			<div class="row footer">
				<div class="col-md-12">
					<p>ⓒTripUs.corp</p>
				</div>
			</div>
		</div>
	</body>
</html>