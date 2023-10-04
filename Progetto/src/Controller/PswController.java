package Controller;

import java.sql.SQLException;
import javax.swing.*;

import Model.User;
import View.PswLost_Form;
import dao.Gestione_Dao;

public class PswController {
	  private PswLost_Form view;
	  private Gestione_Dao dao;
	    
	 
	  public PswController(PswLost_Form view) {
	    this.view = view;
	    dao = new Gestione_Dao();
	  }

	  public void modifyPassword() {

	    // recover username da view
		String username = view.getUsername();
		String password = view.getPassword();
		String repeatPassword = view.GetPasswordConferma();

	    if(check(password, repeatPassword)) {
	      
	      try {
			dao.modificaDati(username, "password", repeatPassword);
			JOptionPane.showMessageDialog(view, "Password modificata");
	      } catch (SQLException e) {
			JOptionPane.showMessageDialog(view, "Errore durante la modifica della password");
	      }	
		} else if (password.length()< 8){
	      JOptionPane.showMessageDialog(view, "La password deve avere almeno 8 caratteri");
	    }

	  }

	  private boolean check(String password, String repeatPassword) {
		  if(password.isEmpty() || repeatPassword.isEmpty()) {
			  return false;
		  } else if(!password.equals(repeatPassword)) {
			  return false;
		  } else
		  return true;
	  }

	
	}