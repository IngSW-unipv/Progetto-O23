package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
  //OTTIENI UN PARAMETRO DELLA CITTA DATO IL SUO NOME
    public int OttieniParametoCitta(String string,String nomeCitta) throws SQLException {
    	    	
    	    DBConnessione d =new DBConnessione();
    	    conn=d.connessione(conn);
    	    String sql = "SELECT "+string+" FROM citta WHERE NOME_C = ?";
    	     int ris = 0;
    	    	
    	    	try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    	    		stmt.setString(1, nomeCitta);
    	           
    	             ResultSet rs = stmt.executeQuery();
    	             if(rs.next()) {
    	            	 ris=rs.getInt(string);
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
    
    public int Id_Generator() throws SQLException {
    	
    	ArrayList<Integer> IdList=new ArrayList<>();
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	int id=0;
    	String sql = "select ID_USER\r\n"
    			+ "from user ";
    	
    	try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
          //qui prendo gli id e li salvo nell array list 
            while (rs.next()) {
            	id = rs.getInt("ID_USER");
            	IdList.add(id);
				
			}
            
            stmt.close();
       	 	rs.close();
            conn.close();
    
            }
    	//prendo l'ultimo valore della lista e gli aggiungo 1 per ottenere un nuovo id che non esiste
    	int ultimo_id=IdList.get(IdList.size()-1);
    	//System.out.println(IdList);
    	
         return ultimo_id+1;  
    
    	
             
    }
//QUERY PER LA REGISTRAZIONE
    
    public void user_Register(String cf, String nome, String cognome, String dataNascita, String cell, String email, String citta, String username, String password) throws SQLException, NoSuchAlgorithmException {
    	
    	
    	 // Connessione al database
        DBConnessione d =new DBConnessione();
       	Connection con=null;
       	con=d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Hashing della password
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        		byte[] digest = md.digest();
        		String hashedPassword = String.format("%064x", new java.math.BigInteger(1, digest));
        
        
        java.sql.Date date=Date.valueOf(dataNascita);//conversione della data di nascita da stringa a java.sql.date

        try {
            // Inserimento dei dati nella tabella user
            String sql = "INSERT INTO user (ID_USER,cf, nome, cognome, data_nascita, cell, email,ID_CITTA, ID_PROV, ID_NAZ, id_tipo, username, psw) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Id_Generator());
            stmt.setString(2, cf);
            stmt.setString(3, nome);
            stmt.setString(4, cognome);
            stmt.setDate(5, date);
            stmt.setString(6, cell);
            stmt.setString(7, email);
            stmt.setInt(8,OttieniParametoCitta("ID_CITTA",citta));
            stmt.setInt(9, OttieniParametoCitta("ID_PROV",citta));
            stmt.setInt(10, OttieniParametoCitta("ID_NAZ",citta));
            stmt.setInt(11, 1); // id_tipo = 1
            stmt.setString(12, username);
            stmt.setString(13, hashedPassword);
            
            stmt.executeUpdate();

            // Ottieni l'ID_USER generato automaticamente
            if (rs.next()) {
                System.out.println("Registrazione completata con successo");
            } else {
                System.out.println("Errore: ID_USER non generato automaticamente");
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la registrazione: " + e.getMessage());
        } 
        
       
    	
    }
    
 // Verifica se un codice fiscale è già presente nel database
    public boolean verificaCF(String cf) throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean presente = false;

        try {
            String sql = "SELECT * FROM user WHERE cf = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cf);
            rs = stmt.executeQuery();

            if (rs.next()) {
                presente = true;
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la verifica del CF: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return presente;
    }

    // Verifica se uno username è già presente nel database
    public boolean verificaUsername(String username) throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean presente = false;

        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                presente = true;
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la verifica dello username: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return presente;
    }

    // Verifica se una email è già presente nel database
    public boolean verificaEmail(String email) throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean presente = false;

        try {
            String sql = "SELECT * FROM user WHERE email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                presente = true;
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la verifica dell'email: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return presente;
    }    
    

}
