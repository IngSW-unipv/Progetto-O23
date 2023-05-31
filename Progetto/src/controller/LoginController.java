package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import interfacciaGrafica.Login_Form;
import utente.User;

public class LoginController {
    private Login_Form view;
    private User model;

    public LoginController(Login_Form view, User model) {
        this.view = view;
        this.model = model;

        // Aggiungi un listener al pulsante "LoginButton" nella vista
        view.addLoginListener(new LoginListener());
    }

    // Listener per il pulsante "LoginButton"
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            // Invoca il metodo "login" del modello passando i dati di login inseriti dall'utente
            boolean esito = false;
			try {
				esito = model.login(username, password);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

            // Aggiorna la vista in base al risultato del login
            if (esito) {
                System.out.println("Accesso effettuato con successo!");

            } else {
            	System.out.println("Nome utente o password errati!");
            }
        }
    }
}