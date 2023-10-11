package View;
import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.ClientController;
import Controller.LoginController;
import Model.User;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;



public class PrenotaGUI extends JFrame {

	private JTable table;
	private static JLabel lblId;
	private static int id;;
	private JTextField textField;
	private JTextField textField_1;
	private User user;;
	
	private ClientController controller; // aggiunta del controller

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					PrenotaGUI frame = new PrenotaGUI(lblId, id);
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

	public PrenotaGUI(JLabel lblId, int id) {
		
		controller = new ClientController(this); 
		
		
		PrenotaGUI.lblId=lblId;
		PrenotaGUI.id=id;

		setBackground(new Color(240, 240, 240));


		setBounds(258, 11, 576, 520);

		getContentPane().setLayout(null);

		JLabel lblPr = new JLabel("Prenotazione");

		lblPr.setBounds(235, 8, 104, 21);

		lblPr.setFont(new Font("Yuppy TC", Font.PLAIN, 18));

		getContentPane().add(lblPr);


		JPanel panel = new JPanel();

		panel.setBackground(new Color(102, 204, 102));

		panel.setBounds(7, 35, 562, 450);

		getContentPane().add(panel);

		panel.setLayout(null);


		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(11, 36, 540, 120);

		panel.add(scrollPane);


		table = new JTable();

		scrollPane.setViewportView(table);
		
		

		table.setModel(new DefaultTableModel(

				new Object[][] {

					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},

				new String[] {
						"Numero Stanza", "Tipo", "Piano", "Letti", "Prezzo"

				}

				));


		JLabel lblSt = new JLabel("Stanze Prenotabili");

		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));

		lblSt.setBounds(211, 9, 144, 15);

		panel.add(lblSt);


		JLabel lbl1 = new JLabel("data check-in desiderata");

		lbl1.setFont(new Font("Thonburi", Font.PLAIN, 16));

		lbl1.setBackground(Color.WHITE);

		lbl1.setBounds(11, 188, 259, 32);

		panel.add(lbl1);




		JButton btnConf = new JButton("Prenota");

		btnConf.setFont(new Font("Thonburi", Font.PLAIN, 16));

		btnConf.setBounds(22, 382, 103, 32);

		panel.add(btnConf);


		JButton btnTornaIndietro = new JButton("Torna indietro");

		btnTornaIndietro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ClienteGUI cl = new ClienteGUI(id, user);
				cl.setLbl(lblId);
				cl.setVisible(true);
				dispose();

			}
		});

		btnTornaIndietro.setFont(new Font("Thonburi", Font.PLAIN, 16));

		btnTornaIndietro.setBounds(211, 412, 144, 32);

		panel.add(btnTornaIndietro);
		
		JLabel lbl1_1 = new JLabel("data check-out desiderata");
		lbl1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl1_1.setBackground(Color.WHITE);
		lbl1_1.setBounds(11, 251, 259, 32);
		panel.add(lbl1_1);
		
		JButton btnConf_1 = new JButton("visualizza disponibilità"); //bottone disponibilità
		btnConf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.RecuperaStanze();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConf_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnConf_1.setBounds(22, 327, 196, 32);
		panel.add(btnConf_1);
		
		textField = new JTextField(); //data checkin
		textField.setBounds(200, 193, 121, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(); //data checkout
		textField_1.setColumns(10);
		textField_1.setBounds(211, 256, 121, 29);
		panel.add(textField_1);
	}
	//questi due metodi mi servono per portare le date nel controller
	public String getDateCheckin() {
		return textField.getText();
	}
	
	public String getDateCheckout() {
		return textField_1.getText();
	}
	//fatto
}

