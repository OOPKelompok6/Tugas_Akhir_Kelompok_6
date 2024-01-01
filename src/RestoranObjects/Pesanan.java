package RestoranObjects;

public class Pesanan {
	private String OrderID, EmployeeID, NamaPemesan, LokasiPemesan, StatusPesanan;
	private Integer JumlahMeja;
	
	public Pesanan(String OrderID, String EmployeeID, String NamaPemesan, String LokasiPemesan, Integer JumlahMeja, String StatusPesanan) {
		this.OrderID = OrderID;
		this.EmployeeID = EmployeeID;
		this.NamaPemesan = NamaPemesan;
		this.LokasiPemesan = LokasiPemesan;
		this.JumlahMeja = JumlahMeja;
		this.StatusPesanan = StatusPesanan;
	}

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	public String getNamaPemesan() {
		return NamaPemesan;
	}

	public void setNamaPemesan(String namaPemesan) {
		NamaPemesan = namaPemesan;
	}

	public String getLokasiPemesan() {
		return LokasiPemesan;
	}

	public void setLokasiPemesan(String lokasiPemesan) {
		LokasiPemesan = lokasiPemesan;
	}

	public String getStatusPesanan() {
		return StatusPesanan;
	}

	public void setStatusPesanan(String statusPesanan) {
		StatusPesanan = statusPesanan;
	}

	public Integer getJumlahMeja() {
		return JumlahMeja;
	}

	public void setJumlahMeja(Integer jumlahMeja) {
		JumlahMeja = jumlahMeja;
	}
}
