package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.User;
import View.PswLost_Form;
import dao.Gestione_Dao;

public class PswController {
	  private final PswLost_Form view;
	    
	 
	  public PswController(PswLost_Form view) {
	    this.view = new PswLost_Form();
	  }

	  public void modifyPassword() {

	    // Recuperare username da view
		String user = view.getUsername();
	    char[] password = view.getPasswordField();
	    String repeatPassword = view.GetPasswordConferma();

	    if(passwordEquals(password, repeatPassword)) {

	      String newPassword = String.valueOf(password);
	      
	      //dao.modificaDati(user, "psw", newPassword);

	      JOptionPane.showMessageDialog(view, "Password modificata");

	    } else {
	      JOptionPane.showMessageDialog(view, "Password non coincidono");
	    }

	  }

	  private boolean passwordEquals(char[] p1, String repeatPassword) {
	    // Confronto password
		  if(p1 == null || repeatPassword == null) {
			    return false;
			  }

			  if(p1.length != repeatPassword.length()) {
			    return false;
			  }

			  for(int i = 0; i < p1.length; i++) {
			    if(p1[i] != repeatPassword[i]) {
			      return false;
			    }
			  }

			  return true;
	  }

	
	}