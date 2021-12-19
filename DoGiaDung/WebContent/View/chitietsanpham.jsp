<%@page import="DAO.SanPhamDao"%>
<%@page import="BEAN.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cửa Hàng Gia Dụng</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="Content/bootstrap.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="Content/shop-homepage.css" rel="stylesheet" />
</head>
<body>
	<%@include file="head.jsp"%>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<%@include file="bentrai.jsp"%>
			<div class="col-md-9">
			


				<div>


					<style type="text/css">
#Datmua a {
	clear: both;
	background-color: red;
	color: white;
	width: 120px;
	height: 35px;
	display: block;
	float: right;
	text-align: center;
	padding-top: 10px;
	text-decoration: none;
	font-weight: bold;
}

#Datmua a:hover {
	background-color: gray;
	color: red;
}
</style>

					<%
						String masp = request.getParameter("masanpham");
																	SanPhamDao spdao = new SanPhamDao();
																	SanPhamBean tam = spdao.getSpTheoMa(masp);

																	String tensp = tam.getTensp();
																	long gia = tam.getGia();
																	String anh = tam.getAnh();
																	long soluong = tam.getSoluong();
					%>


					<h3>THÔNG TIN CHI TIẾT </h3>
					<div>
						<div
							style="width: 40%; float: left; border-left: dotted 1px; border-color: azure">
							<img src="<%=anh%>" width="100%">
						</div>
						<div style="width: 60%; float: left; padding: 10px">
							<h4 style="font-weight: bold; color: red">
								Tên sản phẩm:
								<%=tensp%>
							</h4>
							<p style="text-align: justify">
								<span style="font-weight: bold"> Mô tả: </span>
								<%=tam.getMota()%>
							</p>
							<p style="font-weight: bold">
								Giá bán: <span style="color: red; font-size: 16pt"> <%=gia%>
									VNĐ
								</span>
							</p>
						</div>
						<div>
							<div id="Datmua">
								<a
									href="MuahangController?masach=<%=masp%>&tensach=<%=tensp%>&gia=<%=gia%>&anh=<%=anh%>&soluong=1"
									class="list-group-item"> ĐẶT MUA </a>
							</div>
						</div>
					</div>

				</div>


			</div>
		</div>
	</div>
	<!-- /.container -->
	<%@include file="foot.jsp"%>


</body>
</html>