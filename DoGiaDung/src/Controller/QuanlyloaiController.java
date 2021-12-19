package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoaiDAO;

/**
 * Servlet implementation class QuanlyloaiController
 */
@WebServlet("/QuanlyloaiController")
public class QuanlyloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanlyloaiController() {
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String maloai = request.getParameter("txtmaloai");
		String tenloai = request.getParameter("txttenloai");
		LoaiDAO loaidao = new LoaiDAO();
		try {
			if (request.getParameter("btnthem") != null) {

				int rs = loaidao.Them(maloai, tenloai);
				if (rs == 0)
					request.setAttribute("ktnhap", 0);
			}
			if (request.getParameter("btnsua") != null) {
				int rs = loaidao.Sua(maloai, tenloai);
				if (rs == 0)
					request.setAttribute("ktnhap", 0);
			}
			if (request.getParameter("mlchon") != null) {
				request.setAttribute("chon", loaidao.getTheoMaLoai(request.getParameter("mlchon")));
				request.getRequestDispatcher("View/admin/qlloai.jsp").forward(request, response);
			}
			if (request.getParameter("mlxoa") != null) {
				String ml = request.getParameter("mlxoa");
				int n = loaidao.Xoa(ml);
				if (n == 0)
					request.setAttribute("ktxoa", 0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("dsloai", loaidao.getLoai());
		request.getRequestDispatcher("View/admin/qlloai.jsp").forward(request, response);
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
