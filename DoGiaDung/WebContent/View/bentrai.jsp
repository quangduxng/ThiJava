<%@page import="DAO.LoaiDAO"%>
<%@page import="BEAN.loaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- font awesome -->
    <link href="Content/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
</head>
<body>
	<div class="col-md-3">

                <p class="lead" style="text-align: center;">Danh Mục Sản Phẩm</p>
                <div class="list-group">
                <%ArrayList <loaiBean> dsloai = LoaiDAO.getLoai();
                for (loaiBean loai:dsloai)
                {
                %>
                    <a href="loaiController?maloai=<%=loai.getMaloai()%>&tenloai=<%=loai.getTenloai()%>" class="list-group-item">
                        <%=loai.getTenloai() %>
                    </a>
                 <%} %> 
                </div>
                
                <h3>Tìm kiếm</h3>
                <form action ="HomeForward" method="get" class="btn-group input-group md-form form-sm form-2 pl-0 " style="display:flex;margin-bottom:10px;">
                
				  <input name="timkiem" class="form-control my-0 py-1 lime-border" type="text" placeholder="Search" aria-label="Search">
				  <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
				</form>
				
				




            </div>
</body>
</html>