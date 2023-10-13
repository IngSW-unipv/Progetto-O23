package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;

public class DatiDipController implements ActionListener{

	private AccountDip view;
	private Dipendenti model;
	
	public DatiDipController(AccountDip view, Dipendenti model) {
		
		this.view=view;
		this.model = model;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		
	}
	
	
	
}
