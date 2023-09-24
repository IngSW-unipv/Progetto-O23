package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.User;
import View.PswLost_Form;
import dao.Gestione_Dao;

public class PswController {

	  private Gestione_Dao dao;

	  public PswController(Gestione_Dao dao) {
	    this.dao = dao;
	  }

	  public void modifyPassword(User user, PswLost_Form view) throws SQLException {

	    // Recuperare username da view

	    char[] password = view.getPasswordField();
	    char[] repeatPassword = view.getPasswordField_1();

	    if(passwordEquals(password, repeatPassword)) {

	      String newPassword = String.valueOf(password);
	      
	      //dao.modificaDati(user, "psw", newPassword);

	      JOptionPane.showMessageDialog(view, "Password modificata");

	    } else {
	      JOptionPane.showMessageDialog(view, "Password non coincidono");
	    }

	  }

	  private boolean passwordEquals(char[] p1, char[] p2) {
	    // Confronto password
		  if(p1 == null || p2 == null) {
			    return false;
			  }

			  if(p1.length != p2.length) {
			    return false;
			  }

			  for(int i = 0; i < p1.length; i++) {
			    if(p1[i] != p2[i]) {
			      return false;
			    }
			  }

			  return true;
	  }

	}