package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;

import Model.*;

public class AccountCl extends JFrame {
	public JTextField UsField;
	public JTextField NoField;
	public JTextField CoField;
	public JTextField EmField;
	public JTextField CfField;
	public JTextField NumField;
	
	private static JLabel lbl;
	private static int id;
	private static Cliente u;
	private JButton btnIndietro;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

				
					AccountCl frame = new AccountCl(lbl, id,u);

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}
	
/**
* Create the panel.
*/
public AccountCl(JLabel lbl, int id,User u) {
	
	AccountCl.lbl=lbl;
	AccountCl.id=id;
	
	setBounds(258, 11, 576, 520);
	setVisible(true);
	getContentPane().setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(new Color(104, 202, 104));
	panel.setBounds(7, 35, 562, 450);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	btnIndietro = new JButton("Torna indietro");
	btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btnIndietro.setBounds(10, 416, 156, 23);
	panel.add(btnIndietro);
	btnIndietro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
		
		ClienteGUI cli = new ClienteGUI(id, (Cliente) u);
	});
	
	JButton btnNewButton_1 = new JButton("Modifica dati");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btnNewButton_1.setBounds(10, 283, 156, 23);
	panel.add(btnNewButton_1);
	
	JLabel lblNewLabel = new JLabel("Account");
	lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
	lblNewLabel.setBounds(256, 8, 68, 21);
	getContentPane().add(lblNewLabel);
	
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
	
	UsField = new JTextField();
	UsField.setEditable(false);
	UsField.setText(u.getUsername());
	UsField.setBounds(150, 22, 200, 30);
	panel.add(UsField);
	
	UsField.setColumns(10);
	NoField = new JTextField();
	NoField.setEditable(false);
	NoField.setText(u.getNome());
	NoField.setColumns(10);
	NoField.setBounds(150, 59, 200, 30);
	panel.add(NoField);
	
	CoField = new JTextField();
	CoField.setEditable(false);
	CoField.setText(u.getCognome());
	CoField.setColumns(10);
	CoField.setBounds(150, 98, 200, 30);
	panel.add(CoField);
	
	EmField = new JTextField();
	EmField.setEditable(false);
	EmField.setText(u.getEmail());
	EmField.setColumns(10);
	EmField.setBounds(150, 135, 200, 30);
	panel.add(EmField);
	
	CfField = new JTextField();
	CfField.setEditable(false);
	CfField.setText(u.getCf());
	CfField.setColumns(10);
	CfField.setBounds(150, 174, 200, 30);
	panel.add(CfField);
	
	NumField = new JTextField();
	NumField.setEditable(false);
	NumField.setText(u.getNumTelefono());
	NumField.setColumns(10);
	NumField.setBounds(150, 216, 200, 30);
	panel.add(NumField);
	
	
	setVisible(true);
	
	}

public JButton getBtnIndietro() {
	return btnIndietro;
}

public void setBtnIndietro(JButton btnIndietro) {
	this.btnIndietro = btnIndietro;
}
	
	


}