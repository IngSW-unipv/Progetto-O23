package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class DatiCliController implements ActionListener{
	
	private AccountCl view;
	private ClienteGUI view1;
	private Cliente model;
	private String username;
	private String password;
	private int id_tipo;
	
	
	
	public DatiCliController(AccountCl view, Cliente model,ClienteGUI view1,String username,String password,int id_tipo) {
		
		this.view = view;
		this.model = model;
		this.view1 = view1;
		this.username = username;
	    this.password = password;
	    this.id_tipo = id_tipo;
		
		view.getBtnIndietro().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnIndietro()) {
			
		view1.setVisible(true);
		ClienteGUIController controller = new ClienteGUIController(view1, model, username, password, id_tipo);
		view.dispose();
		
		
		}
		
	}
	
	
	

}
