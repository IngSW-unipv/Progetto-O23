package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnessione {
	
		private String url = "jdbc:mysql://localhost:3306/hotel";
	    private String user = "root";
	    private String password = "Biuss90!";
	    private String driver="com.mysql.cj.jdbc.Driver";
	
	
	    public Connection connessione(Connection con) {
	    	
	    	
	    	try {
	    		Class.forName(driver);
	    		con = DriverManager.getConnection(url, user, password);
	    		
	    		System.out.println("connesione avvenuta");
	    	
	    		
	    } catch (ClassNotFoundException e) {
				Logger.getLogger(DBConnessione.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
				Logger.getLogger(DBConnessione.class.getName()).log(Level.SEVERE,null,e);
			}
	        
	    	return con;

	    }
	    
	
}
