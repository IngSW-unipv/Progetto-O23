package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;

import Controller.AcController;
import Controller.LoginController;
import Model.User;
import dao.Gestione_Dao;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AccountDip extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField UsField;
	public JTextField NoField;
	public JTextField CoField;
	public JTextField EmField;
	public JTextField CfField;
	public JTextField NumField;
	
	private static JLabel lbl;
	private static int id;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountDip frame = new AccountDip(lbl, id);
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
	public AccountDip(JLabel lbl, int id)  {
		AccountDip.lbl = lbl;
		AccountDip.id = id;
		
		setBounds(258, 11, 576, 520);
		setVisible(true);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(104, 202, 104));
		panel.setBounds(7, 35, 562, 450);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
		lblNewLabel.setBounds(256, 8, 68, 21);
		getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("Torna indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DipGUI dip = new DipGUI(id);
				dip.setLbl(lbl);
				AccountDip.this.dispose();
				dip.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 416, 156, 23);
		panel.add(btnNewButton);
		
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
		UsField.setBounds(150, 22, 200, 30);
		panel.add(UsField);
		
		UsField.setColumns(10);
		NoField = new JTextField();
		NoField.setEditable(false);
		NoField.setColumns(10);
		NoField.setBounds(150, 59, 200, 30);
		panel.add(NoField);
		
		CoField = new JTextField();
		CoField.setEditable(false);
		CoField.setColumns(10);
		CoField.setBounds(150, 98, 200, 30);
		panel.add(CoField);
		
		EmField = new JTextField();
		EmField.setEditable(false);
		EmField.setColumns(10);
		EmField.setBounds(150, 135, 200, 30);
		panel.add(EmField);
		
		CfField = new JTextField();
		CfField.setEditable(false);
		CfField.setColumns(10);
		CfField.setBounds(150, 174, 200, 30);
		panel.add(CfField);
		
		NumField = new JTextField();
		NumField.setEditable(false);
		NumField.setColumns(10);
		NumField.setBounds(150, 216, 200, 30);
		panel.add(NumField);
		
		setVisible(true);
		

	}
}
