package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.dipendente.DipendentiDAO;
import Model.direttore.Direttore;
import View.direttore.LavoratoriPanel;

public class GestioneLavAL implements ActionListener {
	private DipendentiDAO dip;
	private LavoratoriPanel view;
	private Direttore dir;

	public GestioneLavAL(DipendentiDAO dip, Direttore dir, LavoratoriPanel view) {
		this.dip=dip;
		this.view=view;
		this.dir=dir;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnAg()) {
		
			dip.caricaLav(view.getTable());
			
		} else if(e.getSource()==view.getBtnMo()) {
			//prendo da field i campi che mi interessano con gli opportuni cast 
			int id_l = view.getIdL();
			int stipendio=Integer.valueOf(view.getStipendio());			
			String ruolo=view.getRuolo();

			dir.modificaDi(id_l, stipendio, ruolo);
			dip.caricaLav(view.getTable());
			
		} else if(e.getSource()==view.getBtnCancella()) {
			int id_l = view.getIdL();
			dir.licenziaDi(id_l);
			dip.caricaLav(view.getTable());
		}
	}

}
