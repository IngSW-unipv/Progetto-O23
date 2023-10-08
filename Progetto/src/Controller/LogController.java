package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Model.*;
import View.*;
import dao.Gestione_Dao;

public class LogController implements ActionListener {
	
	private User model;
	private Login_Form view;
	
	
	public LogController(User model, Login_Form view) {
		this.model = model;
		this.view = view;
		
		view.btnAccedi.addActionListener(this);//azione bottone login 
		//view.btnPsw.addActionListener((ActionListener) this); azione bottone password 
		view.btnBack.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.btnAccedi) {
			Gestione_Dao dao = new Gestione_Dao();
			
			try {
				model.login(view.getUsername(), view.getPassword(), dao.Ottieni_Tipo(view.getUsername()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}else if(e.getSource()==view.btnBack) {
				
		           
				
			} else if(e.getSource()==view.btnPsw){
				
				
			}

		
	}
	
	
	

}
