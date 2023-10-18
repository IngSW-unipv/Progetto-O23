package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.direttore.DipendentiDAO;
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
			System.out.println("id_l= " +id_l);
			System.out.println("stipendio= " +stipendio);
			dip.modificaDip(id_l, stipendio, ruolo);
		}
	}

}
