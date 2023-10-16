package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.*;
import View.*;
import dao.Gestione_Dao;

public class LogController implements ActionListener {
	
	private Login_Form view;
	private JTextField username;
	private JPasswordField password;
	private int id_tipo;
	
	
	public LogController(Login_Form view,JTextField username,JPasswordField password) {
		
		this.view = view;
		this.username=username;
		this.password=password;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		User model = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
		
		if(e.getSource()==view.btnAccedi) {
			Gestione_Dao dao = new Gestione_Dao();
			int id_c=0;
			int id_l=0;
			  
			////
	   
			try {

				id_tipo=dao.Ottieni_Tipo(view.getUsername());
				model.login(this.username.getText(),this.password.getText(),id_tipo);
				
				if(model.getLogin()==false) {
					
					view.dispose();
					Login_Form view  = new Login_Form();
					
				}else if(model.getId_tipo()==1) {
					
					view.dispose();
					Dipendenti dip=new Dipendenti(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0);
					dip.login(this.username.getText(),this.password.getText(),id_tipo);
					id_l = dao.Ottieni_Dip(dao.Ottieni_User(dip.getUsername()));
					DipGUI view2 = new DipGUI(id_l, dip);
					view.dispose();
					
					
				}	else if (model.getId_tipo()==2) {
					
					view.dispose();
					Cliente cli = new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
					cli.login(this.username.getText(),this.password.getText(),id_tipo);
					id_c = dao.Ottieni_User(cli.getUsername());
					ClienteGUI view1 = new ClienteGUI(id_c,cli);
					
					
				}
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			
			
			view.dispose();
			
			
			
			}else if(e.getSource()==view.btnPsw){
				
				
				
			}

		
	}


	
	

}
