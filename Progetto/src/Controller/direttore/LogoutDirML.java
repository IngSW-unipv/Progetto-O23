package Controller.direttore;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import Model.direttore.Direttore;
import View.Benvenuto_Form;


public class LogoutDirML implements MouseListener {

	private Direttore model;
	private JOptionPane view;

	public LogoutDirML(JOptionPane view, Direttore model) {
		
		this.view = view;
		this.model = model;
		
	}

	public void actionPerformed(MouseEvent e) {
		
			
						
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Benvenuto_Form ben = new Benvenuto_Form();
		model.logout(model.getLogin());
		ben.setVisible(true);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}