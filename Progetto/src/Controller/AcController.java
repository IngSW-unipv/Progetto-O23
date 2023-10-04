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
	
	}
	
	
