package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DungChung;
import DAO.SanPhamDao;

/**
 * Servlet implementation class insertSach
 */
@WebServlet("/insertSach")
public class insertSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "image_sach";
	static SecureRandom rnd = new SecureRandom();

//    static String rd = randomString(4);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String mota = request.getParameter("mota");
		String masach = request.getParameter("masach");
		String tensach = request.getParameter("tensach");
		String tacgia = request.getParameter("tacgia");
		String soluong = request.getParameter("soluong");
		String gia = request.getParameter("gia");
		String maloai = request.getParameter("maloai");

//    	SachBean sach = new SachBean(masach, tensach, tacgia, Long.parseLong(soluong), 
//    			Long.parseLong(gia), Integer.parseInt(sotap),
//    			"image_sach/"+uploadFile(request,response),
//    			maloai, date,mota);

		SanPhamDao sachdao = new SanPhamDao();
		try {
			DungChung dc = new DungChung();
			dc.KetNoi();

			if (sachdao.checkMaSach(masach)) {
				request.setAttribute("error", "ĐÃ TỒN TẠI");
				RequestDispatcher rd = request.getRequestDispatcher("View/admin/addbook.jsp");
				rd.forward(request, response);
			} else {
				System.out.println(
						masach + " " + tensach + " " + tacgia + " " + soluong + " " + gia + " " + maloai + " " + mota);
//        		sachdao.themSach(tensach, tacgia,Long.parseLong(soluong) , Long.parseLong(gia), uploadFile(request, response), maloai, mota);

				// request.setAttribute("fileName", uploadFile(request,response));
				response.sendRedirect("QuanlysachController");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String fileName = "";
		try {
			Part filePart = request.getPart("photo");
			fileName = getFileName(filePart);
			fileName = (new Date()).getTime() + fileName;
			String applicationPath = request.getServletContext().getRealPath("");
			String basePath = applicationPath + File.separator + UPLOAD_DIRECTORY + File.separator;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				File outputFilePath = new File(basePath + fileName);
				String filepath = outputFilePath.toString();
				System.out.println(filepath);
				File file = new File(filepath);
				if (file.exists()) {
					file.delete();
					System.out.println("thanh cong");
				} else {
					inputStream = filePart.getInputStream();
					outputStream = new FileOutputStream(outputFilePath);
					int read = 0;
					final byte[] bytes = new byte[1024];
					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				fileName = "";
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}

		} catch (Exception e) {
			fileName = "";
		}
		return fileName;
	}

	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		// System.out.println("*****partHeader :"+ partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
//    static String randomString( int len ){
//	   StringBuilder sb = new StringBuilder( len );
//	   for( int i = 0; i < len; i++ ) 
//	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
//	   return sb.toString();
//	}

}
