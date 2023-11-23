package Model.VisualizzaTurni;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Time;


import dao.DBConnessione;

public class VisualizzaTurniDAO {
	public void modificaDati(int id_l, Date giorno, Time oraIn, Time oraF, int id_t) {
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

}
