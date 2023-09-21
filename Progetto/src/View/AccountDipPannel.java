package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

public class AccountDipPannel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the panel.
	 */
	public AccountDipPannel() {
		
		setBounds(258, 11, 576, 520);
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(104, 202, 104));
		panel.setBounds(10, 43, 556, 447);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 29, 70, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 66, 70, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cognome");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(10, 103, 70, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Codice Fiscale");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(10, 177, 90, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Email");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(10, 138, 70, 14);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Numero Telefono");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_4.setBounds(10, 219, 100, 14);
		panel.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Citt\u00E0");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_5.setBounds(10, 334, 66, 14);
		panel.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Nazione");
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_6.setBounds(10, 258, 66, 14);
		panel.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Via");
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_7.setBounds(10, 372, 66, 14);
		panel.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 296, 66, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(141, 27, 108, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(141, 64, 108, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(141, 101, 108, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(141, 136, 108, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(141, 175, 108, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(141, 217, 108, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(141, 256, 108, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(141, 294, 108, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(141, 332, 108, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(141, 370, 108, 20);
		panel.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setBounds(264, 11, 56, 21);
		add(lblNewLabel);
		setVisible(true);
		
		
		

	}
}
