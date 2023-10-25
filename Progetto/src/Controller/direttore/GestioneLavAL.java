package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.dipendente.DipendentiDAO;
import View.direttore.LavoratoriGUI;

public class GestioneLavAL implements ActionListener {
	private DipendentiDAO dip;
	private LavoratoriGUI view;

	public GestioneLavAL(DipendentiDAO dip, LavoratoriGUI view) {
		this.dip=dip;
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnAg()) {
		
			dip.caricaLav(view.getTable());
			
		} else if(e.getSource()==view.getBtnMo()) {
			
			int id_l = view.getIdL();
			int stipendio=Integer.valueOf(view.getStipendio());			
			String ruolo=view.getRuolo();

			dip.modificaDip(id_l, stipendio, ruolo);
			JOptionPane.showMessageDialog(null, "Dipendente modificato con successo!");
			dip.caricaLav(view.getTable());
			
		} else if(e.getSource()==view.getBtnCancella()) {
			int id_l = view.getIdL();
			dip.Licenzia(id_l);
			JOptionPane.showMessageDialog(null, "Riga eliminata con successo!");
			dip.caricaLav(view.getTable());
		}
	}

}
