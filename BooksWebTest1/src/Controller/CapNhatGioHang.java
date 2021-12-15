package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.GiohangBean;

/**
 * Servlet implementation class CapNhatGioHang
 */
@WebServlet("/CapNhatGioHang")
public class CapNhatGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String masp = request.getParameter("txtMasach");
		long soluong = Long.parseLong(request.getParameter("txtSoluong"));
		System.out.println("txtSoluong");
		ArrayList<GiohangBean> dsgiohang= (ArrayList<GiohangBean>) session.getAttribute("dsgiohang");
		if (dsgiohang!=null)
		{
			for (GiohangBean gh:dsgiohang)
			{
				if (gh.getMasp().equals(masp))
				{
					gh.setSoluong(soluong);
					System.out.println(soluong);
					break;
				}
			}
		}
		session.setAttribute("dsgiohang", dsgiohang);
		RequestDispatcher rd= request.getRequestDispatcher("View/giohang.jsp");
		rd.forward(request, response);
	}

}
