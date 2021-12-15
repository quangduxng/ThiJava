package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.SanPhamBean;
import DAO.SanPhamDao;

/**
 * Servlet implementation class EditSach
 */
@WebServlet("/EditSach")
public class EditSach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditSach() {
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
		String masach = request.getParameter("ms");
		SanPhamDao spdao = new SanPhamDao();
		SanPhamBean s = spdao.getSachTheoMa(masach);
		System.out.println("ms=" + s.getMasp() + ";  " + s.getTensp() + "; mota" + s.getMota());
		request.setAttribute("sachItem", s);
		request.getRequestDispatcher("View/admin/editbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);

		try {
			String masp = null;
			String tensp = null;
			String gia = null;
			String maloai = null;
		
			String soluong = null;
			String mota = null;
			String anh = null;
			List<FileItem> fileItems = upload.parseRequest(request);

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					String nameimg = fileItem.getName();
					anh = "image_sach\\" + fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vtr = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vtr - 1) + "\\WebSach\\WebContent\\image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}

					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("masp")) {
//						response.getWriter().println(fileItem.getString());
//						System.out.println(fileItem.getString());
						masp = fileItem.getString("utf-8").trim();
					}
					if (tentk.equals("tensp")) {
						tensp = fileItem.getString("utf-8").trim();
					}
					if (tentk.equals("gia")) {
						gia = fileItem.getString("utf-8").trim();
					}
					if (tentk.equals("maloai")) {
						maloai = fileItem.getString("utf-8").trim();
					}
					
					if (tentk.equals("soluong")) {
						soluong = fileItem.getString("utf-8").trim();
					}
					if (tentk.equals("mota")) {
						mota = fileItem.getString("utf-8").trim();
					}
				}
			}
			System.out.println(masp + tensp + gia + anh + maloai + soluong + mota + anh);
			SanPhamDao sachdao = new SanPhamDao();
			if (sachdao.checkMaSach(masp)) {
				int log = sachdao.suaSach(masp, tensp, Long.parseLong(soluong), Long.parseLong(gia), anh,
						maloai, mota);
			} else {
				System.out.println("mã loại sai rồi");
			}

		} catch (

		FileUploadException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("QuanlysachController").forward(request, response);
	}

}
