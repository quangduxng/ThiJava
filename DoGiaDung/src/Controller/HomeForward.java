package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.SanPhamBean;
import DAO.SanPhamDao;

/**
 * Servlet implementation class HomeForward
 */
@WebServlet("/HomeForward")
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeForward() {
        super();
        // TODO Auto-generated constructor stub TODO
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SanPhamBean> ds;
		if (request.getParameter("timkiem")!=null)
			ds = SanPhamDao.getSanphamTheoTen(request.getParameter("timkiem"));
		else 
			ds= SanPhamDao.getSp();
		if (request.getParameter("pageid")==null || Integer.parseInt(request.getParameter ("pageid"))==1)		
		{
			request.setAttribute("listsp", ds);
			request.setAttribute("dau", 0);
			request.setAttribute("cuoi", 9<ds.size()?9:ds.size());
			request.setAttribute("tranghientai", 1);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request, response);
		}
		else 
		{
			String page= request.getParameter("pageid");
			int id=Integer.parseInt(page);
			int dau=(id-1)*9;
			int cuoi=dau+9;
			if (cuoi>ds.size())
				cuoi=ds.size();
			request.setAttribute("listsp", ds);
			request.setAttribute("dau", dau);
			request.setAttribute("cuoi", cuoi);
			request.setAttribute("tranghientai", id);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SanPhamBean> ds;
		if (request.getParameter("timkiem")!=null)
			ds = SanPhamDao.getSanphamTheoTen(request.getParameter("timkiem"));
		else 
			ds= SanPhamDao.getSp();
		if (request.getParameter("pageid")==null || Integer.parseInt(request.getParameter ("pageid"))==1)		
		{
			request.setAttribute("listsp", ds);
			request.setAttribute("dau", 0);
			request.setAttribute("cuoi", 9<ds.size()?9:ds.size());
			request.setAttribute("tranghientai", 1);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request, response);
		}
		else 
		{
			String page= request.getParameter("pageid");
			int id=Integer.parseInt(page);
			int dau=(id-1)*9;
			int cuoi=dau+9;
			if (cuoi>ds.size())
				cuoi=ds.size();
			request.setAttribute("listsp", ds);
			request.setAttribute("dau", dau);
			request.setAttribute("cuoi", cuoi);
			request.setAttribute("tranghientai", id);
			RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
			rd.forward(request, response);
		}
	}

}
