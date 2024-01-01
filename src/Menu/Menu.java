package Menu;

public class Menu {
	private String MenuID;
	private String NamaMenu;
	private double Harga;
	private Integer HasBeenOrdered;
	private String Tipe;
	
	public Menu(String MenuID, String NamaMenu, double Harga, String Tipe, Integer HasBeenOrdered) {
		this.MenuID = MenuID;
		this.NamaMenu = NamaMenu;
		this.Harga = Harga;
		this.Tipe = Tipe;
		this.HasBeenOrdered = HasBeenOrdered;
	}

	public String getMenuID() {
		return MenuID;
	}

	public void setMenuID(String menuID) {
		MenuID = menuID;
	}

	public String getNamaMenu() {
		return NamaMenu;
	}

	public void setNamaMenu(String namaMenu) {
		NamaMenu = namaMenu;
	}

	public double getHarga() {
		return Harga;
	}

	public void setHarga(double harga) {
		Harga = harga;
	}

	public Integer getHasBeenOrdered() {
		return HasBeenOrdered;
	}

	public void setHasBeenOrdered(Integer hasBeenOrdered) {
		HasBeenOrdered = hasBeenOrdered;
	}

	public String getTipe() {
		return Tipe;
	}

	public void setTipe(String tipe) {
		Tipe = tipe;
	}
}
