package Model.prenotazione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DBConnessione;



public class PrenotaDAO {

	
	public int RecuperaStanzeOccupate(String datain, String dataout, JTable table) throws SQLException {
		// Connessione al database
	       DBConnessione d =new DBConnessione();
	       Connection con=null;
	       con=d.connessione(con);

	      
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
	 
	 private void mostrastanzeingui(int[] numeriCamera, int count, JTable tabella) throws SQLException {
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
	 
	 public int effettuaprenotazione(String datain, String dataout, String Colonna1, String Colonna3, int id) throws SQLException {
		 // Connessione al database
	       DBConnessione d =new DBConnessione();
	       Connection conn=null;
	       conn=d.connessione(conn);
	     
	     String sql = "INSERT INTO prenotazione (COD_PR, CHECK_IN, CHECK_OUT, COSTO, DATA_PR, NUMERO_CAMERA, ID_USER)VALUES (?,?,?,?,?,?,?);";
	     int codice = recuperacodiceprenotazione();
	     int datetotali = recuperacostoprenotazione(datain, dataout);
	     int costosingolo = Integer.parseInt(Colonna3);
	     int costototale = datetotali * costosingolo;
	     LocalDate datapr = LocalDate.now();
	     Date dataprsql = Date.valueOf(datapr);
	     int numerocamera = Integer.parseInt(Colonna1);
	     
	     try (PreparedStatement statement2 = conn.prepareStatement(sql)){
	    	 statement2.setInt(1, codice);
	    	 statement2.setString(2, datain);
	    	 statement2.setString(3, dataout);
	    	 statement2.setInt(4, costototale);
	    	 statement2.setDate(5, dataprsql);
	    	 statement2.setInt(6, numerocamera);
	    	 statement2.setInt(7, id);
	    	 
	         int rowsDeleted = statement2.executeUpdate();
	         if(rowsDeleted > 0) {
	        	 int numero = 1;
	             return  numero; //pren ok
	          }
	          else {
	        	  int numero = 0; //pren sbagliata
	        	  return numero;
	          }
	          
	       } catch (SQLException e) {
	           conn.close();
	    	   int numero = 0; //pren sbagliata
	     	  return numero;
	    }
		 
	 }
	 
	 public int recuperacodiceprenotazione() throws SQLException {
		 // Connessione al database
	       DBConnessione d =new DBConnessione();
	       Connection conn=null;
	       conn=d.connessione(conn);
	       Statement stmt3 = null;
		 
	     int ultimoValore =0;
	     //trova l'ultima prenotazione inserita
	     String sql = "SELECT MAX(COD_PR) AS ultimo_valore FROM prenotazione";

	      // Esegue la query
	     stmt3 =  conn.createStatement();
	     ResultSet rs = stmt3.executeQuery(sql);

	     // Estrae il risultato
	     while (rs.next()) {
	         ultimoValore = rs.getInt("ultimo_valore");
	     }
	     //aumento di 1 il valore
	     ultimoValore = ultimoValore + 1;
	      //ritorno il valore da aggiungere
		 return ultimoValore;
	 }
	 
	 public int recuperacostoprenotazione(String datain, String dataout) {
		 
		 //mi serve per trovare le ultime due cifre immesse
		 String ultimeDueCifre = datain.substring(datain.length() - 2);
		 String ultimeDueCifre2 = dataout.substring(dataout.length()- 2);
	     //trasformo da string a int
	     int data1 = Integer.parseInt(ultimeDueCifre);
	     int data2 = Integer.parseInt(ultimeDueCifre2);
	     //calcolo il totale delle date
	     int datetotali = data2 - data1;
	     //ritorno il numero
		 return datetotali;
	 }
}