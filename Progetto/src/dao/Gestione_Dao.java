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

import javax.swing.JOptionPane;

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
    
    public void user_Register(String cf, String nome, String cognome, String dataNascita, String cell, String via,  String citta, String provincia, int cap, String email, String username, String password) throws SQLException, NoSuchAlgorithmException {
    	
    	
    	 // Connessione al database
        DBConnessione d =new DBConnessione();
       	Connection con=null;
       	con=d.connessione(con);
        PreparedStatement stmt = null;
        
        //String hashedPassword=password.replaceAll(".", "*");
        

        java.sql.Date date=Date.valueOf(dataNascita);//conversione della data di nascita da stringa a java.sql.date

        try {
            // Inserimento dei dati nella tabella user
            String sql = "INSERT INTO user (ID_USER,cf, nome, cognome, data_nascita, cell, email, via, citta, provincia, cap, username, psw, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setString(10, provincia);
            stmt.setInt(11, cap); 
            stmt.setString(12, username);
            stmt.setString(13, password);
            stmt.setInt(14, 1); // id_tipo = 1
            
            
            stmt.executeUpdate();

            
                System.out.println("Registrazione completata con successo");
        
        } catch (SQLException e) {
            System.out.println("Errore durante la registrazione: " + e.getMessage());
        } 
    }
    
    public void modificaDati(User user, String attributo, String nuovoValore) throws SQLException {
        if (!login(null, null)) {
             System.out.println("Devi effettuare il login per modificare i tuoi dati");
             return;
        }

          DBConnessione d = new DBConnessione();
          Connection con=null;
          con=d.connessione(con);
          String sql = "UPDATE user SET " + attributo + "=? WHERE username=? AND psw=?";

          try (PreparedStatement stmt = con.prepareStatement(sql)) {
               stmt.setString(1, nuovoValore);
               stmt.setString(2, user.getUsername());
               stmt.setString(3, user.getPassword());
               int result = stmt.executeUpdate();
               if (result == 1) {
                   switch (attributo) {
                       case "cf":
                           user.setCf(nuovoValore);
                           break;
                       case "nome":
                    	   user.setNome(nuovoValore);
                           break;
                       case "cognome":
                    	   user.setCognome(nuovoValore);
                           break;
                       case "data_nascita":
                           user.setDataDiNascita(java.sql.Date.valueOf(nuovoValore));
                           break;
                       case "cell":
                    	   user.setNumTelefono(nuovoValore);
                           break;
                       case "via":
                    	   user.setVia(nuovoValore);
                           break;
                       case "città":
                    	   user.setCittà(nuovoValore);
                           break;
                       case "provincia":
                    	   user.setProvincia(nuovoValore);
                           break;    
                       case "cap":
                    	   user.setCAP(Integer.parseInt(nuovoValore));
                           break;
                       case "email":
                    	   user.setEmail(nuovoValore);
                           break;
                       case "username":
                    	   user.setUsername(nuovoValore);
                           break;
                       case "psw":
                    	   user.setPassword(nuovoValore);
                           break;
                       default:
                           System.out.println("Attributo non valido");
                           return;
                   }
                   System.out.println("Modifica effettuata con successo");
                              
                   
               } else {
                   System.out.println("Errore durante la modifica dei dati");
               }
           }
   }
    
    public boolean login(String username, String password) throws SQLException {
        Connection conn = null;
        DBConnessione d =new DBConnessione();
       	conn=d.connessione(conn);        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loggedIn = false;

        try {
            
            String sql = "SELECT username FROM user WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                loggedIn = true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        if(loggedIn) {
        	System.out.println("Login effettuato con successo");
        	
        } else {
        	System.out.println("Errore, username o passsoword errati");
        	
        }
        return loggedIn;
        
        
       
    }
    
    
    public String OttieniPsw(String cf,String user,String email) throws SQLException{
    	
    	DBConnessione d =new DBConnessione();
    	Connection con=null;
    	con=d.connessione(con);
    	String psw=null;
    	String sql =" SELECT PSW \r\n"
    			+"FROM USER \r\n"
    			+"WHERE USERNAME= ? and  CF= ? and EMAIL= ?";
    	 try (PreparedStatement stmt = con.prepareStatement(sql)) {
             stmt.setString(1, user);
             stmt.setString(2, cf);
             stmt.setString(3, email);
             ResultSet rs = stmt.executeQuery();
             if (rs.next()) {
            	 psw = rs.getString("PSW");
                 return psw;
             } else {
            	 System.out.println("impossibile trovare password hai sbagliato a inserire i dati");
            	 return psw;
             }
    	
    	
    	
    	 }
    }
    
    
    
   }
