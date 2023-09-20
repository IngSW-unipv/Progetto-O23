package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountUtPannel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AccountUtPannel() {
		
		setBounds(258, 11, 576, 501);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);

	}
	

}
