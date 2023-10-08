package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class BenvenutoController implements ActionListener{
	
	private Benvenuto_Form view;

	public BenvenutoController(Benvenuto_Form view) {
		
		this.view = view;
		
		//view.btnC.addActionListener(this);
		view.getBtnD().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==view.getBtnC()) {
			
			
			
		}else if (e.getSource()==view.getBtnD()) {
			view.dispose();
			Login_Form view  = new Login_Form();
			User model = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
			LogController controlle = new LogController(model, view);
			
		}
		
	}
	
	
	
	

}
