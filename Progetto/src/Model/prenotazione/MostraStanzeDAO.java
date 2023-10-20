package Model.prenotazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DBConnessione;

public class MostraStanzeDAO {
	
	public int RecuperaStanzeOccupate(String datain, String dataout, JTable table) throws SQLException {
		// Connessione al database
	       DBConnessione d =new DBConnessione();
	       Connection con=null;
	       con=d.connessione(con);
	       
	       if (datain == null || datain.isEmpty() || dataout == null || dataout.isEmpty()) {
	    	    return 2;
		     } else {
	      
	      int[] numeriCamera = new int[20];  // Array di interi con dimensione massima 20
	      int count = 0;  // Contatore per il numero effettivo di elementi inseriti      
	      
	              String sql= "SELECT c.NUMERO, c.TIPO, c.PIANO, c.PREZZO\r\n"
	              		+ "FROM camera c\r\n"
	              		+ "WHERE NOT EXISTS (\r\n"
	              		+ "    SELECT 1\r\n"
	              		+ "    FROM prenotazione p\r\n"
	              		+ "    WHERE p.NUMERO_CAMERA = c.NUMERO\r\n"
	              		+ "    AND (\r\n"
	              		+ "        (p.CHECK_IN <= ? AND p.CHECK_OUT >= ?)\r\n"
	              		+ "        OR (p.CHECK_IN <= ? AND p.CHECK_OUT >= ?)\r\n"
	              		+ "        OR (p.CHECK_IN >= ? AND p.CHECK_OUT <= ?)\r\n"
	              		+ "    )\r\n"
	              		+ ");;";
	              
	              try (PreparedStatement statement = con.prepareStatement(sql)) {
	                  statement.setString(1, datain);
	                  statement.setString(2, datain);
	                  statement.setString(3, dataout);
	                  statement.setString(4, dataout);
	                  statement.setString(5, datain);
	                  statement.setString(6, dataout);

	                  // Esecuzione della query e ottenimento dei risultati
	                  ResultSet rs = statement.executeQuery();

	                  boolean trovateStanze = false;

	                  while (rs.next()) {
	                      String cameranumero = rs.getString("numero");
	                      numeriCamera[count] = Integer.valueOf(cameranumero);
	                   
	                      trovateStanze = true;
	                      count++;
	                  }

	                  rs.close();
	                  con.close();

	                  if (!trovateStanze) {
	                      return 1;
	                  } else {

	                	  mostrastanzeingui(numeriCamera, count, table);
	                      return 0;
	                  }
	              }
		     }
	  }
	
	 private void mostrastanzeingui(int[] numeriCamera, int count, JTable tabella) throws SQLException {
		 //pulisci la tabella se c'è contenuto
		 DefaultTableModel model1 =(DefaultTableModel) tabella.getModel();
         
		 while (model1.getRowCount() > 0) {
              model1.removeRow(0);
          }
		 
		 // Connessione al database
	       DBConnessione d =new DBConnessione();
	       Connection conn=null;
	       conn=d.connessione(conn);
		 
		 int j = 0;
	          // Crea lo statement SQL con un parametro
	         String query = "SELECT * FROM camera WHERE numero = ?";
	        for(int k=0; k<count; k++) {
	        	    try(PreparedStatement stmt2 = conn.prepareStatement(query)) {
	             
	    		 stmt2.setInt(1,numeriCamera[k]);
	             ResultSet rs = stmt2.executeQuery();
	    		 ResultSetMetaData rsmd = rs.getMetaData();
	    		 DefaultTableModel model =(DefaultTableModel) tabella.getModel();
	             
	    		 
	    		 int col = rsmd.getColumnCount();
	    		 String[] colName = new String[col];
	    		 
	    		 for(j=0; j<col; j++ ) {
	    			 colName[j]=rsmd.getColumnName(j+1);
	    			 model.setColumnIdentifiers(colName);
	    		 }	 
	    			 
	         
	    			 
	    			 while(rs.next()) {
	    				 
	    				 String giorno=rs.getString(1);
	    				 String tipo=rs.getString(2);
	    				 String prezzo=rs.getString(5);
	    				 //String id_l=rs.getString(4);
	    				 
	    				 String[] row= {giorno,tipo, prezzo};
	    				 model.addRow(row);
	    			
	    		 }
	         
	    			 rs.close();
	    			 stmt2.close();
	    	
	    	 } catch(SQLException e1) {
	    		 e1.printStackTrace();
	    	 }
	 }
	 }
} 