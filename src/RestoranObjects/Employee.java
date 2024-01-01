package RestoranObjects;

public class Employee {
	private String ID, Nama, Cabang;
	public Employee(String ID, String Nama, String Cabang) {
		this.ID = ID;
		this.Nama = Nama;
		this.Cabang = Cabang;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getNama() {
		return Nama;
	}
	
	public void setNama(String Nama) {
		this.Nama = Nama;
	}
	
	public String getCabang() {
		return Cabang;
	}
	
	public void setCabang(String Cabang) {
		this.Cabang = Cabang;
	}
	
	
}
