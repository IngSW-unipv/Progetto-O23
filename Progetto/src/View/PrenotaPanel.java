package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PrenotaPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PrenotaPanel() {
		
		setBounds(258, 11, 576, 501);
		JLabel lblNewLabel = new JLabel("Prenotazione");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);
		

	}

}
