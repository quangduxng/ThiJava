<%@page import="DAO.HoaDonDao"%>
<%@page import="BEAN.HoadonBean"%>
<%@page import="DAO.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
	<link href="admin/css/bootstrap.min.css" rel="stylesheet">
	<link href="admin/css/font-awesome.min.css" rel="stylesheet">
	<link href="admin/css/datepicker3.css" rel="stylesheet">
	<link href="admin/css/styles.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

</head>
<body>
	<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Home</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản lý</h1>
			</div>
		</div><!--/.row-->
		
		<div class="panel panel-container">
			<div class="row">
			<%ArrayList<HoadonBean> ds =HoaDonDao.getHoaDonChuaMua();  %>
				<div class="col-xs-6 col-md-6 col-lg-6 no-padding">
					<div class="panel panel-teal panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
							<div class="large"><%=ds.size() %></div>
							<div class="text-muted">New Orders</div>
						</div>
					</div>
				</div>
				
				<%-- <div class="col-xs-6 col-md-6 col-lg-6 no-padding">
					<div class="panel panel-orange panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
							<div class="large"><%=KhachHangDao.getSoluongKH() %></div>
							<div class="text-muted">Users</div>
						</div>
					</div>
				</div> --%>
			</div><!--/.row-->
		</div>
</body>
</html>