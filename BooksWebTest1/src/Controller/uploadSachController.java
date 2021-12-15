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

import DAO.SanPhamDao;

/**
 * Servlet implementation class uploadSachController
 */
@WebServlet("/uploadSachController")
public class uploadSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadSachController() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		System.out.println("xong");
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
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vtr = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vtr - 1) + "\\WebSach\\WebContent\\anhgiay";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
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
				request.setAttribute("msg", "Mã sách này đã bị trùng, vui lòng nhập mã khác !!");
				request.getRequestDispatcher("View/admin/addbook.jsp").forward(request, response);
				;
			} else {
				int log = sachdao.themSach(masp, tensp,Long.parseLong(soluong), Long.parseLong(gia), anh,
						maloai, mota);
				System.out.println(log);
				request.setAttribute("msg", "bạn đã thêm sách thành công !!");
				request.getRequestDispatcher("View/admin/addbook.jsp").forward(request, response);
				;
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

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
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					anh = "anhgiay\\" + fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vtr = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vtr - 1) + "\\WebSach\\WebContent\\anhgiay";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("magiay")) {
//						response.getWriter().println(fileItem.getString());
//						System.out.println(fileItem.getString());
						masp = fileItem.getString("utf-8").trim();
					}
					if (tentk.equals("tengiay")) {
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
			System.out.println(masp + masp + gia + anh + maloai + soluong + mota + anh);
			SanPhamDao sachdao = new SanPhamDao();
			if (sachdao.checkMaSach(masp)) {
				request.setAttribute("msg", "Mã sách này đã bị trùng, vui lòng nhập mã khác !!");
				request.getRequestDispatcher("View/admin/addbook.jsp").forward(request, response);
				;
			} else {
				int log = sachdao.themSach(masp, tensp,  Long.parseLong(soluong), Long.parseLong(gia), anh,
						maloai, mota);
				System.out.println(log);
				request.setAttribute("msg", "bạn đã thêm sách thành công !!");
				request.getRequestDispatcher("View/admin/addbook.jsp").forward(request, response);
				;
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
