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
import BEAN.SanPhamBean;

/**
 * Servlet implementation class xoa
 */
@WebServlet("/xoa")
public class xoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masp = request.getParameter("masp");
		HttpSession session = request.getSession();
		ArrayList<GiohangBean> dsgiohang = (ArrayList<GiohangBean>) session.getAttribute("dsgiohang");
		if (dsgiohang!=null)
		{
			for (GiohangBean gh : dsgiohang)
			{
				if (gh.getMasp().equals(masp))
				{
					dsgiohang.remove(gh);
					break;
				}
				
			}
		}
		session.setAttribute("dsgiohang", dsgiohang);
		RequestDispatcher rd = request.getRequestDispatcher("View/giohang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
