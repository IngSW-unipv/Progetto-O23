package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utente.User;

public class Paese_Dao {
    private Connection conn;

    public Paese_Dao() {
        
    }
    
    public int Ottieni_IdNazione(String nazione) throws SQLException {
    	
    	DBConnessione d =new DBConnessione();
    	conn=d.connessione(conn);
    	String sql = "SELECT ID_NAZ FROM Nazione WHERE NOME_N = ?";
    	
    	 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, nazione);
             ResultSet rs = stmt.executeQuery();
             
             if (rs.next()) {
                 int Id_nazione = rs.getInt("ID_NAZ");
                 System.out.println(Id_nazione);
                 return Id_nazione;
             } else {
            	 System.out.println(51);
                 return 51;
             }

           //non capisco perche non fa la return percio stampo con sysout
         }
    	
    	
    	
    }

}
