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
                    <h4 style="color:red; text-align:center"> </h4>
                    <h3 style="text-align:center">ĐĂNG NHẬP</h3><table align="center">

                        <form action="DangnhapController" method="post">
                        <h5 style="text-align:center;color:red"><%=request.getAttribute("msgdangnhap")!=null?request.getAttribute("msgdangnhap"):"" %></h5>
                        <tbody>
                        
                            <tr style="height:40px">
                                <td> Tên đăng nhập:</td>
                                <td>
                                    <input id="TenDN" name="TenDN" type="text" value="">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td align="right">  Mật khẩu:</td>
                                <td>
                                    <input id="Matkhau" name="Matkhau" type="password">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td></td>
                                <td>
                                    <input type="Submit" class="btn btn-primary" value="Đăng nhập">
                                </td>
                            </tr>
                        </tbody>
                        </form>
                    </table>
                </div>
                

            </div>
        </div>
    </div>
    <!-- /.container -->
    <%@include file ="foot.jsp" %>
    
	
</body>
</html>