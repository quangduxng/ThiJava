package BEAN;

import java.sql.Date;
import java.util.ArrayList;

public class HoadonBean {
	private String mahoadon;
	private Date ngaymua;
	private String makh;
	private boolean damua;
	private String hoten;
	private String tensp;
	private ArrayList<ChitiethoadonBean> danhsachCT ;
	
	
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public ArrayList<ChitiethoadonBean> getDanhsachCT() {
		return danhsachCT;
	}
	public void setDanhsachCT(ArrayList<ChitiethoadonBean> danhsachCT) {
		this.danhsachCT = danhsachCT;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
}
