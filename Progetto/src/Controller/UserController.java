package controller;

import java.awt.event.ActionListener;

import Model.User;
import View.Login_Success_GUI;

public class UserController {
	  private User user;
	  private Login_Success_GUI form;

	    // Costruttore del controllore
	    public UserController(User user, Login_Success_GUI form) {
	        this.user = user;
	        this.form = form;

	        // Aggiungi gli ActionListener ai bottoni della finestra dell'interfaccia utente
	        form.getLogOut().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Chiama il metodo logout() della classe User
	                User.logout();

	                // Chiudi la finestra dell'interfaccia utente corrente
	                form.dispose();
	            }
	        });

	        // Aggiorna l'interfaccia utente con le informazioni dell'utente corrente
	        form.setUsernameLabel(user.getUsername());
	        form.setOtherUserInfoLabel(user.getOtherUserInfo());
	    }
	}

}
