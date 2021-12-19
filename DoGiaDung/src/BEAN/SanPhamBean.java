package BEAN;

public class SanPhamBean {
	private String masp;
	private String tensp;
	private String anh;
	private Long gia;
	private Long soluong;
	private String maloai;
	private String mota;
	public Long tongtien() {
		return soluong*gia;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masach) {
		this.masp = masach;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	
}
