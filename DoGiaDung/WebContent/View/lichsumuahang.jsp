<%@page import="BEAN.ChitiethoadonBean"%>
<%@page import="BEAN.HoadonBean"%>
<%@page import="BEAN.GiohangBean"%>
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
	<%@include file="head.jsp" %>
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <%@include file="bentrai.jsp" %>
            <div class="col-md-9">
              
                <div>
                    <h2 style="text-align:center">LỊCH SỬ MUA HÀNG</h2>
                    
                <table class="table table-striped">
                	<tr>
                		<th>Mã HĐ</th>
                		<th>Ngày mua</th>
                		<th>Mã CTHĐ</th>
                		<th>Tên Sản Phẩm</th>
                		<th>Số lượng</th>
                		<th>Ảnh</th>
                		<th>Trạng Thái</th>
                	</tr>
                	<%
	                ArrayList <HoadonBean> dsHD = (ArrayList <HoadonBean>)request.getAttribute("dsHD") ;
	                if (dsHD!=null)
	                for (HoadonBean hd :dsHD)
	                {
	                %>
						<%for (ChitiethoadonBean ct :hd.getDanhsachCT()) { %>
						
						<tr>
	                		<td>
	                			<%=hd.getMahoadon() %>
	                		</td>
	                		<td>
	                			<%=hd.getNgaymua() %>
	                		</td>
	                		<td>
	                			<%=ct.getMaChiTietHD() %>
	                		</td>
	                		<td>
	                			<%=ct.getTensp()%>
	                		</td>
	                		<td>
	                			<%=ct.getSoluong() %>
	                		</td>
	                		<td>
	                			<img alt="<%=ct.getMasp() %>" src="<%=ct.getAnh()%>">
	                		</td>
	                		<td>
	                			<%=hd.isDamua() ? "Đã duyệt": "Chưa duyệt" %>
	                		</td>
	                	</tr>
						<%} %>
						</div>
						
					<%} %>
                	
                </table>
                
            	</div>
            	
        	</div>
    	</div>
    </div>
    <!-- /.container -->
    <%@include file ="foot.jsp" %>
    
	
</body>
</html>