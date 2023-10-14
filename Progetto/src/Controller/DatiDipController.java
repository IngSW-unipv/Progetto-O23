package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class DatiDipController implements ActionListener{

	private AccountDip view;
	private DipGUI view1;
	private Dipendenti model;
	private String username;
	private String password;
	private int id_tipo;
	
	public DatiDipController(AccountDip view,DipGUI view1, Dipendenti model,String username,String password,int id_tipo) {
		
		this.view=view;
		this.model = model;
		this.view1=view1;
		this.username = username;
	    this.password = password;
	    this.id_tipo = id_tipo;
	    
	    view.getBtnIndierto().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnIndierto()) {
			view1.setVisible(true);
			DipGuiController controller = new DipGuiController(view1, model, username, password, id_tipo);
			view.dispose();
			
			
			}
		
		
	}
	
	
	
}
