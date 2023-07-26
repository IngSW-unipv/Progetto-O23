package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import Model.User;

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
                 rs.close();
                 stmt.close();
                 return ID_CLIENTE;
             } else {
            	 System.out.println(1);
            	 rs.close();
                 stmt.close();
                 return 51;
             }
    	 }
  }
  //OTTIENI UN PARAMETRO STRINGA DI USER DATA IL SUO USERNAME e Password
    	 
    public String OttieniParametroUserString(String par1,String user,String password ) throws SQLException {
    	    	
    	    	DBConnessione d =new DBConnessione();
    	    	conn=d.connessione(conn);
    	    	String sql = "SELECT "+par1+" FROM user WHERE  USERNAME = ? and PSW = ? ";
    	    	String ris=null;
    	    	
    	    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    	             stmt.setString(1, user);
    	             stmt.setString(2, password);
    	             ResultSet rs = stmt.executeQuery();
    	             if(rs.next()) {
    	            	 ris=rs.getString(par1);
    	            	 rs.close();
    	            	 stmt.close();
    	            	 
    	            	 return ris;
    	             }else {
    	            	 rs.close();
    	            	 stmt.close();
    	            	 return ris;
    	             }
    	           
    	         }
    	
    }
  //OTTIENI UN PARAMETRO DATA DI USER DATA IL SUO USERNAME e PASSWORD
    public java.sql.Date OttieniParametroUserDate(String string,String user,String password ) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT "+string+" FROM user WHERE  USERNAME = ? and PSW = ? ";
    	java.sql.Date ris = null;
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, user);
             stmt.setString(2, password);
             ResultSet rs = stmt.executeQuery();
             if(rs.next()) {
            	 ris=rs.getDate(string);
            	 rs.close();
            	 stmt.close();
            	 
            	 return ris;
             }else {
            	 rs.close();
            	 stmt.close();
            	 return ris;
             }
    	 }
         }

//METODO PER GENERARE UN ID PER LA REGISTRAZIONE DELL USER

    public int generaID() throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int id = -1;
        boolean uniqueId = false;
        while (!uniqueId) {
            // Generate a random integer between 100000000 and 999999999
            id = (int) (Math.random() * (999999999 - 100000000 + 1)) + 100000000;
            
            try {
                // Check if the generated ID already exists in the database
                String sql = "SELECT COUNT(*) FROM user WHERE ID_USER = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // If the ID doesn't exist, mark it as unique and exit the loop
                    uniqueId = true;
                }
            } catch (SQLException e) {
                System.out.println("Errore durante la generazione dell'ID: " + e.getMessage());
                throw e;
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        
        return id;
    }
    
        
        
            
         

    
    
//QUERY PER LA REGISTRAZIONE
    
    public void user_Register(String cf, String nome, String cognome, String dataNascita, String cell, String via,  String citta, int cap, String email, String username, String password) throws SQLException, NoSuchAlgorithmException {
    	
    	
    	 // Connessione al database
        DBConnessione d =new DBConnessione();
       	Connection con=null;
       	con=d.connessione(con);
        PreparedStatement stmt = null;
        
        //String hashedPassword=password.replaceAll(".", "*");
        

        java.sql.Date date=Date.valueOf(dataNascita);//conversione della data di nascita da stringa a java.sql.date

        try {
            // Inserimento dei dati nella tabella user
            String sql = "INSERT INTO user (ID_USER,cf, nome, cognome, data_nascita, cell, email, via, civico, citta, cap, username, psw, id_tipo) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, generaID());
            stmt.setString(2, cf);
            stmt.setString(3, nome);
            stmt.setString(4, cognome);
            stmt.setDate(5, date);
            stmt.setString(6, cell);
            stmt.setString(7, email);
            stmt.setString(8, via);
            stmt.setString(9, citta);
            stmt.setInt(10, cap); 
            stmt.setString(11, username);
            stmt.setString(12, password);
            stmt.setInt(13, 1); // id_tipo = 1
            
            
            stmt.executeUpdate();

            
                System.out.println("Registrazione completata con successo");
        
        } catch (SQLException e) {
            System.out.println("Errore durante la registrazione: " + e.getMessage());
        } 
        
       
    	
    }
    

}
