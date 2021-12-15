package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDao;

/**
 * Servlet implementation class DangkyController
 */
@WebServlet("/DangkyController")
public class DangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangkyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!KhachHangDao.kttontai(request.getParameter("TenDN"))) {

			String ht = request.getParameter("HotenKH");
			String dc = request.getParameter("Diachi");
			String sdt = request.getParameter("Dienthoai");
			String email = request.getParameter("Email");
			String tendn = request.getParameter("TenDN");
			String pass = request.getParameter("Matkhau");
			KhachHangDao.InsertKH(ht, dc, sdt, email, tendn, pass);

			request.setAttribute("msgdangky", "Ban da dang ky thanh cong");
			RequestDispatcher rd = request.getRequestDispatcher("View/dangky.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msgdangky", "Ten dang nhap ton tai, vui long nhap lai !");
			RequestDispatcher rd = request.getRequestDispatcher("View/dangky.jsp");
			rd.forward(request, response);
		}
	}

}
