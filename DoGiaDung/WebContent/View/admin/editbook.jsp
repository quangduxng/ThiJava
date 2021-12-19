<%@page import="DAO.SanPhamDao"%>
<%@page import="BEAN.loaiBean"%>
<%@page import="DAO.LoaiDAO"%>
<%@page import="BEAN.SanPhamBean"%>
<%@page import="BEAN.KhachHangBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ADMIN</title>
<link href="admin/css/bootstrap.min.css" rel="stylesheet">
<link href="admin/css/font-awesome.min.css" rel="stylesheet">
<link href="admin/css/styles.css" rel="stylesheet">




<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://mdbootstrap.com/live/_MDB/css/customizer.min.css">
<link href="admin/css/mdb.min.css" rel="stylesheet">
<!--Custom Font-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>
<body>

	<!-- begin head -->
	<%@include file="head.jsp"%>
	<!-- end head -->

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive"
					alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%=session.getAttribute("sessionTenAD")%></div>
				<div class="profile-usertitle-status">
					<span class="indicator label-success"></span>Online
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>

		<ul class="nav menu">
			<li><a href="quanlydonhangController"><em
					class="fa fa-dashboard">&nbsp;</em> Quản lý đơn hàng</a></li>
			<li><a href="QuanlytaikhoanController"><em
					class="fa fa-calendar">&nbsp;</em> Quản lý tài khoản</a></li>
			<li class="active"><a href="QuanlysachController"><em
					class="fa fa-book">&nbsp;</em> Quản lý sản phẩm</a></li>
			<li ><a href="QuanlyloaiController"><em
					class="fa fa-edit">&nbsp;</em> Quản lý loại sản phẩm</a></li>		
			<li><a href="DangxuatController"><em class="fa fa-power-off">&nbsp;</em>
					Logout</a></li>
		</ul>
	</div>
	<!--/.sidebar-->



	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"> <em class="fa fa-home"></em>
				</a></li>
				<li class="active">Quản lý</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="display-3">Sửa sản phẩm</h1>
				<br>
			</div>

		</div>
		<!--/.row-->
		<%
			LoaiDAO loaidao = new LoaiDAO();
			ArrayList<loaiBean> lsLoai = loaidao.getLoai();
			
			SanPhamBean sp = (SanPhamBean)request.getAttribute("spItem");
		%>

		<div class="container" style="padding-bottom: 50px">
			<div style="min-height: 78vh">
				<br>
				<h2 style="color:red"><%=request.getAttribute("msg")!=null?request.getAttribute("msg"):""%></h2> 
				<form action="EditSanpham" method="post" enctype="multipart/form-data">

					
					<input style="display:none" type="text"   value="<%=sp.getMasp() %>" name="masp" id="masp"> 
					
					<label for="name">Tên sản phẩm: </label>
						 <input type="text" name="tensp" value="<%=sp.getTensp() %>" id="tensp"> <br> <br> <label for="price">Giá:
					</label> <input value="<%=sp.getGia() %>" type="number" name="gia" id="gia"> <br> <br>
					<label for="loai">Loại sản phẩm: </label> 
					<select value="<%=sp.getMaloai() %>"
						style="display: block !important;" class="form-control"
						name="maloai">
						<%
							for (loaiBean l : lsLoai) {
						%>
						<option value="<%=l.getMaloai()%>"><%=l.getTenloai()%></option>
						<%
							}
						%>
					</select> 
					<br> 
				
					<label for="star">Số lượng: </label> <br>
					<input type="number" min="1" max="2000" name="soluong" id="soluong" value="<%=sp.getSoluong() %>"> <br>
					<br> <label for="image">Ảnh: </label> <br> 
					<input type="file" name="photo" id="photo"> <br> <br> <br>
					<label for="mota">Mô tả đầy đủ: </label> <br> <br>
					<textarea name="mota" value="<%=sp.getMota() %>" id="mota"></textarea>
					<button class="btn btn-info" type="submit">Sửa sản phẩm</button>

				</form>
				
			</div>
		</div>

	</div>
	<!--/.main-->

	<script src="admin/js/jquery-1.11.1.min.js"></script>
	<script src="admin/js/bootstrap.min.js"></script>
	<script src="admin/js/chart.min.js"></script>
	<script src="admin/js/chart-data.js"></script>
	<script src="admin/js/easypiechart.js"></script>
	<script src="admin/js/easypiechart-data.js"></script>
	<script src="admin/js/bootstrap-datepicker.js"></script>
	<script src="admin/js/custom.js"></script>

	<script src="admin/datatables/jquery.dataTables.min.js"></script>
	<script src="admin/datatables/dataTables.bootstrap4.min.js"></script>
	<script>
		CKEDITOR.replace('mota', {
			height : 300,
			filebrowserUploadUrl : "upload.php"
		});
		CKEDITOR.instances.mota.setData( `<%=sp.getMota()%>` );
	</script>



</body>
</html>