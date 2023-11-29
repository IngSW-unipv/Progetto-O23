package Controller.registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.*;
import View.Benvenuto_Form;
import View.Home_Form;
import View.Registration_Form;
import dao.Gestione_Dao;

public class RegistrazioneController implements ActionListener {
	
	private Registration_Form view;
	
	private JTextField nome;
	private JTextField cognome;
	private JTextField cf;
	private JComboBox data;
	private JComboBox mese;
	private JComboBox anno;
	private JTextField email;
	private JTextField cell;
	private JTextField via;
	private JTextField citta;        
	private JTextField provincia;
	private JTextField cap;
	private JTextField username;    
	private JPasswordField password;
	
	private Gestione_Dao dao;
	
	


	public RegistrazioneController(Registration_Form view, JTextField nome, JTextField cognome,
			JTextField cf, JComboBox data, JComboBox mese, JComboBox anno, JTextField email, JTextField cell,
			JTextField via, JTextField citta, JTextField provincia, JTextField cap, JTextField username,
			JPasswordField password) {
		
		this.view = view;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.data = data;
		this.mese = mese;
		this.anno = anno;
		this.email = email;
		this.cell = cell;
		this.via = via;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
		this.username = username;
		this.password = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Cliente c = new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
		
	
		if(e.getSource()==view.btnReg) {
			
			if(!validaCampi()) {
				return;
			}
		String giorno=(String) this.data.getSelectedItem();
		String mese=(String) this.mese.getSelectedItem();
		String anno=(String) this.anno.getSelectedItem();
		
		
		String data=anno+"-"+mese+"-"+giorno;
		
		String cap =view.cap.getText();
		
		int cap1=Integer.parseInt(cap);//conversione da stringa a intero
		
		
		try {
			
			c.registrazione(view.cf.getText(), view.nome.getText(), view.cognome.getText(), data , view.cell.getText(), view.via.getText(), view.citta.getText(), view.provincia.getText(), cap1, view.email.getText(), view.username.getText(), view.password.getText());
			view.dispose();
			Benvenuto_Form view2 = new Benvenuto_Form();
			
		} catch (NoSuchAlgorithmException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
	
	


