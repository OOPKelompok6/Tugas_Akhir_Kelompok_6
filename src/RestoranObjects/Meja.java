package RestoranObjects;

public class Meja {
	private String OrderID;
	private String MejaID;
	private Integer TotalPesanan, KapasitasMeja, OrangPerMeja;
	
	public Meja(String OrderID, String MejaID, Integer TotalPesanan, Integer KapasitasMeja, Integer OrangPerMeja) {
		this.OrderID = OrderID;
		this.MejaID = MejaID;
		this.TotalPesanan = TotalPesanan;
		this.KapasitasMeja = KapasitasMeja;
		this.OrangPerMeja = OrangPerMeja;
	}
	
	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getMejaID() {
		return MejaID;
	}

	public void setMejaID(String mejaID) {
		MejaID = mejaID;
	}

	public Integer getTotalPesanan() {
		return TotalPesanan;
	}

	public void setTotalPesanan(Integer totalPesanan) {
		TotalPesanan = totalPesanan;
	}

	public Integer getKapasitasMeja() {
		return KapasitasMeja;
	}

	public void setKapasitasMeja(Integer kapasitasMeja) {
		KapasitasMeja = kapasitasMeja;
	}

	public Integer getOrangPerMeja() {
		return OrangPerMeja;
	}

	public void setOrangPerMeja(Integer orangPerMeja) {
		OrangPerMeja = orangPerMeja;
	}
}
