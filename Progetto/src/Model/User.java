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

public boolean login(String username ,String password) throws SQLException {
	

	Gestione_Dao g =  new Gestione_Dao();
	//richiamo metodo controllo dell esistenza dell'untente
	return g.login(username, password);
	
 
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

private boolean verificaDuplicati(String cf, String username, String email) {
    DBConnessione d =new DBConnessione();
	Connection con=null;
	con=d.connessione(con);
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Verifica duplicati per CF
        String sql = "SELECT * FROM user WHERE cf=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, cf);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }

        // Verifica duplicati per username
        sql = "SELECT * FROM user WHERE username=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }

        // Verifica duplicati per email
        sql = "SELECT * FROM user WHERE email=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }

        return false;
    } catch (SQLException e) {
        System.out.println("Errore durante la verifica dei duplicati: " + e.getMessage());
        return true;
    } 
}

public void registrazione(String cf, String nome, String cognome, String dataNascita, String cell, String via, String citta, String provincia, int cap, String email, String username, String password) throws SQLException, NoSuchAlgorithmException {
	
    // Verifica che il CF, l'username e l'email non siano già presenti nel database
	Gestione_Dao g = new Gestione_Dao();
	g.user_Register(cf, nome, cognome, dataNascita, cell, via, citta, provincia, cap, email, username, password);	
     
}
    
    
 //OTTIENI PASSWORD UTENTE
 public String OttieniPassword(String cf,String user,String email) throws SQLException {
    Gestione_Dao g =  new Gestione_Dao();
    return g.OttieniPsw(cf, user, email);
            
}
    

    
    
public void modificaDati(String attributo, String nuovoValore) throws SQLException {
     if (!login) {
          System.out.println("Devi effettuare il login per modificare i tuoi dati");
          return;
     }

       DBConnessione d = new DBConnessione();
       Connection con=null;
       con=d.connessione(con);
       String sql = "UPDATE user SET " + attributo + "=? WHERE username=? AND psw=?";

       try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nuovoValore);
            stmt.setString(2, Username);
            stmt.setString(3, Password);
            int result = stmt.executeUpdate();
            if (result == 1) {
                switch (attributo) {
                    case "cf":
                        Cf = nuovoValore;
                        break;
                    case "nome":
                        Nome = nuovoValore;
                        break;
                    case "cognome":
                        Cognome = nuovoValore;
                        break;
                    case "data_nascita":
                        DataDiNascita = java.sql.Date.valueOf(nuovoValore);
                        break;
                    case "cell":
                        NumTelefono = nuovoValore;
                        break;
                    case "via":
                        Via = nuovoValore;
                        break;
                    case "citta":
                        Citta = nuovoValore;
                        break;
                    case "cap":
                        CAP = Integer.parseInt(nuovoValore);
                        break;
                    case "email":
                        Email = nuovoValore;
                        break;
                    case "username":
                        Username = nuovoValore;
                        break;
                    case "psw":
                        Password = nuovoValore;
                        break;
                    default:
                        System.out.println("Attributo non valido");
                        return;
                }
                System.out.println("Modifica effettuata con successo");
            } else {
                System.out.println("Errore durante la modifica dei dati");
            }
        }
}


@Override
public String toString() {
	
	return "User [Cf=" + Cf + ", Nome=" + Nome + ", Cognome=" + Cognome + ", DataDiNascita=" + DataDiNascita
				+ ", Eta=" + ", NumTelefono=" + NumTelefono + ", Email=" + Email + ", Username=" + Username
				+ ", Password=" + Password + ", login=" + login + "]";
}




















}



	 



