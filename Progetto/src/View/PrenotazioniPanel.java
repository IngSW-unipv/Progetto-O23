package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrenotazioniPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PrenotazioniPanel() {
		
		setBounds(258, 11, 576, 501);
		JLabel lblNewLabel = new JLabel("Le tue prenotazioni");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);
		

	}

}
