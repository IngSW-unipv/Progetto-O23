package Model.prenotazione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import dao.DBConnessione;

public class PrenotaDAO {

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