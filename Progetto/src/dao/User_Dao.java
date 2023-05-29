package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utente.User;

public class User_Dao {
    private Connection conn;

    public User_Dao() {
        
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

           //non capisco perche non fa la return percio stampo con sysout
         }
    	
    	
    	
    }

}
