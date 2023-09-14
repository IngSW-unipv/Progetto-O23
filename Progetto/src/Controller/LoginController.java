package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Model.User;
import View.Benvenuto_Form;
import View.Home_Form;
import View.Login_Form;

public class LoginController {
    private final Login_Form view;
    private final User model;

    public LoginController(Login_Form view, User model) {
        this.view = view;
        this.model = model;
        
// VISTO CHE NON VA DI LA LA COMMENTO
        // Aggiungi un listener al pulsante "LoginButton" nella vista
      //  view.setLoginListener(new LoginListener());
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
                e1.printStackTrace();
            }

            // QUI CI SARà LA HOME DELL'UTENTE
            if (esito) {
                Home_Form welcomeForm = new Home_Form();
                welcomeForm.setVisible(true);
                view.dispose();
                System.out.println("Accesso effettuato con successo!");
            } else {
                System.out.println("Nome utente o password errati!");
            }
            
        }
    }
}













/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Model.User;
import View.Benvenuto_Form;
import View.Login_Form;


public class LoginController {
    private final Login_Form view;
    private final User model;

    public LoginController(Login_Form view, User model) {
        this.view = view;
        this.model = model;
        view.setLoginListener(new LoginListener());
    }

    // Listener per il pulsante "Accedi"
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            // Invoca il metodo "login" del modello passando i dati di login inseriti dall'utente
            boolean esito = false;
            try {
                esito = model.login(username, password);
                System.out.println(model.toString()); //controllo parametri accesso
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            // Aggiorna la vista in base al risultato del login
            if (esito) {
                Benvenuto_Form welcomeForm = new Benvenuto_Form();
                welcomeForm.setVisible(true);
                view.dispose();
                System.out.println("Accesso effettuato con successo!");
            } else {
                System.out.println("Nome utente o password errati!");
            }
        }
    }
}
*/