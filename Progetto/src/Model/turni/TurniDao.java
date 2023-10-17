package Model.turni;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.direttore.LavoratoriGUI;
import dao.DBConnessione;

public class TurniDao {
	
	public void caricaTurni(JTable table) {
		 	DBConnessione d = new DBConnessione();
	        Connection con = null;
	        con = d.connessione(con);
		
		String sql = "select id_l, giorno, ora_inizio, ora_fine, id_t from turni_lavoro";
		
		 try(PreparedStatement stmt = con.prepareStatement(sql)) {
	         
			 
			 
	         ResultSet rs = stmt.executeQuery();
			 java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			 DefaultTableModel model =(DefaultTableModel) table.getModel();
	         
			 model.setRowCount(0);
	         
			 int col = rsmd.getColumnCount();
			 String[] colName = new String[col];
			 
			 for(int i=0; i<col; i++ ) {
				 colName[i]=rsmd.getColumnName(i+1);
				 model.setColumnIdentifiers(colName);
			 }	 
				 
				 
				 while(rs.next()) {
					 
					 String lavoratore=rs.getString(1);
					 String giorno=rs.getString(2);
					 String ora_inizio=rs.getString(3);
					 String ora_fine=rs.getString(4);
					 String turno=rs.getString(5);
					 
					 
					 String[] row= {lavoratore, giorno, ora_inizio, ora_fine, turno};
					 model.addRow(row);
				
			 }
				 rs.close();
				 stmt.close();
		
		 } catch(SQLException e1) {
			 e1.printStackTrace();
		 }
		
	}
	
	public int prossimoId() throws SQLException {

		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        
        int id = 0;

		  try {

		    //Query per ottenere l'ultimo id
		    String sql = "SELECT id_t FROM turni_lavoro ORDER BY id_t DESC LIMIT 1";

		    stmt = con.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery();

		    

		    if(rs.next()) {
		      id = rs.getInt("id_t");
		    }

		    //Incremento di 1 l'ultimo id
		    id++; 

		   

		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    con.close();
		  }
		  return id;

		}
	
	public void aggiungiTurni(int id_l, Date giorno, Time oraIn, Time oraF, int id_t) {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        
        try {
        	
			String sql ="insert into turni_lavoro values (?, ?, ?, ?, ?)";

			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id_l);
			stmt.setDate(2, giorno);
			stmt.setTime(3, oraIn);
			stmt.setTime(4, oraF);
			stmt.setInt(5, prossimoId());
			
			stmt.executeUpdate();

			System.out.println("Modifica completata con successo");



		} catch (SQLException e1) {

			e1.printStackTrace();
			
		} 
        
	}
	
	public void modificaTurni(int id_l, Date giorno, Time oraIn, Time oraF, int id_t) {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        
		try {

			String sql ="update turni_lavoro set id_l=?, giorno=?, ora_inizio=?, ora_fine=? where id_t=? ";

			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id_l);
			stmt.setDate(2, giorno);
			stmt.setTime(3, oraIn);
			stmt.setTime(4, oraF);
			stmt.setInt(5, id_t);
			stmt.executeUpdate();

			System.out.println("Modifica completata con successo");



		} catch (SQLException e1) {

			e1.printStackTrace();

		} 

	}
	
	public void eliminaTurni(int id_t) {

	    DBConnessione d = new DBConnessione();
	    Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
	    
	        String sql = "DELETE FROM turni_lavoro WHERE id_t=?";
	        
	        try {
	        	
	        	stmt=con.prepareStatement(sql);
	        	stmt.setInt(1, id_t);
	        	stmt.executeUpdate();
	        System.out.println("turno eliminato con successo!");
	    } catch (SQLException e) {
	        System.out.println("Errore durante l'eliminazione della riga: " + e.getMessage());
	    }
 }

	public boolean turnoDuplicato(int id_l, Date giorno, Time oraIn, Time oraF) throws SQLException {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
                
		try {

			String sql ="select count(*) from turni_lavoro where id_l= ? and giorno=? and ora_inizio=? and ora_fine=?";

			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id_l);
			stmt.setDate(2, giorno);
			stmt.setTime(3, oraIn);
			stmt.setTime(4, oraF);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)>0;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();

		}
		return false;
	}
	

}
