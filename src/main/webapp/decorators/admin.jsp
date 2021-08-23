<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/bootstrap.min.css'/> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.2.0/css/font-awesome.min.css'/> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/fonts/fonts.googleapis.com.css'/> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace.min.css'/> "
	class="ace-main-stylesheet" id="main-ace-style" />
<script src="<c:url value='/template/admin/js/ace-extra.min.js'/> "></script>
<script src="<c:url value='/template/admin/js/jquery.2.1.1.min.js'/> "></script>


<script src="<c:url value='/ckeditor/ckeditor.js'/> "></script>

<script
	src="<c:url value='/template/paging/jquery.twbsPagination.min.js'/> "></script>



</head>
<body class="no-skin">
	<!-- header -->
	<%@include file="/common/admin/header.jsp"%>
	<!-- header -->

	<!-- <div class="page-content"> -->
	<div class="main-container" id="main-container">


		<!-- menu -->
		<%@include file="/common/admin/menu.jsp"%>
		<!-- menu -->


		<dec:body />


		<!-- footer -->
		<%@include file="/common/admin/footer.jsp"%>
		<!-- footer -->

	</div>




	<script src="<c:url value='/template/admin/js/bootstrap.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery-ui.custom.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.easypiechart.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.sparkline.min.js'/> "></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.pie.min.js'/> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.resize.min.js'/> "></script>
	<script src="<c:url value='/template/admin/js/ace-elements.min.js'/> "></script>
	<script src="<c:url value='/template/admin/js/ace.min.js'/> "></script>

</body>
</html>