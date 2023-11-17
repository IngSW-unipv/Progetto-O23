package Model.direttore;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import Model.User;
import Model.dipendente.Dipendenti;
import Model.dipendente.DipendentiDAO;
import Model.turni.TurniDao;
import Model.turni.Turni_Lavoro;

public class Direttore extends Dipendenti{
	int id_L;
//COSTRUTTORE
	public Direttore(String cf, String nome, String cognome, java.sql.Date dataDiNascita, String via, String citta, String provincia, int cap, String numTelefono,
			String email, String username, String password, int id_L, String ruolo, int stipendio) {
		super(cf, nome, cognome, dataDiNascita, numTelefono, via, citta, provincia, cap, email, username, password, ruolo, stipendio);
		
	}

public void registaDip(String cf, String nome, String cognome, java.sql.Date dataNascita, String cell, String via,  String citta, String provincia, int cap, String email, 
		String username, String password, String ruolo, int stipendio) throws NoSuchAlgorithmException, SQLException {
	DirettoreDAO dir = new DirettoreDAO();
	Dipendenti dip = new Dipendenti(cf, nome, cognome, dataNascita, cell, via, citta, provincia, cap, email, username, password, ruolo, stipendio);
	dir.dip_Register(dip);
	
}

public void aggiungiTu(int id_l, Date giorno, Time oraIn, Time oraF, int id_t) {
	TurniDao turni= new TurniDao();
	turni.aggiungiTurni(id_l, giorno, oraIn, oraF, id_t);
}
public void modificaTu(int id_l, Date giorno, Time oraIn, Time oraF, int id_t) {
	TurniDao turni= new TurniDao();
	turni.modificaTurni(id_l, giorno, oraIn, oraF, id_t);
}

public void cancellaTu(int id_t) {
	TurniDao turni= new TurniDao();
	turni.eliminaTurni(id_t);
}

public void modificaDi(int id_l, int stipendio, String ruolo) {
	DipendentiDAO dip= new DipendentiDAO();
	dip.modificaDip(id_l, stipendio, ruolo);
}

public void licenziaDi(int id_l) {
	DipendentiDAO dip= new DipendentiDAO();
	dip.Licenzia(id_l);
	
}

	
//GETTER SETTER
	public int getId_L() {
		return id_L;
	}

	public void setId_L(int id_L) {
		this.id_L = id_L;
	}



	
	
	

}
