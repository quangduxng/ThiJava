package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.KhachHangBean;
import DAO.DungChung;

public class KhachHangDao {
	public static void InsertKH(String ht, String dc, String sdt, String email, String tendn, String pass) {
		
		
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		
		String sql = "insert into KhachHang (hoten,diachi,sodt,email,tendn,pass,quyen) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			cmd.setString(1, ht);
			cmd.setString(2, dc);
			cmd.setString(3, sdt);
			cmd.setString(4, email);
			cmd.setString(5, tendn);
			cmd.setString(6, pass);
			cmd.setBoolean(7, false);
			cmd.executeUpdate();
			System.out.println("thanhcong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean kttontai(String tendn) {
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		String sql = "select * from KhachHang where tendn=?";
		try {
			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean DangNhap(String tendn, String pass) {
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		String sql = "select * from KhachHang where tendn=? and pass=?";

		try {
			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static long getSoluongKH() {
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		String sql = "select Count(*) as sl from KhachHang where quyen=0";
		try {
			
			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			long soluong = rs.getLong("sl");
			System.out.println(soluong + "..................................");
			return soluong;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<KhachHangBean> getDsKhachHang() {
		ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		String sql = "select * from KhachHang";
		try {
			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				KhachHangBean tam = new KhachHangBean(rs.getString("makh"), rs.getString("hoten"),
						rs.getString("diachi"), rs.getString("sodt"), rs.getString("email"), rs.getString("tendn"),
						rs.getString("pass"), rs.getBoolean("quyen"));
				ds.add(tam);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static void XoaKhachHang(String makh) {
		DungChung dc1 = new DungChung();
		dc1.KetNoi();
		//
		String sql1 = "delete from chitiethoadon where mahoadon in (Select mahoadon from hoadon where makh=?)";
		String sql2 = "delete from hoadon where makh=?";
		String sql = "delete from KhachHang where makh=?";
		try {
			PreparedStatement cmd1 = dc1.cn.prepareStatement(sql1);
			cmd1.setString(1, makh);
			cmd1.executeUpdate();

			PreparedStatement cmd2 = dc1.cn.prepareStatement(sql2);
			cmd2.setString(1, makh);
			cmd2.executeUpdate();

			PreparedStatement cmd = dc1.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
