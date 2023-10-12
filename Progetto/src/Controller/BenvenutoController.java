package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class BenvenutoController implements ActionListener{
	
	private Benvenuto_Form view;

	public BenvenutoController(Benvenuto_Form view) {
		
		this.view = view;
		
		view.getBtnC().addActionListener(this);
		view.getBtnD().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==view.getBtnD()) {
			Login_Form view  = new Login_Form();
			Dipendenti model = new Dipendenti(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0);
			LogController controller = new LogController(model, view);
			view.dispose();
			
			
		}else if (e.getSource()==view.getBtnC()) {
			
			view= new Benvenuto_Form();
			Login_Form view  = new Login_Form();
			Cliente model1 = new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
			LogController controller = new LogController(model1, view);
			view.dispose();
			
		}
		
	}
	
	
	
	

}
