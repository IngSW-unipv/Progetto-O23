package View.prenota;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTable;

import Model.Cliente;
import Model.prenotazione.PrenotaDAO;
import View.ClienteGUI;
import javax.swing.JTextField;

import Controller.prenota.PrenotaController;

import javax.swing.JButton;
import javax.swing.JFrame;



public class PrenotaGUI extends JFrame {

	public JTable table_1;
	private static JLabel lblId;
	private static int id;
	private JTextField textField;
	private JTextField textField_1;
	private PrenotaDAO dao;
	private String selectedValueCol3;
	private String selectedValueCol1;
	private static Cliente c;
	private PrenotaController controller;

	public static void main(String[] args) {
	}

	public PrenotaGUI(JLabel lblId, int id) {
		
		controller = new PrenotaController(this); 
		dao = new PrenotaDAO();
		
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
		
		//label per stanze prenotabili
		JLabel lblSt = new JLabel("Stanze Prenotabili");
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		lblSt.setBounds(211, 9, 144, 15);
		panel.add(lblSt);

		//label per data check in
		JLabel lbl1 = new JLabel("data check-in desiderata");
		lbl1.setFont(new Font("Thonburi", Font.PLAIN, 16));
		lbl1.setBackground(Color.WHITE);
		lbl1.setBounds(11, 188, 259, 32);
		panel.add(lbl1);

		//bottone per le prenotazione
		JButton btnConf = new JButton("Prenota");
		btnConf.setFont(new Font("Thonburi", Font.PLAIN, 16));
		btnConf.setBounds(22, 382, 103, 32);
		panel.add(btnConf);
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//passo al controller PrenotaController l'actionEvent e l'id dell'utente attivo
//l'id mi serve per capire qual'è l'utente che sta lavorando
					controller.prenota(e, id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnTornaIndietro = new JButton("Torna indietro");

		btnTornaIndietro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ClienteGUI cl = new ClienteGUI(id, c);
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
					controller.RecuperaStanze(e);
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
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {

			 public void mouseClicked(MouseEvent e) {
				 int selectedRow = table_1.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Ottieni i valori delle colonne desiderate per la riga selezionata
	                    selectedValueCol1 = (String) table_1.getValueAt(selectedRow, 0);  // Prima colonna
	                    selectedValueCol3 = (String) table_1.getValueAt(selectedRow, 2);  // Terza colonna

	                      }
	            }
	        });


		table_1.setBounds(11, 34, 520, 123);
		panel.add(table_1);
	}
	//questi due metodi mi servono per portare le date nel controller
	public String getDateCheckin() {
		return textField.getText();
	}
	
	public String getDateCheckout() {
		return textField_1.getText();
	}
	
	public String getValore1() {
		return selectedValueCol1;
	}
	public String getValore3() {
		return selectedValueCol3;
	}
	//fatto
}

