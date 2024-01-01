package Menu;

public class SpecialLokalMenu extends Menu {
	private String Narasi;
	private String Lokasi;
	
	public SpecialLokalMenu(String MenuID, String NamaMenu, double Harga, String Narasi, String Lokasi, String Tipe, Integer HasBeenOrdered) {
		super(MenuID, NamaMenu, Harga, Tipe, HasBeenOrdered);
		this.Narasi = Narasi;
		this.Lokasi = Lokasi;
	}

	public String getLokasi() {
		return Lokasi;
	}

	public void setLokasi(String lokasi) {
		Lokasi = lokasi;
	}

	public String getNarasi() {
		return Narasi;
	}

	public void setNarasi(String narasi) {
		Narasi = narasi;
	}
}
