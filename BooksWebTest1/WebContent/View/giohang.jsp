<%@page import="BEAN.GiohangBean"%>
<%@page import="BEAN.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nhà sách Tri thức</title>

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
                <%@include file="slide.jsp" %>
                <div>
                    <h2 style="text-align:center">THÔNG TIN GIỎ HÀNG</h2>
                    <table align="center" border="1">
                        <tbody>
                            <tr style="text-align:center; font-weight:bold">
                                <td>  Mã Sản Phẩm </td>
                                <td> Tên Sán Phẩm </td>
                                <td> Ảnh Sản Phẩm </td>
                                <td> Số lượng </td>
                                <td> Đơn giá </td>
                                <td> Thành tiền </td>
                                <td width="50px"></td>
                                <td width="50px"></td>
                                <td width="50px"></td>
                            </tr>
                            <% ArrayList<GiohangBean> dsgiohang= (ArrayList<GiohangBean>)session.getAttribute("dsgiohang");
                            long soluong=0;
                            long tongtien=0;
                            if(session.getAttribute("dsgiohang")!=null)
                            {
	                            for (GiohangBean gh : dsgiohang)
	                            { soluong+=gh.getSoluong(); tongtien+=gh.getThanhTien();
                            %>
                            <tr style="text-align:center; font-weight:bold">
                                <td> <%=gh.getMasp()%> </td>
                                <td> <%=gh.getTensp() %></td>
                                <td><img src="<%=gh.getAnh()%>"></td>
                                <form action="CapNhatGioHang" method="post">
                                <input type="text" name="txtMasach" value="<%=gh.getMasp()%>" style="display:none">
                                <td>
                                    <input type="number" min="1" name="txtSoluong" value="<%=gh.getSoluong() %>" style="background-color:cyan">
                                </td>
                                <td><%=gh.getGia() %> </td>
                                <td><%=gh.getThanhTien() %> </td>
                                <td> <a href="chitietsachController?masach=<%=gh.getMasp() %>"> Chi tiết </a></td>
                                <td> <a href="xoa?masach=<%=gh.getMasp()%>">Xóa</a></td>
                                <td> <input type="submit" value="Cập Nhật"></td>
                                </form>
                            </tr>
                           <%	}
                            } %>
                            
                            <tr style="font-weight: bold; text-align:right; color:red">
                                <td colspan="4" align="center"> Số lượng : <%=soluong %> </td>
                                <td colspan="5" align="center"> Tổng tiền: <%=tongtien %> VNĐ </td>
                            </tr>
                            <tr style="font-weight: bold; color:blue; text-align:right ">
                                <td colspan="9" align="center">
                                    <a href="xoatatcagiohang">Xóa Giỏ Hàng</a>
                                </td>
                            </tr>
                            <tr style="font-weight: bold; color:blue; text-align:right ">
                                <td colspan="9" align="center">
                                    <a href="DathangController">ĐẶT HÀNG</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                

            </div>
        </div>
    </div>
    <!-- /.container -->
    <%@include file ="foot.jsp" %>
    
	
</body>
</html>