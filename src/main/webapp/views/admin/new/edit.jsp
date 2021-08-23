<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trang danh sách</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-new'/>" id="formSubmit"
			method="post">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value='/admin-home'/> ">Home</a></li>
						<li class="active">Chỉnh sửa bài viết</li>
					</ul>
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse }">
								<div class="alert alert-${alert }">${messageResponse }</div>
							</c:if>
							
							<form id="formSubmit">
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể loại</label>
								<div class="col-sm-9">
									<select class="form-control" id="catoryCode" name="catoryCode">
									<c:if test="${empty model.catoryCode }">
										<option value="">Chọn loại bài viết</option>
										<c:forEach var="item" items="${categories }">
											<option value="${item.code }">${item.name }</option>
										</c:forEach>
										</c:if>
										<c:if test="${not empty model.catoryCode }">
										
										<c:forEach var="item" items="${categories }">
										<option value="${item.code }" <c:if test="${item.code == model.catoryCode }">selected="selected"</c:if>>
											${item.name }
										</option>
										</c:forEach>
										</c:if>
										
									</select>
								</div>
							</div>
							
							<br>
							<br>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu	đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"	value="${model.title }" />
								</div>
							</div>

							<br>
							<br>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình	đại diện</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail }" />
								</div>
							</div>

							<br>
							<br>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortdescription" name="shortdescription" value="${model.shortdescription }" />
								</div>
							</div>

							<br>
							<br>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội dung</label>
								<div class="col-sm-9">
								<%-- 
									<input type="text" class="form-control" id="content" name="content" value="${model.content }" />
									 --%>
									<textarea rows="" cols="" id="content" name="content" style="height: 190px; margin: 0px; width: 815px;">${model.content }</textarea>
								</div>
							</div>
							
							<br>
							<br>
							
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id }">
										<input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddOrUpdateNew" value="Cập nhật bài viết" />
									</c:if>
									<c:if test="${empty model.id }">
										<input type="button" class="btn btn-white btn-warning btn-bold" id="btnAddOrUpdateNew" value="Thêm bài viết" />
									</c:if>
								</div>
						</div>
						<input type="hidden" value="${model.id }" id="id" name="id" />
						</form>
						</div>
					</div>
				</div>

			</div>
		</form>
	</div>


<script type="text/javascript">
	
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});

	$('#btnAddOrUpdateNew').click(function (e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function (i, v) {
			data[""+v.name+""] = v.value;
		});
		data["content"] = editor.getData();
		var id = $('#id').val();
		if(id == ""){
			addNew(data);
		}else{
			updateNew(data);
		}
	});
	function addNew(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";
			},
			error: function (error){
				window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
			},
		});
	}
	function updateNew(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success";
			},
			error: function (error){
				window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
			},
		});
	}
</script>
</body>

</html>