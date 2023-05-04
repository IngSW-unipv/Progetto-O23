package code;

import java.util.Date;

public class Cliente {
	private int Id_Cliente;

	public Cliente(int id_Cliente) {
		this.Id_Cliente = id_Cliente;
		
	}
// metodo per prenotare la camera
	public boolean PrenotaCamera( int Cod_pr, Date Data_Pren, int Num_C) {
		return false;
	}
	
//metodo per cancellare l'account
	public void EliminaACC(String Username, String Passward) {
		
	}
//metodo per modificare la data di prenotazione 
	/*
	public Date ModificaDataPrenotazione(int Id_User) {
		return 
	}
	
	*/
	
//metodo per richiedere comfort
	public void RichiediComfort(String Tipo) {
		
	}
	
//metodo per visualizzare la prenotazione
	public void ViewPrenotazione(int Id_User) {
		
	}
	

}

