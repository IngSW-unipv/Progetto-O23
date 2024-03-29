package Model.turni;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DBConnessione;

public class TurniDao {

// metodo per caricare da db i turni	
	public void caricaTurni(JTable table) {
		 	DBConnessione d = new DBConnessione();
	        Connection con = null;
	        con = d.connessione(con);
		
		String sql = "select id_l, giorno, ora_inizio, ora_fine, id_t from turni_lavoro ORDER BY giorno asc";
		
		 try(PreparedStatement stmt = con.prepareStatement(sql)) {
	         
			// utilizzo un modello che prende direttamente dal db la costruzione in righe e colonne della tabella
			
			 
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
				 
			// successivamente imposto l'ordine di visualizzazione delle colonne				 
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
				 con.close();
		 } catch(SQLException e1) {
			 e1.printStackTrace();
			 return;
		 }
		
	}

// due metodi per la generazione degli id
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
// metodo per aggiungere un nuovo turno tramite i valori delle field presenti nella view	
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

			System.out.println("Turno aggiunto con successo");

			stmt.close();
			con.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
			return;
		} 
        
	}
// metodo di modifica del turno tramite inserimento in tabella dei valori delle field	
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
			stmt.close();
			con.close();


		} catch (SQLException e1) {

			e1.printStackTrace();
			return;
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
	        	
	        	stmt.close();
	        	con.close();
	        	
	    } catch (SQLException e) {
	        System.out.println("Errore durante l'eliminazione della riga: " + e.getMessage());
	        return;
	    }
 }

	public boolean turnoDuplicato(int id_l, Date giorno, Time oraIn, Time oraF) throws SQLException {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
                
		try {
			// query di verifica duplicato, controlla se ho già un turno del tipo inserito nelle field per l'id_l selezionato
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

		}finally {
		   con.close();
		}
		return false;
	}
	

}
