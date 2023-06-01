package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utente.User;

public class Gestione_Dao {
    private Connection conn;

    public Gestione_Dao() {
        
    }
    
    public int Ottieni_User(String user) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT ID_USER FROM user WHERE NOME = ?";
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, user);
             ResultSet rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int ID_CLIENTE = rs.getInt("ID_USER");
                 System.out.println(ID_CLIENTE);
                 return ID_CLIENTE;
             } else {
            	 System.out.println(1);
                 return 51;
             }
    	 }

           
         }
  //OTTIENI UN PARAMETRO DI DATA UNA TABELLA PER UNA STRINGA
    	 
    	public String OttieniParametro(String tabella,String parametro) throws SQLException {
    	    	
    	    	DBConnessione d =new DBConnessione();
    	    	conn=d.connessione(conn);
    	    	String ris=null;
    	    	String sql = "SELECT ? FROM ? ";
    	    	
    	    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    	             stmt.setString(1, tabella);
    	             stmt.setString(2, parametro);
    	             ResultSet rs = stmt.executeQuery();
    	             
    	             if (rs.next()) {
    	                 ris = rs.getString(parametro);
    	                 System.out.println(ris);
    	                 return ris;
    	             } else {
    	            	 
    	                 return ris;
    	             }

    	           
    	         }
    	
    	
    }

}
