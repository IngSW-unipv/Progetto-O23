package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

public class AccountCl extends JFrame {
	public JTextField UsField;
	private JTextField NoField;
	private JTextField CoField;
	private JTextField EmField;
	private JTextField CfField;
	private JTextField NumField;
	private JTextField NazField;
	private JTextField PrField;
	private JTextField CiField;
	private JTextField ViField;

/**
* Create the panel.
*/
public AccountCl() {
	setBounds(258, 11, 576, 520);
	setVisible(true);
	getContentPane().setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(new Color(104, 202, 104));
	panel.setBounds(7, 35, 562, 450);
	getContentPane().add(panel);
	panel.setLayout(null);
	JLabel lblUs = new JLabel("Username");
	lblUs.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblUs.setBounds(10, 25, 80, 20);
	panel.add(lblUs);
	JLabel lblNome = new JLabel("Nome");
	lblNome.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblNome.setBounds(10, 62, 50, 20);
	panel.add(lblNome);
	JLabel lblCo = new JLabel("Cognome");
	lblCo.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblCo.setBounds(10, 100, 80, 23);
	panel.add(lblCo);
	JLabel lblCf = new JLabel("Codice Fiscale");
	lblCf.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblCf.setBounds(10, 177, 120, 20);
	panel.add(lblCf);
	JLabel lblEm = new JLabel("Email");
	lblEm.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblEm.setBounds(10, 138, 50, 20);
	panel.add(lblEm);
	JLabel lblNum = new JLabel("Numero Telefono");
	lblNum.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblNum.setBounds(10, 219, 140, 20);
	panel.add(lblNum);
	JLabel lblCi = new JLabel("Citt\u00E0");
	lblCi.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblCi.setBounds(10, 334, 50, 20);
	panel.add(lblCi);
	JLabel lblNaz = new JLabel("Nazione");
	lblNaz.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblNaz.setBounds(10, 258, 70, 20);
	panel.add(lblNaz);
	JLabel lblV = new JLabel("Via");
	lblV.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblV.setBounds(10, 372, 30, 20);
	panel.add(lblV);
	JLabel lblPr = new JLabel("Provincia");
	lblPr.setFont(new Font("Thonburi", Font.PLAIN, 16));
	lblPr.setBounds(10, 294, 70, 20);
	panel.add(lblPr);
	UsField = new JTextField();
	UsField.setEditable(false);
	UsField.setBounds(150, 22, 120, 30);
	panel.add(UsField);
	UsField.setColumns(10);
	NoField = new JTextField();
	NoField.setEditable(false);
	NoField.setColumns(10);
	NoField.setBounds(150, 59, 120, 30);
	panel.add(NoField);
	CoField = new JTextField();
	CoField.setEditable(false);
	CoField.setColumns(10);
	CoField.setBounds(150, 98, 120, 30);
	panel.add(CoField);
	EmField = new JTextField();
	EmField.setEditable(false);
	EmField.setColumns(10);
	EmField.setBounds(150, 135, 120, 30);
	panel.add(EmField);
	CfField = new JTextField();
	CfField.setEditable(false);
	CfField.setColumns(10);
	CfField.setBounds(150, 174, 120, 30);
	panel.add(CfField);
	NumField = new JTextField();
	NumField.setEditable(false);
	NumField.setColumns(10);
	NumField.setBounds(150, 216, 120, 30);
	panel.add(NumField);
	NazField = new JTextField();
	NazField.setEditable(false);
	NazField.setColumns(10);
	NazField.setBounds(150, 255, 120, 30);
	panel.add(NazField);
	PrField = new JTextField();
	PrField.setEditable(false);
	PrField.setColumns(10);
	PrField.setBounds(150, 289, 120, 30);
	panel.add(PrField);
	CiField = new JTextField();
	CiField.setEditable(false);
	CiField.setColumns(10);
	CiField.setBounds(150, 331, 120, 30);
	panel.add(CiField);
	ViField = new JTextField();
	ViField.setEditable(false);
	ViField.setColumns(10);
	ViField.setBounds(150, 369, 120, 30);
	panel.add(ViField);
	JLabel lblNewLabel = new JLabel("Account");
	lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
	lblNewLabel.setBounds(256, 8, 68, 21);
	getContentPane().add(lblNewLabel);
	setVisible(true);
	JButton btnNewButton = new JButton("Torna indietro");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ClienteGUI cl = new ClienteGUI();
			cl.setVisible(true);
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btnNewButton.setBounds(134, 411, 156, 23);
	panel.add(btnNewButton);

}
}
