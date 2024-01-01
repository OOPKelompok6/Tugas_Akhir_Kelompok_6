package Menu;

public class SpecialMenu extends Menu {
	private String Narasi;
	
	public SpecialMenu(String MenuID, String NamaMenu, double Harga, String Narasi, String Tipe, Integer HasBeenOrdered) {
		super(MenuID, NamaMenu, Harga, Tipe, HasBeenOrdered);
		this.Narasi = Narasi;
	}

	public String getNarasi() {
		return Narasi;
	}

	public void setNarasi(String narasi) {
		Narasi = narasi;
	}
}
