package Model;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import dao.DBConnessione;
import dao.Gestione_Dao;

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
	private Boolean registrazione;
	

//Costruttore 
	
	public User(String cf, String nome, String cognome, java.sql.Date dataDiNascita, int eta, String numTelefono,
			String email, String username, String password) {
		
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

//LOGIN

public boolean login(String username ,String password) throws SQLException {
	

	Gestione_Dao g =  new Gestione_Dao();
	//richiamo metodo controllo dell esistenza dell'untente
	
	
//se count = 1 l'utente e nel DB

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
        	 Gestione_Dao g1 =  new Gestione_Dao();
        	 Username=username;
        	 Password=password;
        	 Cognome=g1.OttieniParametroUserString("Cognome",username,password);
        	 Nome=g1.OttieniParametroUserString("Nome",username,password);
        	 Cf=g1.OttieniParametroUserString("CF", username, password);
        	 Email=g1.OttieniParametroUserString("EMAIL", username, password);
        	 NumTelefono=g1.OttieniParametroUserString("CELL", username, password);
        	 DataDiNascita=g1.OttieniParametroUserDate("DATA_NASCITA", username, password);
        	 return login;
         }else {
         login=false;
         System.out.println("utente inesistente o password sbagliata");
         return login;
         
         }
	 }
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

public void registrati(String cf, String nome, String cognome, String dataNascita, String cell, String email, String citta, String username, String password) throws SQLException {
    // Verifica che il CF, l'username e l'email non siano già presenti nel database
	Gestione_Dao g = new Gestione_Dao();
	g.user_Register(cf, nome, cognome, dataNascita, cell, email, citta, username, password);
    	
    

    
    

     
}
    
    
 //OTTIENI PASSWORD UTENTE
    
    public String OttieniPassword(String cf,String user,String email) throws SQLException {
    	DBConnessione d =new DBConnessione();
    	Connection con=null;
    	con=d.connessione(con);
    	String psw=null;
    	String sql =" SELECT PSW \r\n"
    			+"FROM USER \r\n"
    			+"WHERE USERNAME= ? and  CF= ? and EMAIL= ?";
    	 try (PreparedStatement stmt = con.prepareStatement(sql)) {
             stmt.setString(1, user);
             stmt.setString(2, cf);
             stmt.setString(3, email);
             ResultSet rs = stmt.executeQuery();
             if (rs.next()) {
            	 psw = rs.getString("PSW");
                 return psw;
             } else {
            	 System.out.println("impossibile trovare password hai sbagliato a inserire i dati");
            	 return psw;
             }
             
    	
    }
    	 
    	 
    
    
}


	@Override
	public String toString() {
		return "User [Cf=" + Cf + ", Nome=" + Nome + ", Cognome=" + Cognome + ", DataDiNascita=" + DataDiNascita
				+ ", Eta=" + Eta + ", NumTelefono=" + NumTelefono + ", Email=" + Email + ", Username=" + Username
				+ ", Password=" + Password + ", login=" + login + "]";
	}




















}



	 



