<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="/template/header.jsp"></jsp:include>
		<jsp:include page="/template/nav.jsp">
			<jsp:param value="2" name="tab"/>
		</jsp:include>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="page-header">
						<h1>상세 페이지<small>${bean.name }님의 정보</small></h1>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<h3>번 호 : ${bean.num }</h3>
						</li>
						<li class="list-group-item">
							<h3>사 번 : ${bean.sabun }</h3>
						</li>
						<li class="list-group-item">
							<h3>이 름 : ${bean.name }</h3>
						</li>
						<li class="list-group-item">
							<h3>날 짜 : ${bean.nalja }</h3>
						</li>
					</ul>
					<div>
						<a class="btn btn-primary" role="button" href="edit?idx=${bean.num }">수정</a>
						<a class="btn btn-primary" role="button" href="delete?idx=${bean.num }">삭제</a>
					</div>
				</div>
			</div>
		<jsp:include page="/template/footer.jsp"></jsp:include>
	</body>
</html>