<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trang danh sách</title>
</head>

<body>
		<div class="main-content">
	<form action="<c:url value='/admin-new'/>" id="formSubmit" method="post"> 
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value='/admin-home'/> ">Home</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<!-- <div> -->
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">


									<table class="table table-bordered">
										<thead>
											<tr>
												<th>Tên bài viết</th>
												<th>Mô tả ngắn</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${model.listResult }">
												<tr>
													<td>${item.title}</td>
													<td>${item.shortdescription}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

									<ul class="pagination" id="pagination"></ul>
									<input type = "hidden" value = "" id = "page" name = "page"/>
									<input type = "hidden" value = "" id = "maxPageItem" name = "maxPageItem"/>
									<input type = "hidden" value = "" id = "sortName" name = "sortName"/>
									<input type = "hidden" value = "" id = "sortBy" name = "sortBy"/>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
	    (function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: totalPages,
	            visiblePages: limit,
	            startPage: currentPage,
	            onPageClick: function (event, page) {
	            	if(currentPage != page){
	                //console.info(page + ' (from options)');
	                $('#maxPageItem').val(limit);
	                $('#page').val(page);
	                $('#sortName').val('title');
	                $('#sortBy').val('desc');
	                $('#formSubmit').submit();
	            }
	            }
	        });
	    });
	</script>
</body>

</html>