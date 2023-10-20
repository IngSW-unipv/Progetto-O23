package dao;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Model.User;
//import View.Account;

public class Gestione_Dao {
    private Connection conn;

    public Gestione_Dao() {
        
    }
    
    public int Ottieni_User(String username) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT ID_USER FROM user WHERE username = ?";
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, username);
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
    
public int Ottieni_Dip(int id_user) throws SQLException {	////NUOVO
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT ID_L FROM dipendente WHERE id_user = ?";
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setInt(1, id_user);
             ResultSet rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int ID_L = rs.getInt("ID_L");
                 System.out.println(ID_L);
                 rs.close();
                 stmt.close();
                 return ID_L;
             } else {
            	 System.out.println(1);
            	 rs.close();
                 stmt.close();
                 return 51;
             }
    	 }
  }
    

 public int Ottieni_Tipo(String username) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT id_tipo FROM user WHERE username = ?";
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, username);
             ResultSet rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int ID_Tipo = rs.getInt("id_tipo");
                 System.out.println(ID_Tipo);
                 rs.close();
                 stmt.close();
                 return ID_Tipo;
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
    	    	String sql = "SELECT "+par1+" FROM user WHERE  USERNAME = ? and password = ? ";
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
    	String sql = "SELECT "+string+" FROM user WHERE  USERNAME = ? and password = ? ";
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
            String sql = "INSERT INTO user (ID_USER,cf, nome, cognome, data_nascita, cell, email, via, citta, provincia, cap, username, password, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setInt(14, 2); // id_tipo = 2 
            
            
            stmt.executeUpdate();

            
                System.out.println("Registrazione completata con successo");
        
        } catch (SQLException e) {
            System.out.println("Errore durante la registrazione: " + e.getMessage());
        } 
    }
    
    public void modificaDati(String username, String password, String repeatPassword) throws SQLException {

    	  DBConnessione d = new DBConnessione();
    	  Connection con=null;
    	  con=d.connessione(con);

    	  String sql = "UPDATE user SET " + password + "=? WHERE username=?";

    	  try (PreparedStatement stmt = con.prepareStatement(sql)) {
    	    stmt.setString(1, repeatPassword);
    	    stmt.setString(2, username);

    	    int result = stmt.executeUpdate();

    	    if (result == 1) {
    	      System.out.println("Modifica effettuata con successo");
    	    } else {
    	      System.out.println("Errore durante la modifica dei dati");
    	    }

    	  }
    	}

    
//settaggio parametri classe user
/*    public void setParametri(String username,String password) throws SQLException {
    	  User u = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
      		u.setCf(OttieniParametroUserString("CF",username,password));
    }
    
    ////////
     * public String OttieniPsw(String cf,String user,String email) throws SQLException{
    	
    	DBConnessione d =new DBConnessione();
    	Connection con=null;
    	con=d.connessione(con);
    	String psw=null;
    	String sql =" SELECT password \r\n"
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
 */   
    public boolean login(String username, String password) throws SQLException {
        Connection conn = null;
        DBConnessione d =new DBConnessione();
       	conn=d.connessione(conn);        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loggedIn = false;
    
        try {
            
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
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
   
    
    public void OttieniParametriLavoratore(int ID_L) throws SQLException {
	 DBConnessione d =new DBConnessione();
	conn=d.connessione(conn);
	String sql = "SELECT giorno,ora_inizio,ora_fine FROM turni_lavoro WHERE ID_L = ?";
	
	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1,ID_L);
         ResultSet rs = stmt.executeQuery();
         
         if (rs.next()) {
             java.sql.Date giorno = rs.getDate("giorno");
             java.sql.Time ora_inizio = rs.getTime("ora_inizio");
             java.sql.Time ora_fine = rs.getTime("ora_fine");
             rs.close();
             stmt.close();
            
         } else {
        	
        	 rs.close();
             stmt.close();
            
         }
	 }
}
   // ottieni parametro data da turni_lavoro
 public java.sql.Date OttieniParametroDateTurniLavoro(String string,int id_user) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT "+string+" FROM turni_lavoro WHERE id_user = ?";
    	java.sql.Date ris = null;
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_user);
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
         
 // ottiene parametro time da turni_lavoro
 public java.sql.Time OttieniParametroTimeTurniLavoro(String string,int ID_L) throws SQLException {
 	
 	DBConnessione d =new DBConnessione();
 	conn=d.connessione(conn);
 	String sql = "SELECT "+string+" FROM turni_lavoro WHERE ID_L = ?";
 	Time ris = null;
 	
 	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1, ID_L);
          ResultSet rs = stmt.executeQuery();
          if(rs.next()) {
         	 ris=rs.getTime(string);
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
 public void deleteAccount(int id_user, String username) throws SQLException {

     DBConnessione d = new DBConnessione();
     conn = d.connessione(conn);
     
     String sql = "DELETE FROM user WHERE id_user = ?";

     try (PreparedStatement statement = conn.prepareStatement(sql)) {
      
        statement.setInt(1, id_user);
        
        int rowsDeleted = statement.executeUpdate();
        
        if(rowsDeleted > 0) {
           System.out.println("Account deleted for: " + username); 
        }
        else {
           System.out.println("Account not found or error deleting account: " + username);
        }
        
     } catch (SQLException e) {
        System.out.println("Error deleting account: " + e.getMessage());
     
     conn.close();
  }
 }
 
 public void deleteAccCliente(int id_user, String username) throws SQLException{
	 
	 DBConnessione d = new DBConnessione();
     conn = d.connessione(conn);
     String sql = "DELETE FROM cliente WHERE username = ? and id_user = ?";

     try (PreparedStatement statement = conn.prepareStatement(sql)){
    	 statement.setInt(1, id_user);
         
         int rowsDeleted = statement.executeUpdate();
         if(rowsDeleted > 0) {
             System.out.println("Cancellazione dell'account del cliente associato allo username: " + username); 
          }
          else {
             System.out.println("Account non trovato o errore nella cancellazione dell'account: " + username);
          }
          
       } catch (SQLException e) {
          System.out.println("Errore nella cancellazione dell'account " + e.getMessage());
       
       conn.close();
    }
     }
}