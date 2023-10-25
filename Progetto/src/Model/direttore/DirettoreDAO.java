package Model.direttore;

import java.security.NoSuchAlgorithmException;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.User;
import Model.dipendente.Dipendenti;
import dao.DBConnessione;

public class DirettoreDAO {
	
	
	
	public void dip_Register(Dipendenti dip) throws SQLException, NoSuchAlgorithmException {
		System.out.println("entro nel dao");
    	
   	 // Connessione al database
       DBConnessione d =new DBConnessione();
       Connection con=null;
       con=d.connessione(con);
       PreparedStatement stmt = null;
       
       int id_u= generaIdU();
      
       try {
    	   System.out.println("entro nel try del dao");
           // Inserimento dei dati nella tabella user
           String sql = "INSERT INTO user "
           		+ "(ID_USER,cf, nome, cognome, data_nascita, cell, via, citta, provincia, cap, email, username, password, id_tipo) "
           		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
           stmt = con.prepareStatement(sql);
           stmt.setInt(1, id_u);
           stmt.setString(2, dip.getCf());
           stmt.setString(3, dip.getNome());
           stmt.setString(4, dip.getCognome());
           stmt.setDate(5, dip.getDataDiNascita());
           stmt.setString(6, dip.getNumTelefono());
           stmt.setString(7, dip.getVia());
           stmt.setString(8, dip.getCitta());
           stmt.setString(9, dip.getProvincia());
           stmt.setInt(10, dip.getCAP()); 
           stmt.setString(11, dip.getEmail());
           stmt.setString(12, dip.getUsername());
           stmt.setString(13, dip.getPassword());
           stmt.setInt(14, 1); // id_tipo = 1 dipendenti 
         
           stmt.executeUpdate();
           stmt.close();           
           
           System.out.println("prima query");
                
           PreparedStatement st = null;
           int id_d= generaIdD();
           String sql2="insert into dipendente "
           		+ "(id_l, nome, cognome, ruolo, stipendio, id_user)"
           		+ "values (?, ?, ?, ?, ?, ?) ";
           st = con.prepareStatement(sql2);
           st.setInt(1, id_d);
           st.setString(2, dip.getNome());
           st.setString(3, dip.getCognome());
           st.setString(4, dip.getRuolo());
           st.setInt(5, dip.getStipendio());
           st.setInt(6, id_u);
           
           st.executeUpdate(); 
           st.close();
           System.out.println("seconda query");
           

           System.out.println("Registrazione completata con successo");
           st.close();
           con.close();
       
       } catch (SQLException e) {
           System.out.println("Errore durante la registrazione: " + e.getMessage());
           stmt.close();
           con.close();
       } 
   }
	
	public int generaIdU() throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int id = -1;
        boolean uniqueId = false;
        while (!uniqueId) {
            // Generate a random integer between 100000000 and 999999999
            id = (int) (Math.random() * (999 - 10000 + 1)) + 10000;
            
            try {
                // Check if the generated ID already exists in the database
                String sql = "SELECT COUNT(*) FROM user WHERE ID_USER = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    // If the ID doesn't exist, mark it as unique and exit the loop
                    uniqueId = true;
                }
            } catch (SQLException e) {
                System.out.println("Errore durante la generazione dell'ID: " + e.getMessage());
                throw e;
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        
        return id;
    }
	
	public int generaIdD() throws SQLException {
        DBConnessione d = new DBConnessione();
        Connection con = null;
        con = d.connessione(con);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int id = -1;
        boolean uniqueId = false;
        while (!uniqueId) {
            
            id = (int) (Math.random() * (99 - 1000 + 1)) + 1000;
            
            try {
                
                String sql = "SELECT COUNT(*) FROM dipendente WHERE id_l = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    
                    uniqueId = true;
                }
            } catch (SQLException e) {
                System.out.println("Errore durante la generazione dell'ID: " + e.getMessage());
                throw e;
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        
        return id;
    }
	
	
	
	
	
	public void caricaStanze(JTable table) {
		 DBConnessione d = new DBConnessione();
	        Connection con = null;
	        con = d.connessione(con);
		
		String sql = "select c.numero, cod_pr, check_in, check_out, data_pr,nome, cognome, p.id_user "
				+ "from camera as c "
				+ "left join "
				+ "prenotazione as p "
				+ "on c.numero=p.numero_camera "
				+ "left join "
				+ "user as u "
				+ "on p.id_user=u.id_user "
				+ "ORDER BY NUMERO asc"
				;
		
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
					 
					 String numero=rs.getString(1);
					 String cod_pr=rs.getString(2);
					 String check_in=rs.getString(3);
					 String check_out=rs.getString(4);
					 String data_pr=rs.getString(5);
					 String nome=rs.getString(6);
					 String cognome=rs.getString(7);
					 String id_cliente=rs.getString(8);
					 
					 String[] row= {numero, cod_pr, check_in, check_out, data_pr, nome, cognome, id_cliente};
					 model.addRow(row);
				
			 }
				 rs.close();
				 stmt.close();
				 con.close();
		
		 } catch(SQLException e1) {
			 e1.printStackTrace();
		 }
		
	}

}
