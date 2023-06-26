package dao;

import java.sql.Connection;
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
                 return ID_CLIENTE;
             } else {
            	 System.out.println(1);
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
    	            	 
    	            	 return ris;
    	             }else {
    	            	 rs.close();
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
            	 
            	 return ris;
             }else {
            	 rs.close();
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
    	System.out.println(IdList);
    	
         return ultimo_id+1;  
    
    	
             
    }

}
