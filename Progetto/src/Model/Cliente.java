package Model;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;

import dao.Gestione_Dao;

public class Cliente extends User{
	private int Id_Cliente;

	
	
//COSTRUTTORE	

public Cliente(String cf, String nome, String cognome, java.sql.Date dataDiNascita, String via, String citta, String provincia, int cap, String numTelefono,
		String email, String username, String password, int id_Cliente) {
	super(cf, nome, cognome, dataDiNascita, numTelefono, via, citta, provincia, cap, email, username, password);
	Id_Cliente = id_Cliente;
	}

	// metodo per prenotare la camera
	public boolean PrenotaCamera( int Cod_pr, Date Data_Pren, int Num_C) {
		return false;
	}
	


//metodo per cancellare l'account
	public void EliminaACC(String Username, String Password) throws SQLException{
		
		 Gestione_Dao g = new Gestione_Dao();
		g.deleteAccCliente(Id_Cliente,Username);
		
	}
	
//metodo per registrare il cliente
	public void registrazione(String cf, String nome, String cognome, String dataNascita, String cell, String via, String citta, String provincia, int cap, String email, String username, String password) throws SQLException, NoSuchAlgorithmException {
		
	    // Verifica che il CF, l'username e l'email non siano gi� presenti nel database
		
		Gestione_Dao g = new Gestione_Dao();
		g.user_Register(cf, nome, cognome, dataNascita, cell, via, citta, provincia, cap, email, username, password);	
		
	}
	
//metodo per modificare i dati del'cliente
	
	public void modificaAttr(String username, String attributo, String nuovoValore) throws SQLException, NoSuchAlgorithmException {
		
		Gestione_Dao g = new Gestione_Dao();
		g.modificaDati(username, attributo, nuovoValore);	
	     
	}

	
//metodo per visualizzare la prenotazione
	public void ViewPrenotazione(int Id_User) {
		
	}
	

}

