package Controller.logout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.Cliente;
import View.Benvenuto_Form;
import View.cliente.ClienteGUI;
import View.dipendente.DipGUI;

public class LogOutCliController{
	
	private Cliente model;
	private JOptionPane view;
	private int id;
	
	
	
	public LogOutCliController(JOptionPane view,Cliente model,int id) {
		
		this.view = view;
		this.model = model;
		this.id = id;
		
	}


	
	public void actionPerformed(MouseEvent e) {
		
		if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
			Benvenuto_Form ben = new Benvenuto_Form();
			model.logout(model.getLogin());
			ben.setVisible(true);
		
		}else {
			
			ClienteGUI cli =new ClienteGUI(id, model);
			
		}
		
	}
	

}