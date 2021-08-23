<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhâp</title>
</head>
<body>
	<div class="container">
	
		<div class="login-form">
			<div class="main-div">
				<!-- <form id="Login" > -->

				<c:if test="${not empty message}">
					<div class="alert alert-${alert}">${message}</div>
				</c:if>

				<form action="<c:url value='/dang-nhap'/>" id="formLogin" method="POST"> 
					<div class="form-group">


						<input type="text" class="form-control" id="name"
							placeholder="Username" name="name">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="password"
							placeholder="Password" name="password">

					</div>
					<input type="hidden" value="login" name="action" />
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>