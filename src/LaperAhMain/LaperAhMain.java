package LaperAhMain;

import java.util.ArrayList;
import java.util.Scanner;
import Connection.*;
import RestoranObjects.*;

public class LaperAhMain {

	public static void main(String[] args) {
		boolean WorldCondition = true, PreCondition = true;
		Scanner MainScan = new Scanner(System.in);
		
		while(WorldCondition) {
			if(PreCondition) {
				TablesInitialization();
				EmployeesInitialization();
				PreCondition = false;
			}
			
			System.out.printf("Sistem Management Restoran\n==============\n1. Tambah Employee\n2. Tambah Pesanan\n3. Tambah Menu\n4. Update Menu\n5. Delete Menu\n6. Tambah Makanan Pesanan\n7. Finalized Order\n8. Exit\nChoose: ");
			int MenuSelect = MainScan.nextInt(); MainScan.nextLine();
			
			if(MenuSelect == 1) {
				JDBCConnection conn = new JDBCConnection();
				String []EmployeeDatas = InsertEmployeeMain(MainScan);	
				conn.InsertEmployeeData(EmployeeDatas[0], EmployeeDatas[1], EmployeeDatas[2]);
			}
			else if(MenuSelect == 2) {
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				
				if(CurrResto != null) {
					System.out.printf("Apakah mau melakukan pesanan makanan[y|n]: ");
					String Option = MainScan.nextLine();
					
					if(Option.equalsIgnoreCase("n")) {
						CurrResto.TambahPesanan(CurrEmployee, MainScan);
					}
					else if(Option.equalsIgnoreCase("y")) {
						String CurrOrderID = CurrResto.TambahPesanan(CurrEmployee, MainScan);
						CurrResto.TambahMakananMeja(CurrOrderID, MainScan);
					}
				}
				else {
					System.out.println("Employee Data not Found!");
				}
			}
			else if(MenuSelect == 3) {
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				
				if(CurrResto == null) {
					System.out.println("Employee Tidak ditemukan!");
				}
				else {
					CurrResto.tambahMenu(CurrEmployee, MainScan);
				}
			}
			else if(MenuSelect == 4) {
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				
				if(CurrResto == null) {
					System.out.println("Employee Tidak ditemukan!");
				}
				else {
					CurrResto.UpdateMenu(CurrEmployee, MainScan);
				}
			}
			else if(MenuSelect == 5) {
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				
				if(CurrResto == null) {
					System.out.println("Employee Tidak ditemukan!");
				}
				else {
					CurrResto.DeleteMenu(CurrEmployee, MainScan);
				}
			}
			else if(MenuSelect == 6) {
				JDBCConnection conn = new JDBCConnection();
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				
				ArrayList <Pesanan> PesananCabang = null;
				PesananCabang = conn.RetrievePesanan(CurrResto.getCabang());
				if(PesananCabang != null) {
					
					System.out.println("| OrderID | EmployeeID | Nama Pemesan | Lokasi Pemesan | Jumlah Meja | Status Pesanan |");
					for(int i = 0; i < PesananCabang.size(); i++) {
						System.out.printf("| %s | %s | %s | %s |%d | %s |\n", PesananCabang.get(i).getOrderID(), PesananCabang.get(i).getEmployeeID(), PesananCabang.get(i).getNamaPemesan(), PesananCabang.get(i).getLokasiPemesan(), PesananCabang.get(i).getJumlahMeja(), PesananCabang.get(i).getStatusPesanan());
					}
					
					boolean Cond = true;
					Integer j = 0;
					String OrderID = null;
					while(Cond) {
						j = 0;
						System.out.printf("Input Order ID yang terdaftar: ");
						OrderID = MainScan.nextLine();
						for(j = 0; j <= PesananCabang.size(); j++) {
							if(j == PesananCabang.size()) {
								System.out.println("Tidak ada OrderID yang terdaftar dari cabang restoran tersebut!");
			        			break;
							}
							
							if(OrderID.equals(PesananCabang.get(j).getOrderID())) {
								Cond = false;
								break;
							}
						}
					}
					
					if(OrderID != null) {
						CurrResto.TambahMakananMeja(OrderID, MainScan);
					}
				}
				else {
					System.out.println("Tidak ada order pada cabang ini");
				}
				
			}
			else if(MenuSelect == 7) {
				Employee CurrEmployee = EmployeeRoutineValidation(MainScan);
				Restoran CurrResto = ValidateEmployee(CurrEmployee);
				CurrResto.FinalizedPesanan(CurrEmployee, MainScan);
			}
			else if(MenuSelect == 8) {
				WorldCondition = false;
			}
		}

	}
	
	public static Employee EmployeeRoutineValidation(Scanner MainScan) {
		System.out.printf("Masukan ID Employee: ");
		String ID = MainScan.nextLine();
		
		return new Employee(ID, null, null);
	}
	
	public static void TablesInitialization() {
		JDBCConnectionCreate conn = new JDBCConnectionCreate();
		
		if(conn.DoesTableExist("MsEmployee")) {
			return;
		}
		conn.CreateTableMenuCabangSatu("Jakarta");
		conn.CreateTableMenuCabangSatu("Bandung");
		conn.CreateTableMenuCabangSatu("Bali");
		conn.CreateTableMenuCabangDua("Surabaya");
		conn.CreateTableMenuCabangDua("Samarinda");
		conn.CreateTableMenuCabangDua("Padang");
		conn.CreateTableEmployee();
		conn.CreateTablePesanan();
		conn.CreateTableMeja();
		conn.CreateTablePesananDetails("Jakarta");
		conn.CreateTablePesananDetails("Bandung");
		conn.CreateTablePesananDetails("Bali");
		conn.CreateTablePesananDetails("Surabaya");
		conn.CreateTablePesananDetails("Samarinda");
		conn.CreateTablePesananDetails("Padang");
	}
	
	public static void EmployeesInitialization() {
		JDBCConnection conn = new JDBCConnection();
		
		Scanner InitScan = new Scanner(System.in);
		System.out.printf("Add New Employees: ");
		int Total = InitScan.nextInt(); InitScan.nextLine();
		
		for(int i = 0; i < Total; i++) {
			String []EmployeeDatas = InsertEmployeeMain(InitScan);	
			conn.InsertEmployeeData(EmployeeDatas[0], EmployeeDatas[1], EmployeeDatas[2]);
		}
		
		System.out.printf("\n\n");;
	}

	public static String[] InsertEmployeeMain(Scanner InitScan) {
		String []EmployeeDatas = new String[3];
		
		System.out.printf("ID [Max Length 5]: "); 
		EmployeeDatas[0] = InitScan.nextLine();
		System.out.printf("Nama [Max Length 50]: "); 
		EmployeeDatas[1] = InitScan.nextLine();
		System.out.printf("Cabang [Max Length 20]: "); 
		EmployeeDatas[2] = InitScan.nextLine();
		
		return EmployeeDatas;
	}

	//Pengecekan employee, validasi ulang dan me-return restoran yang sesuai
	public static Restoran ValidateEmployee(Employee employee) {
		JDBCConnection TempConn = new JDBCConnection();
		String []Condition = {"EmployeeID", employee.getID()};
		
		ArrayList<Employee> Temp = TempConn.GetEmployeeData(Condition);
		
		if(Temp.size() > 0) {
			employee.setNama(Temp.get(0).getNama());
			employee.setCabang(Temp.get(0).getCabang());
			return new Restoran(Temp.get(0).getCabang());
		}
		return null;
	}
}
