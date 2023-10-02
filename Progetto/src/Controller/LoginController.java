package Controller;


import java.sql.SQLException;

import javax.swing.*;


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
    	int id_c;
        int id_l;
    	
    	try {
            Gestione_Dao dao = new Gestione_Dao();
            AcController a = new AcController();
            User u= new User(null, null, null, null, null, null, null, null, 0, null, null, null);
            
            int id_tipo = dao.Ottieni_Tipo(username);
            id_c =dao.Ottieni_User(username);	////
            id_l = dao.Ottieni_Dip(dao.Ottieni_User(username));	/////
            
            boolean loggedIn = dao.login(username, password);
            u.login(username, password, id_tipo);
            a.memorizza(u);
            
            if (loggedIn) {
        
            	JOptionPane.showMessageDialog(null, "Accesso effettuato con successo!");
                view.dispose();
                if(id_tipo == 1) {
                	
                	DipGUI dipView = new DipGUI();
                	
                	JLabel lblDip = new JLabel();
                	lblDip.setText(String.valueOf(id_l));
                	lblDip.setBounds(800, 5, 30, 20);
                	dipView.contentPane.add(lblDip);
                	dipView.setVisible(true);            
                	
                } else if (id_tipo == 2) {
                	ClienteGUI clView = new ClienteGUI();
                	JLabel lblCl = new JLabel();
                	lblCl.setText(String.valueOf(id_c));
                	lblCl.setBounds(788, 5, 50, 20);
                	clView.contentPane.add(lblCl);
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
    	
 
    
    