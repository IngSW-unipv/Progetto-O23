package utente;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import dao.DBConnessione;

import java.security.MessageDigest;
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
	private int Eta;
	private String NumTelefono; //string because that can accept foreign numbers, so the prefix must be accepted
	private String Email;
	
	private String Username;
	private String Password;

	private int Id_User;
	private int Id_Citta;
	private int Id_Prov;
	private int Id_Nazione;
	private int Id_tipo;
	private Boolean login;
	

//Costruttore 
	
	public User(String cf, String nome, String cognome, java.sql.Date dataDiNascita, int eta, String numTelefono,
			String email, String username, String password) {
		this.Cf = cf;
		this.Nome = nome;
		this.Cognome = cognome;
		this.DataDiNascita = dataDiNascita;
		this.Eta = eta;
		this.NumTelefono = numTelefono;
		this.Email = email;
		this.Username = username;
		this.Password = password;
	}


//GETTER & SETTER

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


public int getEta() {
	return Eta;
}


public void setEta(int eta) {
	Eta = eta;
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

public int getId_User() {
	return Id_User;
}

public void setId_User(int id_User) {
	Id_User = id_User;
}

public int getId_Citta() {
	return Id_Citta;
}

public void setId_Citta(int id_Citta) {
	Id_Citta = id_Citta;
}

public int getId_Prov() {
	return Id_Prov;
}

public void setId_prov(int id_Prov) {
	Id_Prov = id_Prov;
}

public int getId_Nazione() {
	return Id_Nazione;
}

public void setId_Nazione(int id_Nazione) {
	Id_Nazione = id_Nazione;
}

public int getId_tipo() {
	return Id_tipo;
}

public void setId_tipo(int id_tipo) {
	Id_tipo = id_tipo;
}
//FINISH GETTER & SETTER

//METHODS	

public boolean login(String username ,String password) throws SQLException {
	
	DBConnessione d =new DBConnessione();
	Connection con=null;
	con=d.connessione(con);
	int count=0;
	String sql = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS USERNAME \r\n"
			+ "FROM user \r\n"
			+ "WHERE USERNAME = ? and PSW = ? ";
	
	 try (PreparedStatement stmt = con.prepareStatement(sql)) {
         stmt.setString(1, username);
         stmt.setString(2, password);
         ResultSet rs = stmt.executeQuery();
         rs.next();
         count = rs.getInt(1);
         con.close();
         if(count==1) {
        	 System.out.println("loggato");
        	 login=true;
        	 return login;
         }else {
         login=false;
         System.out.println("utente inesistente o password sbagliata");
         return login;
         
         }

	 }
}



}

