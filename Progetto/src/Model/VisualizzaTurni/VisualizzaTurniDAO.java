package Model.VisualizzaTurni;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JTable;

import dao.DBConnessione;

public class VisualizzaTurniDAO {
	
	// metodo per caricare da db il turno del dipendente	
public void vediTurni(int ID_L) {
			 	DBConnessione d = new DBConnessione();
		        Connection con = null;
		        con = d.connessione(con);
			
			String sql = "select ruolo, stipendio from dipendente where ID_L = ? ";
			String ruolo = null;
			//int stipendio = (Integer) null;
			 try(PreparedStatement stmt = con.prepareStatement(sql)) {
				 stmt.setInt(1,ID_L);
		         ResultSet rs = stmt.executeQuery();
		         if (rs.next()) {
		             ruolo = rs.getString(ruolo);
		             //stipendio = rs.getInt(stipendio);
		             rs.close();
		             stmt.close();
		            
		         } else {
					 stmt.close();
					 con.close();
		         }
			 } catch(SQLException e1) {
				 e1.printStackTrace();
				 return;
			 }
			
		}
	

}
