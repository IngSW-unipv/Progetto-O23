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
	private String username;
	private String password;
	private int id_tipo;
	
	
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
					username=view.getUsername();
					password= view.getPassword();
					id_tipo=dao.Ottieni_Tipo(view.getUsername());
				
				model.login(username, password,id_tipo);
				if(model.getId_tipo()==1) {
					
					view.dispose();
					Dipendenti dip=new Dipendenti(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0);
					dip.login(username, password,id_tipo);
					id_l = dao.Ottieni_Dip(dao.Ottieni_User(dip.getUsername()));
					DipGUI view2 = new DipGUI(id_l, dip);
					DipGuiController controller2 =new DipGuiController(view2,dip,username,password,id_tipo);
					view.dispose();
					
					
				}	else if (model.getId_tipo()==2) {
					
					view.dispose();
					Cliente cli = new Cliente(null, null, null, null, null, null, null, id_l, null, null, null, null, id_l);
					cli.login(username, password,id_tipo);
					id_c = dao.Ottieni_User(cli.getUsername());
					ClienteGUI view1 = new ClienteGUI(id_c,cli);
					ClienteGUIController controller1 = new ClienteGUIController(view1,cli,username, password,id_tipo);
					
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

	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
	

}
