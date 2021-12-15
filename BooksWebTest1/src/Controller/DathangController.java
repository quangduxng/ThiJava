package Controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.GiohangBean;
import DAO.DungChung;

/**
 * Servlet implementation class DathangController
 */
@WebServlet("/DathangController")
public class DathangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DathangController() {
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
		ArrayList<GiohangBean> dsgiohang = (ArrayList<GiohangBean>) session.getAttribute("dsgiohang");
		String makh = (String) session.getAttribute("sessionMaKH");
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "insert into hoadon (makh,ngaymua,damua) values (?,?,?)";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			java.sql.Date ngay = new java.sql.Date((new java.util.Date()).getTime());
			cmd.setString(1, makh);
			cmd.setDate(2, ngay);
			cmd.setBoolean(3, false);
			cmd.executeUpdate();
			sql = "SELECT Max(MaHoaDon) as LastID FROM hoadon";
			cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			rs.next();
			Long mahoadon = rs.getLong("LastID");

			for (GiohangBean gh : dsgiohang) {
				sql = "insert into ChiTietHoaDon (masp,SoLuongMua,MaHoaDon) values(?,?,?)";
				cmd = DungChung.cn.prepareStatement(sql);
				cmd.setString(1, gh.getMasp());
				cmd.setLong(2, gh.getSoluong());
				cmd.setLong(3, mahoadon);
				cmd.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("dsgiohang", new ArrayList<GiohangBean>());
		RequestDispatcher rd = request.getRequestDispatcher("View/giohang.jsp");
		rd.forward(request, response);
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
