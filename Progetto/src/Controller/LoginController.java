package Controller;


import java.sql.SQLException;
import javax.swing.JOptionPane;

import Model.User;
import View.ClienteGUI;
import View.DipGUI;
import View.Login_Form;
import dao.Gestione_Dao;

public class LoginController {
    private final Login_Form view;
    

    public LoginController(Login_Form view) {
        this.view = view;
    }
    
    public void handleLogin() {
    	String username = view.getUsername();
    	String password = view.getPassword();
    	
    	
    	try {
            Gestione_Dao dao = new Gestione_Dao();
            AcController a = new AcController();
            User u= new User(null, null, null, null, null, null, null, null, 0, null, null, null);
            
            int id_tipo = dao.Ottieni_Tipo(username);
            
            boolean loggedIn = dao.login(username, password);
            u.login(username, password, id_tipo);
            
            if (loggedIn) {
            	a.memorizza(u);
                System.out.println(u.toString());
                
            	JOptionPane.showMessageDialog(null, "Accesso effettuato con successo!");
                view.dispose();
                if(id_tipo == 1) {
               
                	DipGUI dipView = new DipGUI();
                	dipView.setVisible(true);            
                	
                } else if (id_tipo == 2) {
                	ClienteGUI clView = new ClienteGUI();
                	clView.setVisible(true);
                }
                 
            } else {
                JOptionPane.showMessageDialog(null, "Username o password non validi.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'accesso: " + ex.getMessage());
        }
    }
    
   
    	
 }
    
    
    
    
    