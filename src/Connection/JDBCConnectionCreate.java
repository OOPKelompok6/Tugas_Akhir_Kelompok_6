package Connection;

import java.sql.*;

public class JDBCConnectionCreate {
	private static final String URL = "jdbc:mysql://localhost:3306/RestoManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    Connection Conn = null;
    
    //Getting Connection to database server 
    //within its own method as to minimize the scope inside the other 
    //methods for ensuring proper
    //closing of resources
    public static Connection getConnection() throws SQLException {
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
    
    //Create Table Menu Tipe Cabang Satu
    public void CreateTableMenuCabangSatu(String Cabang) {
    	String Query = "CREATE TABLE Menu_" + Cabang + "(MenuID CHAR(5) PRIMARY KEY, NamaMenu VARCHAR(50), "
    			+ "Harga DOUBLE, Narasi VARCHAR(100), Tipe VARCHAR(20), HasBeenOrdered INT)";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
    
    //Create Table Menu Tipe Cabang Dua
    public void CreateTableMenuCabangDua(String Cabang) {
    	String Query = "CREATE TABLE Menu_" + Cabang + "(MenuID CHAR(5) PRIMARY KEY, NamaMenu VARCHAR(50), "
    			+ "Harga DOUBLE, Narasi VARCHAR(100), Lokasi VARCHAR(50), Tipe VARCHAR(20), HasBeenOrdered INT)";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
    
    //Create Table MsPesanan
    public void CreateTablePesanan() {
    	String Query = "CREATE TABLE MsPesanan(OrderID CHAR(5) PRIMARY KEY, "
    			+ "EmployeeID CHAR(5), NamaPemesan VARCHAR(50), LokasiPemesan VARCHAR(30), JumlahMeja INT, StatusPesanan VARCHAR(30), "
    			+ "FOREIGN KEY (EmployeeID) REFERENCES MsEmployee(EmployeeID))";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
    
    //Create Table Meja
    public void CreateTableMeja() {
    	String Query = "CREATE TABLE MsMeja(MejaID CHAR(5) PRIMARY KEY, OrderID CHAR(5), TotalPesanan INT, KapasitasMeja INT, "
    			+ "OrangPerMeja INT, FOREIGN KEY (OrderID) REFERENCES MsPesanan(OrderID))";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
    
    //Create Table PesananDetail
    public void CreateTablePesananDetails(String Cabang) {
    	String Query = "CREATE TABLE PesananDetail" + Cabang + "(OrderID CHAR(5), MejaID CHAR(5), "
    			+ "MenuID CHAR(5), FOREIGN KEY (OrderID) REFERENCES MsMeja(OrderID), "
    			+ "FOREIGN KEY (MejaID) REFERENCES MsMeja(MejaID), "
    			+ "FOREIGN KEY (MenuID) REFERENCES Menu_" + Cabang + "(MenuID))";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
    
    //Create table employee yang memiliki ID, Nama, dan cabang resto
    public void CreateTableEmployee() {
    	String Query = "CREATE TABLE MsEmployee(EmployeeID CHAR(5) PRIMARY KEY, EmployeeName VARCHAR(50), Cabang VARCHAR(20))";
    	Statement CreateStatement = null;
    	
    	try {
    		Conn = getConnection();
    		CreateStatement = Conn.createStatement();
        	CreateStatement.executeUpdate(Query);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		CloseConnection(Conn);
    	}
    }
}
