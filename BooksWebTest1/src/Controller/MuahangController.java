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
 * Servlet implementation class MuahangController
 */
@WebServlet("/MuahangController")
public class MuahangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuahangController() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("sessionTenKH") == null) {
			request.setAttribute("msgdangnhap", "Vui lòng đăng nhập để mua hàng!");
			RequestDispatcher rd = request.getRequestDispatcher("View/dangnhap.jsp");
			rd.forward(request, response);

		} else {

			String masach = request.getParameter("masach");
			String tensach = request.getParameter("tensach");
			long gia = Long.parseLong(request.getParameter("gia"));
			String anh = request.getParameter("anh");
			long soluong = Long.parseLong(request.getParameter("soluong"));
			GiohangBean tam = new GiohangBean();
			tam.setMasp(masach);
			tam.setTensp(tensach);
			tam.setAnh(anh);
			tam.setGia(gia);
			tam.setSoluong(soluong);
			ArrayList<GiohangBean> dsgiohang = (ArrayList<GiohangBean>) session.getAttribute("dsgiohang");
			int kt = 0;
			if (session.getAttribute("dsgiohang") == null)
				dsgiohang = new ArrayList<GiohangBean>();
			else {

				for (GiohangBean gh : dsgiohang) {

					if (gh.getMasp().equals(masach)) {

						gh.setSoluong(gh.getSoluong() + 1);
						kt = 1;
						break;
					}
				}

			}
			if (kt == 0)
				dsgiohang.add(tam);
			session.setAttribute("dsgiohang", dsgiohang);
			RequestDispatcher rd = request.getRequestDispatcher("View/giohang.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
