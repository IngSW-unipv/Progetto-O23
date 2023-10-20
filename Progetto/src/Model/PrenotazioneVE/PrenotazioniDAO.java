package Model.PrenotazioneVE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DBConnessione;
import java.sql.Connection;

public class PrenotazioniDAO {
	 private Connection conn;

	public void MostraLePrenotazioni(int id, JTable table) throws SQLException {
		
		    int j = 0;
		    id = 123452;
		    DBConnessione d = new DBConnessione();
		    conn = d.connessione(conn);

		    String query = "SELECT * FROM prenotazione WHERE ID_USER = ?";

		    try (PreparedStatement stmt = conn.prepareStatement(query)) {
		        stmt.setInt(1, id);

		        ResultSet rs = stmt.executeQuery();
		        ResultSetMetaData rsmd = rs.getMetaData();
		        DefaultTableModel model2 = (DefaultTableModel) table.getModel();

		        int col = rsmd.getColumnCount();
		        String[] colName = new String[col];

		        colName[j] = rsmd.getColumnName(j + 1);
		        for (j = 0; j < col; j++) {
		            model2.setColumnIdentifiers(colName);
		        }

		        while (rs.next()) {
		            String giorno = rs.getString(1);
		            int numero = rs.getInt(6);
		            int id2 = rs.getInt(7);

		            String numeroStringa = "" + numero;
		            String numeroStringa2 = "" + id2;

		           
		            String[] row = {giorno, numeroStringa, numeroStringa2};
		            model2.addRow(row);
		        }

		        rs.close();
		        stmt.close();

		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    }
		}
	 
	 public void eliminaprenotazioneDAO(int id, String selectedValueCol1) {

		    DBConnessione d = new DBConnessione();
		    conn = d.connessione(conn);
		    
		        String query = "DELETE FROM prenotazione WHERE COD_PR=?";
		        
		        try(PreparedStatement statement = conn.prepareStatement(query)){
		        statement.setString(1, selectedValueCol1);
		        statement.executeUpdate();
		        System.out.println("prenotazione eliminata con successo!");
		    } catch (SQLException e) {
		        System.out.println("Errore durante l'eliminazione della riga: " + e.getMessage());
		    }
	 }
	 
	
}