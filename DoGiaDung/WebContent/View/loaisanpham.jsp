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
                    <h3 style="Text-align:Center; color:red"> <%=(String)request.getAttribute("tenloai")%> </h3>
                    
                    <div class="row">
                    <%
                    	ArrayList <SanPhamBean> ds = (ArrayList <SanPhamBean>)request.getAttribute("listsanpham"); 
                                        	                    int dau=(int)request.getAttribute("dau");
                                        	                	int cuoi=(int)request.getAttribute("cuoi");
                                        	                	int trangcuoi=(int)Math.ceil((double)ds.size()/9);
                                                            	int tranghientai=(int)request.getAttribute("tranghientai");
                                                            for (SanPhamBean sach:ds.subList(dau,cuoi))
                                                            {
                    %>
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail" style ="height:450px;">
                                <a href="chitietsachController?masanpham=<%=sach.getMasp()%>&tensanpham=<%=sach.getTensp()%>&gia=<%=sach.getGia()%>&anh=<%=sach.getAnh()%>&soluong=1">
                                    <img alt="<%=sach.getTensp()%> " src="<%=sach.getAnh()%>"  />
                                    <div>
                                        <br/>
                                        <h4 style="text-align:center">
                                            <%=sach.getTensp()%>
                                        </h4>
                                        <p></p>
                                    </div>
                                 </a> 
                         
                                <div>
                            		<a href="MuahangController?masanpham=<%=sach.getMasp()%>&tensanpham=<%=sach.getTensp()%>&gia=<%=sach.getGia()%>&anh=<%=sach.getAnh()%>&soluong=1"> <img alt="datmua"  src="anhsanpham/datmua.png" style="width:180px"> </a>
                           		</div>
                                
                            </div>
                          
                        </div> 
					<%} %>
    				</div>
    				     
                    <div class="MenuTrang">
                        <div class="pagination-container">
	                        <ul class="pagination">
	                        	
			                    <%for (int i=1;i<=trangcuoi;i++) {
			                    	if (tranghientai==i)
			                    	{
			                    %>
			                    	<li class="active"><a><%=tranghientai%></a></li>
			                    <%	} 
			                    	else {%>
			                    	<li><a href="loaiController?pageid=<%=i%>&maloai=<%=(String)request.getAttribute("maloai")%>&tenloai=<%=(String)request.getAttribute("tenloai")%>"><%=i%></a></li>
			                    	<%} %>
			                    
			                    <%} %>
			                    
			                    
			                    
	                        </ul>
                        </div>
                    </div>
                    
                </div>

            </div>
        </div>
    </div>
    <!-- /.container -->
    <%@include file ="foot.jsp" %>
    
	
</body>
</html>