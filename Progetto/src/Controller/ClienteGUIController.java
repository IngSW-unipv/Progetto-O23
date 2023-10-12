package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.*;
import View.ClienteGUI;
import dao.Gestione_Dao;

public class ClienteGUIController implements ActionListener{
	
	private final ClienteGUI view;
	private Cliente model;

	public ClienteGUIController(ClienteGUI view) {
        this.view = view;
        
        
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
	
	
	}


}
