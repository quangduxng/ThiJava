package Controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DungChung;

/**
 * Servlet implementation class DangnhapController
 */
@WebServlet("/DangnhapController")
public class DangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangnhapController() {
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
		String tendn = request.getParameter("TenDN");
		String pass = request.getParameter("Matkhau");

		String sql = "select * from KhachHang where tendn=? and pass=?";

		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				if (rs.getBoolean("quyen")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("sessionMaAD", rs.getString("makh"));
					session.setAttribute("sessionAD", rs.getString("tendn"));
					session.setAttribute("sessionTenAD", rs.getString("hoten"));
					RequestDispatcher rd = request.getRequestDispatcher("HomeadminForward");
					rd.forward(request, response);
				} else {
					HttpSession session = request.getSession(true);
					session.setAttribute("sessionMaKH", rs.getString("makh"));
					session.setAttribute("sessionTenDN", rs.getString("tendn"));
					session.setAttribute("sessionTenKH", rs.getString("hoten"));
					RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("msgdangnhap",
						"Tài khoản hoặc mật khẩu bạn nhập không chính xác, vui lòng nhập lại");
				RequestDispatcher rd = request.getRequestDispatcher("View/dangnhap.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
