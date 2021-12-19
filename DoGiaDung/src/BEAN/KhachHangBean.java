package BEAN;

public class KhachHangBean {
	String makh;
	String tenkh;
	String diachi;
	String sdt;
	String email;
	String tendangnhap;
	String pass;
	boolean quyen;
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
	public KhachHangBean(String makh, String tenkh, String diachi, String sdt, String email, String tendangnhap,
			String pass, boolean quyen) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.tendangnhap = tendangnhap;
		this.pass = pass;
		this.quyen = quyen;
	}
	
	
	
	
}
