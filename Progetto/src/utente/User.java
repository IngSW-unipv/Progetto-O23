package utente;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	

//Costruttore 
public User(String Cf, String Nome, String Cognome, Date DataDiNasciuta, String NumTelefono, String Email, String Username, String Password ) {
	if (Cf.length()== 16) {
		this.Cf = Cf;
	} else {
		 throw new IllegalArgumentException("Il codice fiscale inserito è errato, riprova.");
	}
	this.Nome = Nome;
	this.Cognome = Cognome;
	this.Eta = Eta;
      
    //telephone number conditions
    if(NumTelefono.length() == 0) {
    	throw new IllegalArgumentException("numero di telefono mancante, riprova");
    } else {						//we are not considering a "between" because maybe in 20 years the numbers can change in length
    	this.NumTelefono = NumTelefono;	
    		}
    //finish
    if(verificaEmail(Email)) {
    	throw new IllegalArgumentException("Email già in uso, riprova");
    } else {
    this.Email = Email;
    }
    
    if (verificaUsername(Username)) {
    	throw new IllegalArgumentException("Username già in uso, riprova");
    } else {	
    	this.Username = Username;}
    
    this.Password = criptaPassword(Password);
    
    
    
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

// Metodo per verificare se lo username è già stato utilizzato
private static boolean verificaUsername(String Username) {
 
    // Restituisce true se lo username è già stato utilizzato, false altrimenti
    return false;
}

// Metodo per verificare se l'email è valida
private static boolean verificaEmail(String email) {
    // Restituisce true se l'email è valida, false altrimenti
    return true;
}

// Metodo per criptare la password utilizzando l'algoritmo SHA-256
private String criptaPassword(String password) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}


}

