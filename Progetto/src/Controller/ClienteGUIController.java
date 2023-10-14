package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.*;
import View.AccountCl;
import View.Benvenuto_Form;
import View.ClienteGUI;
import dao.Gestione_Dao;

public class ClienteGUIController implements ActionListener{
	
	private final ClienteGUI view;
	private Cliente model;
	private String username;
	private String password;
	private int id_tipo;

	public ClienteGUIController(ClienteGUI view,Cliente model,String username,String password,int id_tipo) {
        this.view = view;
        this.model = model;
        this.username = username;
        this.password = password;
        this.id_tipo = id_tipo;
        
        
        view.getBtnLogout().addActionListener(this);
        view.getBtnIMieiDati().addActionListener(this);
        
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view.getBtnLogout()) {
			view.dispose();
			model.logout(model.getLogin());
			Benvenuto_Form view1 = new Benvenuto_Form();
			BenvenutoController controller = new BenvenutoController(view1);
			
		}else if(e.getSource()==view.getBtnIMieiDati()) {
			view.dispose();
			AccountCl view1 = new AccountCl(view.getLbl(),view.getWidth(),model); 
			DatiCliController controller = new DatiCliController(view1, model, view, password, password, id_tipo);
			
			
		}
	
	
	
	}


	public Cliente getModel() {
		return model;
	}


	public void setModel(Cliente model) {
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
