package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;


import Model.*;
import View.*;


public class DipGuiController implements ActionListener{
	
	private  DipGUI view;
	private Dipendenti model;
	
	

	public DipGuiController(DipGUI view,Dipendenti model) {
        this.view = view;
        this.model= model;
        
        view.getBtnLogout().addActionListener(this);;
        
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view.getBtnLogout()) {
			view.dispose();
			model.logout(model.getLogin());
			Benvenuto_Form view1 = new Benvenuto_Form();
			BenvenutoController controller = new BenvenutoController(view1);
			
		}
	
	
	}


}
	
	


