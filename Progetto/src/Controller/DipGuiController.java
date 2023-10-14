package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;


import Model.*;
import View.*;


public class DipGuiController implements ActionListener{
	
	private  DipGUI view;
	private Dipendenti model;
	private String username;
	private String password;
	private int id_tipo;
	
	

	public DipGuiController(DipGUI view,Dipendenti model,String username,String password,int id_tipo) {
        this.view = view;
        this.model= model;
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
			AccountDip view1 = new AccountDip(view.getLbl(),view.getWidth(),model); 
			DatiDipController controller = new DatiDipController(view1,view, model,username,password,id_tipo);
			
			
		}
	
	
	}
	
	


}
	
	


