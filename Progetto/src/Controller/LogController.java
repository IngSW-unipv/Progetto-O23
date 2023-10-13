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
		view.btnPsw.addActionListener(this); //azione bottone password 
		view.btnBack.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.btnAccedi) {
			Gestione_Dao dao = new Gestione_Dao();
			int id_c=0;
			int id_l=0;
			  
			////
	          
			
			try {
				
				model.login(view.getUsername(), view.getPassword(), dao.Ottieni_Tipo(view.getUsername()));
				if(model.getId_tipo()==1) {
					
					view.dispose();
					Dipendenti dip=new Dipendenti(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0);
					dip.login(view.getUsername(), view.getPassword(), dao.Ottieni_Tipo(view.getUsername()));
					id_l = dao.Ottieni_Dip(dao.Ottieni_User(dip.getUsername()));
					DipGUI view2 = new DipGUI(id_l, dip);
					DipGuiController controller2 =new DipGuiController(view2,dip);
					view.dispose();
					
					
				}	else if (model.getId_tipo()==2) {
					
					view.dispose();
					Cliente cli = new Cliente(null, null, null, null, null, null, null, id_l, null, null, null, null, id_l);
					cli.login(view.getUsername(), view.getPassword(), dao.Ottieni_Tipo(view.getUsername()));
					id_c = dao.Ottieni_User(cli.getUsername());
					ClienteGUI view1 = new ClienteGUI(id_c,cli);
					ClienteGUIController controller1 = new ClienteGUIController(view1,cli);
					
				}
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			
			
			view.dispose();
			
			
			
			}else if(e.getSource()==view.btnBack) {
				
				Benvenuto_Form view1 = new Benvenuto_Form();
				BenvenutoController controller = new BenvenutoController(view1);
		           
				
			} else if(e.getSource()==view.btnPsw){
				
				
				
			}

		
	}
	
	
	

}
