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
					<p><a class="btn btn-primary btn-lg" href="add.do" role="button">글쓰기</a></p>
				</div>
				<div class="page-header">
					<h1>수정 <small>변경사항을 입력해 주세요</small></h1>
				</div>
				<form action="update.do" class="form-horizontal" method="post">
					<div class="form-group">
						<label for="sabun" class="col-sm-2 control-lable">사번</label>
						<div class="col-sm-10">
							<input type="number" readonly="readonly" class="sabun" name="sabun" placeholder="사번 입력"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-lable">이름</label>
						<div class="col-sm-10">
							<input type="text" class="name" name="name" placeholder="이름 입력"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pay" class="col-sm-2 control-lable">금액</label>
						<div class="col-sm-10">
							<input type="number" class="pay" name="pay" placeholder="금액 입력"/>
						</div>
					</div>
					<div class="form-group">
						<button type="submit">입력</button>
					</div>
				</form>
			</div>
			<div class="row footer">
				<div class="col-md-12">
					<p>ⓒTripUs.corp</p>
				</div>
			</div>
		</div>
	</body>
</html>