package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import Model.direttore.DirettoreDAO;
import View.direttore.RegistraDipGUI;

public class RegDipAL implements ActionListener {
	private RegistraDipGUI view;
	private DirettoreDAO dirD;

	public RegDipAL(DirettoreDAO dirD, RegistraDipGUI view) {
		this.dirD= dirD;
		this.view=view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==view.getBtnReg()) {
			if(!validaCampi()) {
				return;
			}
			System.out.println("entro nel controller");
			
			Calendar cal = view.getDateChooser().getCalendar();
			
			int anno = cal.get(cal.YEAR);
			int mese = cal.get(cal.MONTH)+1;
			int giorno= cal.get(cal.DAY_OF_MONTH);
			java.sql.Date data = java.sql.Date.valueOf(anno+"-"+mese+"-"+giorno); 
			
			int cap = Integer.valueOf(view.getCap().getText());
			int stipendio= Integer.valueOf(view.getStipendio().getText());
			//int cell= Integer.valueOf(view.getCell().getText());
			try {
				
				System.out.println("entro nel dao con " +view.getCf().getText()+ view.getNome().getText()+ view.getCognome().getText()+ data + view.getCell().getText()+ view.getVia().getText()+ 
						view.getCitta().getText()+ view.getProvincia().getText()+ cap+ view.getEmail().getText()+ view.getUsername().getText()+ view.getPassword().getText()+ 
						view.getRuolo().getText()+ stipendio);
				dirD.dip_Register(view.getCf().getText(), view.getNome().getText(), view.getCognome().getText(), data , view.getCell().getText(), view.getVia().getText(), 
						view.getCitta().getText(), view.getProvincia().getText(), cap, view.getEmail().getText(), view.getUsername().getText(), view.getPassword().getText(), view.getRuolo().getText(), stipendio);
				
				
				
			} catch (SQLException | NoSuchAlgorithmException e1) {
				
				e1.printStackTrace();
				System.out.println("esco nel controller");
			}
			
		}

	}
	
private boolean validaCampi() {
		
		// controllo che i campi non siano vuoti
		if(view.getCf().getText().isEmpty() || view.getNome().getText().isEmpty() || view.getCognome().getText().isEmpty() || view.getCell().getText().isEmpty() ||
				view.getVia().getText().isEmpty() || view.getCitta().getText().isEmpty() || view.getProvincia().getText().isEmpty() || view.getCap().getText().isEmpty()
				|| view.getCap().getText().isEmpty() || view.getEmail().getText().isEmpty() || view.getUsername().getText().isEmpty() ||view.getPassword().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Errore, nessun campo può essere vuoto");
			return false;
		}
		
		return true;
		
	}


}