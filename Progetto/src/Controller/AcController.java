package Controller;

import javax.swing.JFrame;

import Model.User;
import View.AccountCl;
import View.AccountDip;
import View.DipGUI;

public class AcController {
	
	private User user;
	private AccountDip view;
	private AccountCl view1;
	private int idCl;
	private int idDip;

	
	public void memorizza(User u) {
		
		System.out.println(u.toString());
		user=u;
		
	}
	
	public void setIdCliente(int id) {
		  idCl = id;
		}

	public int getIdCliente() {
		 return idCl;
		}

	public void setIdDip(int id) {
		  idDip = id;
		}

	public int getIdDip() {
		 return idDip;
		}
	
	public void visualizzaDip() {
		view=new AccountDip();
		view.CfField.setText(user.getCf());
		view.CoField.setText(user.getCognome());
		view.NoField.setText(user.getNome());
		view.EmField.setText(user.getEmail());
		view.UsField.setText(user.getUsername());
		view.NumField.setText(user.getNumTelefono());
		
		view.setVisible(true);
	}
	public void visualizzaCl() {
		view1=new AccountCl();
		view1.CfField.setText(user.getCf());
		view1.CoField.setText(user.getCognome());
		view1.NoField.setText(user.getNome());
		view1.EmField.setText(user.getEmail());
		view1.UsField.setText(user.getUsername());
		view1.NumField.setText(user.getNumTelefono());
		
		view.setVisible(true);
	}
	
}