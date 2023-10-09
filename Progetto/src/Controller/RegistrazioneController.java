package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.*;
import View.Home_Form;
import View.Registration_Form;
import dao.Gestione_Dao;

public class RegistrazioneController implements ActionListener {
	
	private Registration_Form view;
	private Cliente model;
	
	private Gestione_Dao dao;
	
	
	
	public RegistrazioneController(Registration_Form view, Cliente model) {
		this.view = view;
		this.model = model;
		
		dao = new Gestione_Dao();
		
		
		
		view.getBtnReg().addActionListener(this);
		view.getBtnBack().addActionListener(this);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==view.btnReg) {
			if(!validaCampi()) {
				return;
			}
		String giorno=(String) view.data.getSelectedItem();
		String mese=(String) view.mese.getSelectedItem();
		String anno=(String) view.anno.getSelectedItem();
		
		
		String data=anno+"-"+mese+"-"+giorno;
		
		String cap =view.cap.getText();
		int cap1=Integer.parseInt(cap);//conversione da stringa a intero
		
		System.out.println(cap1);
		try {
			model.registrazione(view.cf.getText(), view.nome.getText(), view.cognome.getText(), data , view.cell.getText(), view.via.getText(), view.citta.getText(), view.provincia.getText(), cap1, view.email.getText(), view.username.getText(), view.password.getText());
			
		} catch (NoSuchAlgorithmException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		} else if (e.getSource()==view.btnBack) {
			Home_Form regForm1 =new Home_Form();
			view.dispose();
        	regForm1.setVisible(true);
			
			}   
			
		}
	
	private boolean validaCampi() {
		
		// controllo che i campi non siano vuoti
		if(view.cf.getText().isEmpty() || view.nome.getText().isEmpty() || view.cognome.getText().isEmpty() || view.cell.getText().isEmpty() ||
				view.via.getText().isEmpty() || view.citta.getText().isEmpty() || view.provincia.getText().isEmpty() || view.cap.getText().isEmpty()
				|| view.cap.getText().isEmpty() || view.email.getText().isEmpty() || view.username.getText().isEmpty() ||view.password.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Errore, nessun campo può essere vuoto");
			return false;
		}
		
		return true;
		
	}
	
	
}
	
	


