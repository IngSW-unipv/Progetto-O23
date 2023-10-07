package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Model.*;
import View.Home_Form;
import View.Registration_Form;

public class RegistrazioneController implements ActionListener {
	
	private Registration_Form view;
	private Cliente model;
	
	
	
	
	public RegistrazioneController(Registration_Form view, Cliente model) {
		this.view = view;
		this.model = model;
		
		view.getBtnReg().addActionListener(this);
		//view.getBtnBack().addActionListener(this);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==view.btnReg) {
			
			
		
		model=new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
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
		
		}else  {
			Home_Form regForm1 =new Home_Form();
	            regForm1.setVisible(true);
	           
			
		}
	}
	
	

}
