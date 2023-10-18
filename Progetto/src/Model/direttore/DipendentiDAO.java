package Model.direttore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

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
			"join dipendente on user.id_user=dipendente.id_user;";
	
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
	
	 } catch(SQLException e1) {
		 e1.printStackTrace();
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
			System.out.println("nuovo stipendio"+ stipendio);
			System.out.println("Modifica completata con successo");



		} catch (SQLException e1) {

			e1.printStackTrace();

		} 
		
	}

}
