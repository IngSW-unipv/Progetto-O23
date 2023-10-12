package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;


import Model.*;
import View.*;


public class DipGuiController implements ActionListener{
	
	private  DipGUI view;
	private Dipendenti model;

	public DipGuiController(DipGUI view) {
        this.view = view;
        
        //view.getLblOut().addAncestorListener((AncestorListener) this);
        
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view.getLblOut()) {
			model.logout(model.getLogin());
			view.dispose();
			Benvenuto_Form view1 = new Benvenuto_Form();
			BenvenutoController controller = new BenvenutoController(view1);
		}
	
	
	}


}
	
	


