package Connection;

import java.sql.*;
import java.util.ArrayList;

import Menu.*;
import RestoranObjects.*;

public class JDBCConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/RestoManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    Connection Conn = null;
    
    //Getting Connection to database server 
    //within its own method as to minimize the scope inside the other 
    //methods for ensuring proper
    //closing of resources
    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    //Exit The Connection
    public static void CloseConnection(Connection Conn) {
    	if(Conn != null) {
    		try {
    			Conn.close();
    		}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    //Check if table Exist or not
    public boolean DoesTableExist(String TableName) {
    	boolean Condition = false;
    	
    	try {
    		Conn = getConnection();
    		DatabaseMetaData metaData = Conn.getMetaData();
    	    ResultSet resultSet = metaData.getTables(null, null, TableName, null);   
    	    Condition = resultSet.next();
    	    resultSet.close();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
        }
    	
    	return Condition;
    }
    
    //Insert Data to Special Menus
    public void InsertMenuCabangSatu(String Cabang, String MenuID, String NamaMenu, Double Harga, String Narasi, String Tipe, Integer HasBeenOrdered) {
    	try {
    		String Query = "INSERT INTO Menu_" + Cabang + " (MenuID, NamaMenu, Harga, Narasi, Tipe, HasBeenOrdered) VALUES (?, ?, ?, ?, ?, ?)";
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
    		CreateStatement.setString(1, MenuID);
    		CreateStatement.setString(2, NamaMenu);
    		CreateStatement.setString(3, Harga.toString());
    		CreateStatement.setString(4, Narasi);
    		CreateStatement.setString(5, Tipe);
    		CreateStatement.setString(6, HasBeenOrdered.toString());
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    //Insert Data to Special Local Menus
    public void InsertMenuCabangDua(String Cabang, String MenuID, String NamaMenu, Double Harga, String Narasi, String Lokasi, String Tipe, Integer HasBeenOrdered) {
    	try {
    		String Query = "INSERT INTO Menu_" + Cabang + " (MenuID, NamaMenu, Harga, Narasi, Lokasi, Tipe, HasBeenOrdered) VALUES (?, ?, ?, ?, ?, ?, ?)";
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
    		CreateStatement.setString(1, MenuID);
    		CreateStatement.setString(2, NamaMenu);
    		CreateStatement.setString(3, Harga.toString());
    		CreateStatement.setString(4, Narasi);
    		CreateStatement.setString(5, Lokasi);
    		CreateStatement.setString(6, Tipe);
    		CreateStatement.setString(7, HasBeenOrdered.toString());
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    //Update Data to Menus
    public void UpdateMenus(String Cabang, String MenuID, String Condition, String NewValue) {
    	try {
    		Conn = getConnection();
    		String Query = null;
    		
    		if(Condition.equals("NamaMenu")) {
    			Query = "UPDATE Menu_" + Cabang + " SET " + Condition + " = " + "'".concat(NewValue).concat("'") + " WHERE MenuID LIKE " + "'".concat(MenuID).concat("'");
    		}
    		else {
    			Query = "UPDATE Menu_" + Cabang + " SET " + Condition + " = " + NewValue + " WHERE MenuID LIKE " + "'".concat(MenuID).concat("'");
    		}
    		
    		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    //Retrieve Data from Menus
    public ArrayList<SpecialMenu> RetrieveCabangSpecial(String Cabang, String MenuID) {
    	ArrayList<SpecialMenu> FetchedSpecialMenu = null;
    	
    	try {
    		Conn = getConnection();
        	
        	if(DoesTableExist("Menu_".concat(Cabang))) {
        		FetchedSpecialMenu = new ArrayList<SpecialMenu>();
        		PreparedStatement CreateStatement = null;
        		ResultSet ResultObject = null;
        		
        		if(MenuID == null) {
        			String Query = "SELECT * FROM Menu_" + Cabang;
        			CreateStatement = Conn.prepareStatement(Query);
   
        		}
        		else {
        			String Query = "SELECT * FROM Menu_" + Cabang + " WHERE MenuID LIKE ?";
        			CreateStatement = Conn.prepareStatement(Query);
        			CreateStatement.setString(1, MenuID);
        		}
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedSpecialMenu.add(new SpecialMenu(ResultObject.getString(1), ResultObject.getString(2), ResultObject.getDouble(3), ResultObject.getString(4), ResultObject.getString(5), ResultObject.getInt(6)));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedSpecialMenu;
    }
    
    public ArrayList<SpecialLokalMenu> RetrieveCabangSpecialLokal(String Cabang, String MenuID) {
    	ArrayList<SpecialLokalMenu> FetchedSpecialLokalMenu = null;
    	
    	try {
    		Conn = getConnection();
        	
        	if(DoesTableExist("Menu_".concat(Cabang))) {
        		FetchedSpecialLokalMenu = new ArrayList<SpecialLokalMenu>();
        		PreparedStatement CreateStatement = null;
        		ResultSet ResultObject = null;
        		
        		if(MenuID == null) {
        			String Query = "SELECT * FROM Menu_" + Cabang;
        			CreateStatement = Conn.prepareStatement(Query);
   
        		}
        		else {
        			String Query = "SELECT * FROM Menu_" + Cabang + " WHERE MenuID LIKE ?";
        			CreateStatement = Conn.prepareStatement(Query);
        			CreateStatement.setString(1, MenuID);
        		}
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedSpecialLokalMenu.add(new SpecialLokalMenu(ResultObject.getString(1), ResultObject.getString(2), ResultObject.getDouble(3), ResultObject.getString(4), ResultObject.getString(5), ResultObject.getString(6), ResultObject.getInt(7)));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedSpecialLokalMenu;
    }
    
    //Delete Data from Menus
    public void DeleteMenuCabangs(String Cabang, String MenuID) {
    	try {
    		String Query = "DELETE FROM Menu_" + Cabang + " WHERE MenuID = ?";
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
    		CreateStatement.setString(1, MenuID);
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    //Insert data to Employee table
    public void InsertEmployeeData(String ID, String Nama, String Cabang) {
    	try {
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement("INSERT INTO MsEmployee (EmployeeID, EmployeeName, Cabang) VALUES (?, ?, ?)");
    		CreateStatement.setString(1, ID);
    		CreateStatement.setString(2, Nama);
    		CreateStatement.setString(3, Cabang);
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
       
    //Get table employee return it as an arraylist based on where criteria
    public ArrayList<Employee> GetEmployeeData(String[] Condition) {
    	ArrayList<Employee> FetchedEmployee = null;
    	
    	try {
    		Conn = getConnection();
        	
        	if(DoesTableExist("MsEmployee")) {
        		FetchedEmployee = new ArrayList<Employee>();
        		PreparedStatement CreateStatement = null;
        		ResultSet ResultObject = null;
        		
        		if(Condition[0].equals("EmployeeID")) {
        			CreateStatement = Conn.prepareStatement("SELECT * FROM MsEmployee WHERE EmployeeID LIKE ?");
        			CreateStatement.setString(1, Condition[1]);
   
        		}
        		else if(Condition[0].equals("EmployeeName")) {
        			CreateStatement = Conn.prepareStatement("SELECT * FROM MsEmployee WHERE EmployeeName LIKE ?");
        			CreateStatement.setString(1, Condition[1]);
        		}
        		else if(Condition[0].equals("Cabang")) {
        			CreateStatement = Conn.prepareStatement("SELECT * FROM MsEmployee WHERE Cabang LIKE ?");
        			CreateStatement.setString(1, Condition[1]);
    			}
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedEmployee.add(new Employee(ResultObject.getString(1), ResultObject.getString(2), ResultObject.getString(3)));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedEmployee;
    }
    
    public void InsertPesanan(String OrderID, String EmployeeID, String NamaPemesan, String LokasiPemesan, Integer JumlahMeja, String StatusPesanan) {
    	try {
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement("INSERT INTO MsPesanan (OrderID, EmployeeID, NamaPemesan, LokasiPemesan, JumlahMeja, StatusPesanan) VALUES (?, ?, ?, ?, ?, ?)");
    		CreateStatement.setString(1, OrderID);
    		CreateStatement.setString(2, EmployeeID);
    		CreateStatement.setString(3, NamaPemesan);
    		CreateStatement.setString(4, LokasiPemesan);
    		CreateStatement.setString(5, JumlahMeja.toString());
    		CreateStatement.setString(6, StatusPesanan);
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void InsertMeja(String OrderID, String MejaID, Integer OrangPerMeja, Integer KapasitasMeja) {
    	try {
    		Conn = getConnection();
    		PreparedStatement CreateStatement = Conn.prepareStatement("INSERT INTO MsMeja (OrderID, MejaID, TotalPesanan, KapasitasMeja, OrangPerMeja) VALUES (?, ?, 0, ?, ?)");
    		CreateStatement.setString(1, OrderID);
    		CreateStatement.setString(2, MejaID);
    		CreateStatement.setString(3, KapasitasMeja.toString());
    		CreateStatement.setString(4, OrangPerMeja.toString());
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    public ArrayList <Meja> RetrieveMejaPesanan(String CurrOrderID) {
    	ArrayList<Meja> FetchedMejas = null;
    	
    	try {
    		Conn = getConnection();
        	
        	if(DoesTableExist("MsMeja")) {
        		FetchedMejas = new ArrayList<Meja>();
        		PreparedStatement CreateStatement = Conn.prepareStatement("SELECT * FROM MsMeja WHERE OrderID LIKE ?");
        		CreateStatement.setString(1, CurrOrderID);
        		ResultSet ResultObject = null;
        		
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedMejas.add(new Meja(ResultObject.getString(2), ResultObject.getString(1), ResultObject.getInt(3), ResultObject.getInt(4), ResultObject.getInt(5)));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedMejas;
    }

	public void TambahDetailPesanan(String OrderID, String MejaID, String MenuID, String NamaCabang) {
		try {
    		Conn = getConnection();
    		String Query = "INSERT INTO PesananDetail" + NamaCabang + " (OrderID, MejaID, MenuID) VALUES (?, ?, ?)";
    		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
    		CreateStatement.setString(1, OrderID);
    		CreateStatement.setString(2, MejaID);
    		CreateStatement.setString(3, MenuID);
    		CreateStatement.execute();
    		CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
    
	public void UpdatePesanan(String OrderID, String Status) {
	   try {
   			Conn = getConnection();
   			String Query = "UPDATE MsPesanan SET StatusPesanan = " + "'".concat(Status).concat("'") + " WHERE OrderID LIKE " + "'".concat(OrderID).concat("'");   		
   			PreparedStatement CreateStatement = Conn.prepareStatement(Query);
   			CreateStatement.execute();
   			CloseConnection(Conn);
   		}
   		catch(SQLException e) {
   			e.printStackTrace();
   		}
   }

	public void UpdateMejas(String MejaID, Integer CurrTotalPesanan) {
	   try {
  			Conn = getConnection();
  			String Query = "UPDATE MsMeja SET TotalPesanan = " + CurrTotalPesanan.toString() 
  			+ " WHERE MejaID LIKE " + "'".concat(MejaID).concat("'");  		
  			PreparedStatement CreateStatement = Conn.prepareStatement(Query);
  			CreateStatement.execute();
  			CloseConnection(Conn);
  		}
  		catch(SQLException e) {
  			e.printStackTrace();
  		}
   }

	public ArrayList <Pesanan> RetrievePesanan(String NamaCabang) {
		ArrayList<Pesanan> FetchedPesanan = null;
    	
    	try {
    		Conn = getConnection();
        	
        	if(DoesTableExist("MsPesanan")) {
        		FetchedPesanan = new ArrayList<Pesanan>();
        		String OrderWildCard = null;
        		if(NamaCabang.equals("Jakarta")) {
        			OrderWildCard = "JT___";
        		}
        		else if(NamaCabang.equals("Bandung")) {
        			OrderWildCard = "BD___";
        		}
        		else if(NamaCabang.equals("Bali")) {
        			OrderWildCard = "BL___";
        		}
        		else if(NamaCabang.equals("Surabaya")) {
        			OrderWildCard = "SB___";
        		}
        		else if(NamaCabang.equals("Padang")) {
        			OrderWildCard = "PD___";
        		}
        		else if(NamaCabang.equals("Samarinda")) {
        			OrderWildCard = "SM___";
        		}
        		
        		PreparedStatement CreateStatement = Conn.prepareStatement("SELECT * FROM MsPesanan WHERE OrderID LIKE ?");
        		CreateStatement.setString(1, OrderWildCard);
        		ResultSet ResultObject = null;
        		
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedPesanan.add(new Pesanan(ResultObject.getString(1), ResultObject.getString(2), ResultObject.getString(3), ResultObject.getString(4), ResultObject.getInt(5) ,ResultObject.getString(6)));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedPesanan;
	}

	public ArrayList <String> RetrievePesananDetailMenuID(String OrderID, String NamaCabang) {
		ArrayList<String> FetchedMenuID = null;
    	
    	try {
    		Conn = getConnection();
    		String TableName = "PesananDetail" + NamaCabang;
        	
        	if(DoesTableExist(TableName)) {
        		FetchedMenuID = new ArrayList<String>();
        		String Query = "SELECT * FROM " + TableName +" WHERE OrderID LIKE ?";
        		PreparedStatement CreateStatement = Conn.prepareStatement(Query);
        		CreateStatement.setString(1, OrderID);
        		ResultSet ResultObject = null;
        		
        		ResultObject = CreateStatement.executeQuery();
        		while(ResultObject.next()) {
        			FetchedMenuID.add(ResultObject.getString(3));
        		}
        		ResultObject.close();
        	}
        	CloseConnection(Conn);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    	return FetchedMenuID;
	}
}
