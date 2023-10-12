package Controller;

import java.awt.event.ActionEvent;
import javax.swing.*;

import Model.direttore.DirettoreDAO;
import View.LavoratoriGUI;
import View.StanzeGUI;
import dao.Gestione_Dao;

public class DirController {
	
	private DirettoreDAO dao;
	private LavoratoriGUI frame;
	private StanzeGUI frame1;
	
	public DirController(DirettoreDAO dao, LavoratoriGUI frame){
		this.dao=dao;
		this.frame=frame;
		
	}
	
	public DirController(DirettoreDAO dao, StanzeGUI frame1){
		this.dao=dao;
		this.frame1=frame1;
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		dao.caricaTurni(frame.table);
	}
	
	public void actionPerformed1(ActionEvent e1) {
		
		dao.caricaStanze(frame1.table);
	}
	
	
}