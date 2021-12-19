package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.ChitiethoadonBean;
import BEAN.HoadonBean;

public class HoaDonDao {
	public static ArrayList<ChitiethoadonBean> getCTHD(String makh,String mahoadon)
	{
		ArrayList<ChitiethoadonBean> dsCTHD = new ArrayList<ChitiethoadonBean>();
		String sql="SELECT ChiTietHoaDon.MaChiTietHD, ChiTietHoaDon.masp, ChiTietHoaDon.SoLuongMua, ChiTietHoaDon.MaHoaDon,GiaDung.tensp ,GiaDung.anh\r\n"
				+ "				FROM     ChiTietHoaDon INNER JOIN  hoadon ON ChiTietHoaDon.MaHoaDon = hoadon.MaHoaDon INNER JOIN  \r\n"
				+ "				                  GiaDung ON ChiTietHoaDon.masp = GiaDung.masp\r\n"
				+ "				WHERE  (hoadon.makh = ?) AND (hoadon.MaHoaDon = ?)";
		DungChung dc=new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.setString(2, mahoadon);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				ChitiethoadonBean tam = new ChitiethoadonBean();
				String macthd = rs.getString("MaChiTietHD");
				String masp = rs.getString("masp");
				String tensp = rs.getString("tensp");
				String soluong = rs.getString("SoLuongMua");
				String anh =rs.getString("anh");
				tam.setAnh(anh);
				tam.setMaChiTietHD(macthd);
				tam.setMaHoaDon(mahoadon);
				tam.setMasp(masp);
				tam.setTensp(tensp);
				tam.setSoluong(Long.parseLong(soluong));
				dsCTHD.add(tam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsCTHD;
	}
	
	public static ArrayList<HoadonBean> getHoaDon (String makh)
	{
		ArrayList<HoadonBean> dsHoadon= new ArrayList<HoadonBean>();
		String sql= "SELECT hoadon.* FROM     KhachHang INNER JOIN hoadon ON KhachHang.Makh = hoadon.makh WHERE  hoadon.makh = ?";
		DungChung dc = new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs= cmd.executeQuery();
			while (rs.next())
			{
				HoadonBean tam = new HoadonBean();
				String mahoadon=rs.getString("mahoadon");
				Date ngaymua = rs.getDate("ngaymua");
				tam.setMahoadon(mahoadon);
				tam.setMakh(makh);
				tam.setNgaymua(ngaymua);
				tam.setDamua(rs.getBoolean("damua"));
				tam.setDanhsachCT(HoaDonDao.getCTHD(makh, mahoadon));
				dsHoadon.add(tam);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHoadon;
	}
	public static ArrayList<HoadonBean> getHoaDonChuaMua ()
	{
		ArrayList<HoadonBean> dsHoadon= new ArrayList<HoadonBean>();
		String sql= "SELECT hoadon.* , KhachHang.hoten FROM     KhachHang INNER JOIN hoadon ON KhachHang.Makh = hoadon.makh where damua=?";
		DungChung dc = new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
			cmd.setBoolean(1, false);
			ResultSet rs= cmd.executeQuery();
			while (rs.next())
			{
				HoadonBean tam = new HoadonBean();
				String mahoadon=rs.getString("mahoadon");
				Date ngaymua = rs.getDate("ngaymua");
				String makh = rs.getString("makh");
				String hoten = rs.getString("hoten");
				tam.setHoten(hoten);
				tam.setMahoadon(mahoadon);
				tam.setMakh(makh);
				tam.setNgaymua(ngaymua);
				tam.setDamua(rs.getBoolean("damua"));
				tam.setDanhsachCT(HoaDonDao.getCTHD(makh, mahoadon));
				dsHoadon.add(tam);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsHoadon;
	}
	public static ArrayList<HoadonBean> getTatCaHoaDon ()
	{
		ArrayList<HoadonBean> dsHoadon= new ArrayList<HoadonBean>();
		String sql= "SELECT hoadon.* , KhachHang.hoten  FROM     KhachHang INNER JOIN hoadon ON KhachHang.Makh = hoadon.makh";
		DungChung dc = new DungChung();
		dc.KetNoi();
		try {
			PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
			ResultSet rs= cmd.executeQuery();
			while (rs.next())
			{
				HoadonBean tam = new HoadonBean();
				String makh=rs.getString("makh");
				String mahoadon=rs.getString("mahoadon");
				Date ngaymua = rs.getDate("ngaymua");
				String hoten = rs.getString("hoten");
				tam.setHoten(hoten);
				tam.setMahoadon(mahoadon);
				tam.setMakh(makh);
				tam.setNgaymua(ngaymua);
				tam.setDamua(rs.getBoolean("damua"));
				tam.setDanhsachCT(HoaDonDao.getCTHD(makh, mahoadon));
				dsHoadon.add(tam);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHoadon;
	}
}
