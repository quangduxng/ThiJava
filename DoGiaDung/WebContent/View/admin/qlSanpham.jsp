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

<!--Custom Font-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
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
				<h3 class="page-header">Tất cả sản phẩm</h3>
			</div>
			<a class="m-0 font-weight-bold text-primary" href="#">
				<i class="fa fa-plus"></i> <input type="Submit"
				class="btn btn-danger" value="Thêm sản phẩm mới">
			</a>
		</div>
		<!--/.row-->

		<div>
			<table border="1" class="table table-hover" id="dataTable"
				width="100%">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Ảnh</th>
						<th>Giá</th>
					
						<th>Mã loại</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<%
					ArrayList<SanPhamBean> lsSp = (ArrayList<SanPhamBean>) request.getAttribute("lsSp");
								for (SanPhamBean s : lsSp) {
				%>
				<tr>
					<td><%=s.getMasp()%></td>
					<td><%=s.getTensp()%></td>
					<td><img height="50px" alt="<%=s.getAnh()%>"
						src="<%=s.getAnh()%>"></td>
					<td><%=s.getGia()%></td>
					
					<td><%=s.getMaloai()%></td>
					<td><a href="EditSanpham?ms=<%=s.getMasp()%>"onsubmit = "return validateForm()">Sửa</a> <a
						href="DeleteSanpham?ms=<%=s.getMasp()%>"> Xóa</a></td>
				</tr>
				<%
					}
				%>
				<tbody>

				</tbody>

			</table>


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
		$(document).ready(function() {
			$('#dataTable').DataTable();
		});
	</script>



</body>
</html>