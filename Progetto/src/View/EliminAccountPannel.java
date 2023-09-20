package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EliminAccountPannel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EliminAccountPannel() {
		
		setBounds(258, 11, 576, 501);
		JLabel lblNewLabel = new JLabel("Eliminazione Account");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);
		

	}

}
