package Model.dipendente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DBConnessione;


public class DipendentiDAO {
	
	public void caricaLav(JTable table) {
	 	DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
	
	String sql = "SELECT id_l, user.nome, user.cognome, ruolo, stipendio, cf, data_nascita, cell, via, citta, provincia, cap FROM user\n" + 
			"\n" + 
			"join dipendente on user.id_user=dipendente.id_user AND id_l NOT IN('999');";
	
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
				 String nome=rs.getString(2);
				 String cognome=rs.getString(3);
				 String ruolo=rs.getString(4);
				 String stipendio=rs.getString(5);
				 String cf=rs.getString(6);
				 String data_nascita=rs.getString(7);
				 String cell=rs.getString(8);
				 String via=rs.getString(9);
				 String citta=rs.getString(10);
				 String provincia=rs.getString(11);
				 String cap=rs.getString(12);
				 
				 
				 
				 String[] row= {lavoratore, nome, cognome, ruolo, stipendio,
						 cf, data_nascita, cell, via, citta, provincia, cap};
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

	public void modificaDip(int id_l, int stipendio, String ruolo) {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        
		try {

			String sql ="update dipendente set ruolo=?, stipendio=? where id_l=? ";

			stmt=con.prepareStatement(sql);
			stmt.setString(1, ruolo);
			stmt.setInt(2, stipendio);
			stmt.setInt(3, id_l);
			stmt.executeUpdate();
			System.out.println("Modifica completata con successo");

			JOptionPane.showMessageDialog(null, "Dipendente modificato con successo!");
			stmt.close();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		} 
		
	}
	
	public void Licenzia(int id_l) {
		DBConnessione d = new DBConnessione();
	    Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        	
        	verificaTurno(id_l);
	    
	        String sql = "DELETE FROM dipendente WHERE id_l=?";
	        
	        try {
	        	
	        	stmt=con.prepareStatement(sql);
	        	stmt.setInt(1, id_l);
	        	stmt.executeUpdate();
	        System.out.println("dipendente licenziato con successo!");
			JOptionPane.showMessageDialog(null, "Riga eliminata con successo!");
			stmt.close();
			con.close();
	    } catch (SQLException e) {
	        System.out.println("Errore durante l'eliminazione della riga: " + e.getMessage());
	        return;
	    }
	}
	
	public void verificaTurno(int id_l) {
		DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
                
		try {
			// query di controllo se ho turni per l'id selezionato
			String sql ="select count(*), id_l from turni_lavoro where id_l= ? group by id_l";

			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id_l);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				if(count>0) {
					String sql2 ="delete from turni_lavoro where id_l= ?";
					stmt=con.prepareStatement(sql2);
					stmt.setInt(1,  id_l);
					
					stmt.executeUpdate();
		
				} else {
					return;
				}
			}
			rs.close();
			
			
		} catch (SQLException e1) {

			e1.printStackTrace();
			return;
		} 
	}
	

}
