package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ImieiTurniPannel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ImieiTurniPannel() {
		
		setBounds(258, 11, 576, 501);
		
		
		JLabel lblNewLabel = new JLabel("I tuoi turni");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);
		

	}

}
