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
						<h1>${title } 페이지<small>Form 페이지</small></h1>
					</div>
					<form action="${nxtUrl }" class="form-horizontal" method="post">
						<input type="number" name="num" value="${bean.num!=null ? bean.num : 0 }" hidden="hidden"/>
						<div class="form-group">
							<div class="col-md-9">
								<input class="form-control" value="${bean.sabun }" type="number" name="sabun" placeholder=" SABUN 입력"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9">
								<input class="form-control" value="${bean.name }" type="text" name="name" placeholder=" NAME 입력"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9">
								<button>${title }</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		<jsp:include page="/template/footer.jsp"></jsp:include>
	</body>
</html>