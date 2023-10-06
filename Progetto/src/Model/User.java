package Model;


import dao.DBConnessione;
import dao.Gestione_Dao;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private String Cf;
	private String Nome;
	private String Cognome;
	private java.sql.Date DataDiNascita;
	
	private String NumTelefono; //string because that can accept foreign numbers, so the prefix must be accepted
	private String Email;
	private String Username;
	private String Password;

	private int Id_User;
	private String Via;
	private String Citta;
	private String Provincia;
	private int CAP;
	private int Id_tipo;
	private Boolean login;
	private Boolean registrazione;
	

//Costruttore 
	
	public User(String cf, String nome, String cognome, java.sql.Date dataDiNascita, String numTelefono, String via, String citta, String provincia, int cap,
			String email, String username, String password) {

		this.Cf = cf;
		this.Nome = nome;
		this.Cognome = cognome;
		this.DataDiNascita = dataDiNascita;
		this.NumTelefono = numTelefono;
		this.Via = via;
		this.Citta=citta;
		this.CAP=cap;
		this.Provincia=provincia;
		this.Email=email;
		this.Username=username;
		this.Password=password;
	
		
		
		
	}


//GETTER & SETTER
	


public Boolean getLogin() {
	return login;
}


public void setLogin(Boolean login) {
	this.login = login;
}

public String getCf() {
	return Cf;
}

public void setCf(String cf) {
	Cf = cf;
}


public String getNome() {
	return Nome;
}


public void setNome(String nome) {
	Nome = nome;
}


public String getCognome() {
	return Cognome;
}


public void setCognome(String cognome) {
	Cognome = cognome;
}


public java.sql.Date getDataDiNascita() {
	return DataDiNascita;
}


public void setDataDiNascita(java.sql.Date dataDiNascita) {
	DataDiNascita = dataDiNascita;
}


public String getNumTelefono() {
	return NumTelefono;
}


public void setNumTelefono(String numTelefono) {
	NumTelefono = numTelefono;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


public String getUsername() {
	return Username;
}


public void setUsername(String username) {
	this.Username = username;
}


public String getPassword() {
	return Password;
}


public void setPassword(String password) {
	this.Password = password;
}


public String getVia() {
	return Via;
}


public void setVia(String via) {
	this.Via = via;
}	
	
	public String getCitta() {
		return Citta;
	}


	public void setCitta(String citta) {
		this.Citta = citta;
}		

	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	
public int getId_User() {
	return Id_User;
}

public void setId_User(int id_user) {
	Id_User = id_user;
}


public int getCAP() {
	return CAP;
}

public void setCAP(int cap) {
	CAP = cap;
}

public int getId_tipo() {
	return Id_tipo;
}

public void setId_tipo(int id_tipo) {
	Id_tipo = id_tipo;
}
//FINISH GETTER & SETTER

//LOGIN

public boolean login(String username ,String password, int id_tipo) throws SQLException {
	
	Gestione_Dao g =  new Gestione_Dao();
	//richiamo metodo controllo dell esistenza dell'untente
	
	Cf=g.OttieniParametroUserString("cf", username, password);
	Username=g.OttieniParametroUserString("username", username, password);
	Password=g.OttieniParametroUserString("password", username, password);
	Cognome=g.OttieniParametroUserString("cognome", username, password);
	Nome=g.OttieniParametroUserString("nome", username, password);
	Email=g.OttieniParametroUserString("email", username, password);
	NumTelefono=g.OttieniParametroUserString("cell", username, password);
	DataDiNascita=g.OttieniParametroUserDate("data_nascita", username, password);
	Id_tipo = g.Ottieni_Tipo(username);
	login=g.login(username, password);
	
	return login;
	
}




//LOGOUT
public boolean logout(boolean log) {
	
//controllo se l'utente ha effettuato il login	
	
	if(log = true) {
		login=false;
		Username=null;
   	 	Password=null;
   	 	Cognome=null;
   	 	Nome=null;
   	 	Cf=null;
   	 	Email=null;
   	 	NumTelefono=null;
   	 	DataDiNascita=null;
   	 	System.out.println("logout effettuato!");
   	 	return login;
		
		
	}else
		System.out.println("impossibile effettuare logout non hai effettuato il login");
	return login;
	
}

    
/* //OTTIENI PASSWORD UTENTE
 public String OttieniPassword(String cf,String user,String email) throws SQLException {
    Gestione_Dao g =  new Gestione_Dao();
    return g.OttieniPsw(cf, user, email);
            
}
*/

@Override
public String toString() {
	return "User [Cf=" + Cf + ", Nome=" + Nome + ", Cognome=" + Cognome + ", DataDiNascita=" + DataDiNascita
			+ ", NumTelefono=" + NumTelefono + ", Email=" + Email + ", Username=" + Username + ", Password=" + Password
			+ ", login=" + login + "]";
}
public void EliminaAcc(int id_user, String username) throws SQLException {
	 Gestione_Dao g = new Gestione_Dao();
	 g.deleteAccount(id_user, username);
}
    

    
























}
