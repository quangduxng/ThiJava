<%@page import="BEAN.loaiBean"%>
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
	<%@include file="head.jsp" %>
	 <!-- end head -->
	
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%=session.getAttribute("sessionTenAD") %></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		
		<ul class="nav menu">
			<li><a href="quanlydonhangController"><em
					class="fa fa-dashboard">&nbsp;</em> Quản lý đơn hàng</a></li>
			<li><a href="QuanlytaikhoanController"><em
					class="fa fa-calendar">&nbsp;</em> Quản lý tài khoản</a></li>
			<li><a href="QuanlysachController"><em
					class="fa fa-book">&nbsp;</em> Quản lý sách</a></li>
			<li class="active" ><a href="QuanlyloaiController"><em
					class="fa fa-edit">&nbsp;</em> Quản lý loại sách</a></li>		
			<li><a href="DangxuatController"><em class="fa fa-power-off">&nbsp;</em>
					Logout</a></li>
		</ul>
	</div>
	<!--/.sidebar-->
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Quản lý </li>
			</ol>
		</div><!--/.row-->
		
		
		
		<div>
	<% if (request.getAttribute("ktnhap")!=null) 
		out.print("<script>alert('trung ma')</script>");
		loaiBean loai = (loaiBean)request.getAttribute("chon");
		%>
	<div class="container">
		<br>
		<form >
		<% if(loai != null){ %>
			<label>Mã loại</label>
			<input type="text" name="txtmaloai" value="<%=loai.getMaloai()%>"> <br>
			<label>Tên loại</label>
			<input type="text" name="txttenloai" value="<%=loai.getTenloai()%>"> <br>
			<input type="submit" name="btnthem" value="Them" class="btn btn-success"/>
			<input type="submit" name="btnsua" value="Sua" class="btn btn-primary"/>
			<%}else{ %>
			<label>Mã loại</label>
			<input type="text" name="txtmaloai" value=""> <br>
			<label>Tên loại</label>
			<input type="text" name="txttenloai" value=""> <br>
			<input type="submit" name="btnthem" value="Them" class="btn btn-success"/>
			<input type="submit" name="btnsua" value="Sua" class="btn btn-primary"/>
			<%} %>
		</form>
		<br>
		<table class="table table-hover table-border">
		<%ArrayList<loaiBean> ds = (ArrayList<loaiBean>) request.getAttribute("dsloai"); 
		for(loaiBean l:ds){%>
			<tr>
				<td>
					<%=l.getMaloai() %>
				</td>
				<td>
					<%=l.getTenloai() %>
				</td>
				<td>
					<a href="QuanlyloaiController?mlchon=<%=l.getMaloai() %>"> <span class="glyphicon glyphicon-ok"></span> Chọn</a>
					<a href="QuanlyloaiController?mlxoa=<%=l.getMaloai() %>"><span class="glyphicon glyphicon-delete"></span>Xóa</a>
				</td>
			</tr>
		<%} %>
		</table>
	</div>
	</div>		
	</div>	<!--/.main-->
</body>
</html>