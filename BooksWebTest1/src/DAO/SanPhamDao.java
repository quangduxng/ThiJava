package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.SanPhamBean;

public class SanPhamDao {
	public static ArrayList<SanPhamBean> getSach() {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from GiaDung";
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SanPhamBean tam = new SanPhamBean();
				tam.setMasp(rs.getString("masp"));
				//System.out.println(rs.getString("magiay"));
				tam.setTensp(rs.getString("tensp"));
				//System.out.println(rs.getString("tengiay"));
				
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				
				tam.setMota(rs.getString("mota"));
				ds.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public static ArrayList<SanPhamBean> getSachTheoTen(String ten) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from GiaDung where tensp like ?";
		ArrayList<SanPhamBean> ds = new ArrayList<SanPhamBean>();
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, "%" + ten + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SanPhamBean tam = new SanPhamBean();
				tam.setMasp(rs.getString("masp"));
				tam.setTensp(rs.getString("tensp"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				tam.setMota(rs.getString("mota"));
				ds.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;

	}

	public static boolean checkMaSach(String ma) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from GiaDung where masp= ?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static int themSach(String masp, String tensp,  Long soluong, Long gia, String anh,
			String maloai, String mota) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "INSERT INTO GiaDung (masp, tensp, soluong, gia, anh, maloai, mota) VALUES ( ? , ? , ? , ? ,?,?,?,? );";

		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			cmd.setString(2, tensp);
			
			cmd.setLong(3, soluong);
			cmd.setLong(4, gia);
			cmd.setString(5, anh);
			cmd.setString(6, maloai);
			cmd.setString(7, mota);
			return cmd.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static int suaSach(String masp, String tensp,  Long soluong, Long gia, String anh,
			String maloai, String mota) {
		DungChung dc = new DungChung();
		
		dc.KetNoi();
		String sql = "update GiaDung set tensp = ? ,, soluong=?, gia=?, anh=?,maloai=?,mota=? where masp = ?";
		if (anh == "" || anh == null) {
			sql = "update GiaDung set tensp = ? , soluong=?, gia=?, anh= ?, maloai=?, mota=? where masp = ?";
			try {
				PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
				cmd.setString(7, masp);
				cmd.setString(1, tensp);
			
				cmd.setLong(2, soluong);
				cmd.setLong(3, gia);
				cmd.setLong(4, gia);
				cmd.setString(5, maloai);
				cmd.setString(6, mota);
				return cmd.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
				cmd.setString(7, masp);
				cmd.setString(1, tensp);
			
				cmd.setLong(2, soluong);
				cmd.setLong(3, gia);
				cmd.setLong(4, gia);
				cmd.setString(5, maloai);
				cmd.setString(6, mota);
				return cmd.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	public static int xoaSach(String masp) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "delete from GiaDung where masp = ?";
		System.out.println(sql + masp);
		System.out.println(masp);
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, masp);
			return cmd.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static SanPhamBean getSachTheoMa(String ma) {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from GiaDung where masp = ?";
		try {
			PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
			cmd.setString(1, ma);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				SanPhamBean tam = new SanPhamBean();
				tam.setMasp(rs.getString("masp"));
				tam.setTensp(rs.getString("tensp"));
				tam.setSoluong(rs.getLong("soluong"));
				tam.setGia(rs.getLong("gia"));
				tam.setAnh(rs.getString("anh"));
				tam.setMaloai(rs.getString("maloai"));
				tam.setMota(rs.getString("mota"));
				return tam;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
