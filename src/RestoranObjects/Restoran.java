package RestoranObjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Connection.JDBCConnection;
import Menu.*;

public class Restoran {
	private String namaCabang;

    public Restoran(String namaCabang) {
    	this.namaCabang = namaCabang;
    }
    
    public void tambahMenu(Employee employee, Scanner MainScan) {
        if (employee.getCabang().equals(namaCabang)) {
        	JDBCConnection conn = new JDBCConnection();
        	
            if(namaCabang.equals("Bandung") || namaCabang.equals("Jakarta") || namaCabang.equals("Bali")) {
            	System.out.printf("Menu ID [Bandung (BDXXX) | Jakarta (JTXXX) | Bali (BLXXX) | (X) menyatakan angka]: ");
            	String MenuID = MainScan.nextLine();
            	System.out.printf("Nama Menu: ");
            	String NamaMenu = MainScan.nextLine();
            	System.out.printf("Harga Menu: ");
            	Double Harga = MainScan.nextDouble(); MainScan.nextLine();
            	System.out.printf("Narasi: ");
            	String Narasi = MainScan.nextLine();
            	System.out.printf("Tipe [Spesial | Biasa]: ");
            	String Tipe = MainScan.nextLine();
            	
            	conn.InsertMenuCabangSatu(namaCabang, MenuID, NamaMenu, Harga, Narasi, Tipe, 0);
            }
            else if(namaCabang.equals("Surabaya") || namaCabang.equals("Samarinda") || namaCabang.equals("Padang")) {
            	System.out.printf("Menu ID [Surabaya (SBXXX) | Padang (PDXXX) | Samarinda (SMXXX) | (X) menyatakan angka]: ");
            	String MenuID = MainScan.nextLine();
            	System.out.printf("Nama Menu: ");
            	String NamaMenu = MainScan.nextLine();
            	System.out.printf("Harga Menu: ");
            	Double Harga = MainScan.nextDouble(); MainScan.nextLine();
            	System.out.printf("Narasi: ");
            	String Narasi = MainScan.nextLine();
            	System.out.printf("Lokasi Asal: ");
            	String Lokasi = MainScan.nextLine();
            	System.out.printf("Tipe [Lokal Spesial | Biasa]: ");
            	String Tipe = MainScan.nextLine();
            	
            	conn.InsertMenuCabangDua(namaCabang, MenuID, NamaMenu, Harga, Narasi, Lokasi, Tipe, 0);
            }
        } 
        else {
            System.out.println("Anda tidak memiliki izin untuk menambah menu di cabang lain.");
        }
    }

    public void DeleteMenu(Employee employee, Scanner MainScan) {
    	JDBCConnection conn = new JDBCConnection();
    	ArrayList<SpecialLokalMenu> TempTwo = null;
    	ArrayList<SpecialMenu> Temp = null;
    	
    	if(namaCabang.equals("Bandung") || namaCabang.equals("Jakarta") || namaCabang.equals("Bali")) {
    		Temp = conn.RetrieveCabangSpecial(namaCabang, null);
    		
    		System.out.println("MenuID | Nama Menu | Harga | Narasi | Tipe | Telah Terorder |");
    		for(int i = 0; i < Temp.size(); i++) {
    			System.out.printf("%s | %s | %f | %s | %s | %d |\n", Temp.get(i).getMenuID(), Temp.get(i).getNamaMenu(), Temp.get(i).getHarga(), Temp.get(i).getNarasi(), Temp.get(i).getTipe(), Temp.get(i).getHasBeenOrdered());
    		}
    	}
    	else {
    		TempTwo = conn.RetrieveCabangSpecialLokal(namaCabang, null);
    		
    		System.out.println("MenuID | Nama Menu | Harga | Narasi | Lokasi | Tipe | Telah Terorder |");
    		for(int i = 0; i < TempTwo.size(); i++) {
    			System.out.printf("%s | %s | %f | %s | %s | %s | %d |\n", TempTwo.get(i).getMenuID(), TempTwo.get(i).getNamaMenu(), TempTwo.get(i).getHarga(), TempTwo.get(i).getNarasi(), TempTwo.get(i).getLokasi(), TempTwo.get(i).getTipe(), TempTwo.get(i).getHasBeenOrdered());
    		}
    	}
    	
    	System.out.printf("MenuID Pilihan: ");
    	String MenuID = MainScan.nextLine();
    	
    	if(Temp != null) {
    		for(int i = 0; i < Temp.size(); i++) {
    			if((Temp.get(i).getHasBeenOrdered() == 1) && (Temp.get(i).getMenuID().equals(MenuID))) {
    				System.out.println("Menu Pernah diorder tidak dapat dihapus!");
    				return;
    			}
    		}
    	}
    	else {
    		for(int i = 0; i < TempTwo.size(); i++) {
    			if((TempTwo.get(i).getHasBeenOrdered() == 1) && (TempTwo.get(i).getMenuID().equals(MenuID))) {
    				System.out.println("Menu Pernah diorder tidak dapat dihapus!");
    				return;
    			}
    		}
    	}
    	
    	conn.DeleteMenuCabangs(namaCabang, MenuID);
    }
    
    public void UpdateMenu(Employee employee, Scanner MainScan) {
    	JDBCConnection conn = new JDBCConnection();
    	ArrayList<SpecialMenu> Temp = null;
    	ArrayList<SpecialLokalMenu> TempTwo = null;
    	
    	if(namaCabang.equals("Bandung") || namaCabang.equals("Jakarta") || namaCabang.equals("Bali")) {
    		Temp = conn.RetrieveCabangSpecial(namaCabang, null);
    		
    		System.out.println("MenuID | Nama Menu | Harga | Narasi | Tipe | Telah Terorder |");
    		for(int i = 0; i < Temp.size(); i++) {
    			System.out.printf("%s | %s | %f | %s | %s | %d |\n", Temp.get(i).getMenuID(), Temp.get(i).getNamaMenu(), Temp.get(i).getHarga(), Temp.get(i).getNarasi(), Temp.get(i).getTipe(), Temp.get(i).getHasBeenOrdered());
    		}
    	}
    	else {
    		TempTwo = conn.RetrieveCabangSpecialLokal(namaCabang, null);
    		
    		System.out.println("MenuID | Nama Menu | Harga | Narasi | Lokasi | Tipe | Telah Terorder |");
    		for(int i = 0; i < TempTwo.size(); i++) {
    			System.out.printf("%s | %s | %f | %s | %s | %s | %d |\n", TempTwo.get(i).getMenuID(), TempTwo.get(i).getNamaMenu(), TempTwo.get(i).getHarga(), TempTwo.get(i).getNarasi(), TempTwo.get(i).getLokasi(), TempTwo.get(i).getTipe(), TempTwo.get(i).getHasBeenOrdered());
    		}
    	}
    	
    	System.out.printf("MenuID Pilihan: ");
    	String MenuID = MainScan.nextLine();
    	if(Temp != null) {
    		for(int i = 0; i < Temp.size(); i++) {
    			if((Temp.get(i).getHasBeenOrdered() == 1) && (Temp.get(i).getMenuID().equals(MenuID))) {
    				System.out.println("Menu Pernah diorder tidak dapat diupdate!");
    				return;
    			}
    		}
    	}
    	else {
    		for(int i = 0; i < TempTwo.size(); i++) {
    			if((TempTwo.get(i).getHasBeenOrdered() == 1) && (TempTwo.get(i).getMenuID().equals(MenuID))) {
    				System.out.println("Menu Pernah diorder tidak dapat diupdate!");
    				return;
    			}
    		}
    	}
    	
    	System.out.printf("Attribut yang diubah [NamaMenu | Harga | (Case Sensitive)]: ");
    	String Condition = MainScan.nextLine();
    	System.out.printf("Nilai Baru: ");
    	String NewValue = MainScan.nextLine();
    	
    	conn.UpdateMenus(namaCabang, MenuID, Condition, NewValue);
    }
    
    public String TambahPesanan(Employee employee, Scanner MainScan) {
    	JDBCConnection conn = new JDBCConnection();
    	String OrderID = GenerateOrderID(employee);
    	System.out.printf("Nama Pemesan: ");
    	String NamaPemesan = MainScan.nextLine();
    	System.out.printf("Lokasi Pemesan: ");
    	String Lokasi = MainScan.nextLine();
    	System.out.printf("Jumlah Meja: ");
    	Integer JumlahMeja = MainScan.nextInt(); MainScan.nextLine();
    	
    	conn.InsertPesanan(OrderID, employee.getID(), NamaPemesan, Lokasi, JumlahMeja, "in reserve");
    	
    	for(int i = 0; i < JumlahMeja; i++) {
    		System.out.printf("Tipe Meja [Romantic | General | Family]: ");
        	String TipeMeja = MainScan.nextLine();
        	System.out.printf("Orang per Meja: ");
        	Integer OrangPerMeja = MainScan.nextInt(); MainScan.nextLine();
        	String MejaID = null;
    		
        	if(TipeMeja.equals("Romantic")) {
        		MejaID = GenerateMejaID("Romantic");
        		conn.InsertMeja(OrderID, MejaID, OrangPerMeja, 2);
        	}
        	else if(TipeMeja.equals("General")) {
        		MejaID = GenerateMejaID("General");
        		conn.InsertMeja(OrderID, MejaID, OrangPerMeja, 4);
        	}
        	else if(TipeMeja.equals("Family")) {
        		MejaID = GenerateMejaID("Family");
        		conn.InsertMeja(OrderID, MejaID, OrangPerMeja, 10);
        	}
    	}
    	
    	return OrderID;
    }
    
    public void TambahMakananMeja(String CurrOrderID, Scanner MainScan) {
    	JDBCConnection conn = new JDBCConnection();
    	conn.UpdatePesanan(CurrOrderID, "in order");
    	ArrayList <Meja> MejaPesanan = conn.RetrieveMejaPesanan(CurrOrderID);
    	
    	System.out.printf("| OrderID | MejaID | Total Pesanan | Kapasitas Meja | Orang per Meja |\n");
    	for(int i = 0; i < MejaPesanan.size(); i++) {
    		System.out.printf("| %s | %s | %d | %d | %d |\n", MejaPesanan.get(i).getOrderID(), MejaPesanan.get(i).getMejaID(), MejaPesanan.get(i).getTotalPesanan(), MejaPesanan.get(i).getKapasitasMeja(), MejaPesanan.get(i).getOrangPerMeja());
    	}
    	
    	boolean Cond = true;
    	ArrayList<SpecialMenu> Temp = null;
    	ArrayList<SpecialLokalMenu> TempTwo = null;
    	while(Cond) {
    		System.out.println("Pilih meja yang akan ditambah menunya: ");
        	String MejaID = MainScan.nextLine();
        	
        	int i = 0;
        	for(i = 0; i <= MejaPesanan.size(); i++) {
        		if(i == MejaPesanan.size()) {
        			System.out.println("Tidak ada MejaID yang terdaftar dari OrderID tersebut!");
        			return;
        		}
        		
        		if(MejaPesanan.get(i).getMejaID().equals(MejaID)) {
        			break;
        		}
        	}
        	
        	System.out.printf("\nMenu yang tersedia\n==============\n");
        	if(namaCabang.equals("Bandung") || namaCabang.equals("Jakarta") || namaCabang.equals("Bali")) {
        		Temp = conn.RetrieveCabangSpecial(namaCabang, null);
        		
        		System.out.println("MenuID | Nama Menu | Harga | Narasi | Tipe | Telah Terorder |");
        		for(int j = 0; j < Temp.size(); j++) {
        			System.out.printf("%s | %s | %f | %s | %s | %d |\n", Temp.get(j).getMenuID(), Temp.get(j).getNamaMenu(), Temp.get(j).getHarga(), Temp.get(j).getNarasi(), Temp.get(j).getTipe(), Temp.get(j).getHasBeenOrdered());
        		}
        	}
        	else {
        		TempTwo = conn.RetrieveCabangSpecialLokal(namaCabang, null);
        		
        		System.out.println("MenuID | Nama Menu | Harga | Narasi | Lokasi | Tipe | Telah Terorder |");
        		for(int j = 0; j < TempTwo.size(); j++) {
        			System.out.printf("%s | %s | %f | %s | %s | %s | %d |\n", TempTwo.get(j).getMenuID(), TempTwo.get(j).getNamaMenu(), TempTwo.get(j).getHarga(), TempTwo.get(j).getNarasi(), TempTwo.get(j).getLokasi(), TempTwo.get(j).getTipe(), TempTwo.get(j).getHasBeenOrdered());
        		}
        	}
        	
        	Integer CurrTotalPesanan = MejaPesanan.get(i).getTotalPesanan();
        	Integer CurrKapasitasMeja = MejaPesanan.get(i).getKapasitasMeja();
        	
        	while(CurrTotalPesanan < CurrKapasitasMeja) {
        		System.out.printf("Pilih Menu ID yang diinginkan: ");
        		String MenuID = MainScan.nextLine();
        		boolean InnerCond = true;
        		
        		if(Temp != null) {
        			for(int k = 0; k < Temp.size(); k++) {
        				if(Temp.get(k).getMenuID().equals(MenuID)) {
        					InnerCond = false;
        					break;
        				}
        			}
        		}
        		else {
        			for(int k = 0; k < TempTwo.size(); k++) {
        				if(TempTwo.get(k).getMenuID().equals(MenuID)) {
        					InnerCond = false;
        					break;
        				}
        			}
        		}
        		
        		if(InnerCond) {
        			System.out.println("MenuID tidak terdaftar pada restoran!");
        			continue;
        		}
        		conn.TambahDetailPesanan(CurrOrderID, MejaID, MenuID, namaCabang);
        		conn.UpdateMenus(namaCabang, MenuID, "HasBeenOrdered", "1");
        		CurrTotalPesanan += 1;
        		
        		System.out.printf("Apakah selesai menambahkan menu pada meja [y | n]: ");
            	String CondOpt = MainScan.nextLine();
            	if(CondOpt.equalsIgnoreCase("y")) {
            		break;
            	}
        	}
        	
        	conn.UpdateMejas(MejaID, CurrTotalPesanan);
        	if(CurrKapasitasMeja >= CurrTotalPesanan) {
        		System.out.println("Pesanan Telah Memenuhi Kapasitas Meja!");
        		return;
        	}
        	
        	System.out.printf("Apakah selesai menambahkan menu pada order [y | n]: ");
        	String CondOpt = MainScan.nextLine();
        	if(CondOpt.equalsIgnoreCase("y")) {
        		Cond = false;
        	}
    	}
    }
    
    public void FinalizedPesanan(Employee employee, Scanner MainScan) {
    	JDBCConnection conn = new JDBCConnection();
    	ArrayList <Pesanan> PesananCabang = null;
		PesananCabang = conn.RetrievePesanan(namaCabang);
		if(PesananCabang != null) {
			System.out.println("| OrderID | EmployeeID | Nama Pemesan | Lokasi Pemesan | Jumlah Meja | Status Pesanan |");
			for(int i = 0; i < PesananCabang.size(); i++) {
				System.out.printf("| %s | %s | %s | %s |%d | %s |\n", PesananCabang.get(i).getOrderID(), PesananCabang.get(i).getEmployeeID(), PesananCabang.get(i).getNamaPemesan(), PesananCabang.get(i).getLokasiPemesan(), PesananCabang.get(i).getJumlahMeja(), PesananCabang.get(i).getStatusPesanan());
			}
			System.out.printf("Order ID Pemesanan: ");
			String OrderID = MainScan.nextLine();
			for(int i = 0; i <= PesananCabang.size(); i++) {
				if(i == PesananCabang.size()) {
					System.out.println("OrderID tidak ditemukan!");
					return;
				}
				
				if(PesananCabang.get(i).getOrderID().equals(OrderID)) {
					break;
				}
			}
			
			ArrayList <String> MenuIDArray = conn.RetrievePesananDetailMenuID(OrderID, namaCabang);
			ArrayList<SpecialMenu> Temp = null;
	    	ArrayList<SpecialLokalMenu> TempTwo = null;
	    	Double Total = 0.0;
			
	    	System.out.printf("\n\nTotal\n=========\n");
			if(namaCabang.equals("Bandung") || namaCabang.equals("Jakarta") || namaCabang.equals("Bali")) { 
				Temp = conn.RetrieveCabangSpecial(namaCabang, null);
				
				for(int j = 0; j < MenuIDArray.size(); j++) {
					for(int k = 0; k < Temp.size(); k++) {
						if(Temp.get(k).getMenuID().equals(MenuIDArray.get(j))) {
							System.out.println(Temp.get(k).getNamaMenu());
							Total += Temp.get(k).getHarga();
							break;
						}
					}
				}
			}
			else {
				TempTwo = conn.RetrieveCabangSpecialLokal(namaCabang, null);
				
				for(int j = 0; j < MenuIDArray.size(); j++) {
					for(int k = 0; k < TempTwo.size(); k++) {
						if(TempTwo.get(k).getMenuID().equals(MenuIDArray.get(j))) {
							System.out.println(TempTwo.get(k).getNamaMenu());
							Total += TempTwo.get(k).getHarga();
							break;
						}
					}
				}
			}
			System.out.printf("------------ +\n%f\n\n", Total);
			conn.UpdatePesanan(OrderID, "finalized");
			
		}
		else {
			System.out.println("Tidak ada order pada cabang ini");
		}
    }
    
    public String getCabang() {
    	return this.namaCabang;
    }
    
    public static String GenerateOrderID(Employee employee) {
    	Integer Nums = 0;
    	Random Rand = new Random();
    	for(int i = 0; i < 3; i++) {
    		int Temp = 0;
    		while(Temp == 0) {
    			Temp = Rand.nextInt(10);
    		}
    		Nums = (Nums * 10) + Temp;
    	}
    	
    	if(employee.getCabang().equals("Jakarta")) {
    		return "JT".concat(Nums.toString());
    	}
    	else if(employee.getCabang().equals("Bandung")) {
    		return "BD".concat(Nums.toString());
    	}
    	else if(employee.getCabang().equals("Bali")) {
    		return "BL".concat(Nums.toString());
    	}
    	else if(employee.getCabang().equals("Surabaya")) {
    		return "SB".concat(Nums.toString());
    	}
    	else if(employee.getCabang().equals("Padang")) {
    		return "PD".concat(Nums.toString());
    	}
    	else if(employee.getCabang().equals("Samarinda")){
    		return "SM".concat(Nums.toString());
    	}
    	
    	return null;
    }

    public static String GenerateMejaID(String TipeMeja) {
    	Integer Nums = 0;
    	Random Rand = new Random();
    	for(int i = 0; i < 3; i++) {
    		int Temp = 0;
    		while(Temp == 0) {
    			Temp = Rand.nextInt(10);
    		}
    		Nums = (Nums * 10) + Temp;
    	}
    	
    	if(TipeMeja.equals("Romantic")) {
    		return "RO".concat(Nums.toString());
    	}
    	else if(TipeMeja.equals("General")) {
    		return "GE".concat(Nums.toString());
    	}
    	else if(TipeMeja.equals("Family")) {
    		return "FA".concat(Nums.toString());
    	}
    	
    	return null;
    }
}
