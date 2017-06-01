<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
		<title>부트스트랩 101 템플릿</title>
		
		<!-- 부트스트랩 -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
		<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
		<!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->
	</head>
	<body>
		<div class="jumbotron">
			<h1>수정 페이지</h1>
		</div>
		<form action="update.action">
			<div class="form-group">
				<label for="sabun">사 번</label> <input type="number"
					value="${bean.sabun }" class="form-control" name="sabun" id="sabun"
					placeholder="sabun">
			</div>
			<div class="form-group">
				<label for="name">이 름</label> <input type="text"
					value="${bean.name }" class="form-control" name="name" id="name"
					placeholder="name">
			</div>
			<div class="form-group">
				<label for="pay">금 액</label> <input type="number"
					value="${bean.pay }" class="form-control" name="pay" id="pay"
					placeholder="pay">
			</div>
			<button type="submit" class="btn btn-default">입력</button>
		</form>
	
		<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
