package View;
import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.ClientController;
import Model.User;
import dao.Gestione_Dao;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;



public class PrenotaGUI extends JFrame {
	private static JLabel lblId;
	private static int id;;
	private JTextField textField;
	private JTextField textField_1;
	private User user;
	private Gestione_Dao dao;
	private ClientController controller; // aggiunta del controller
	public JTable table_1;
	private String selectedValueCol1;
    private String selectedValueCol3;
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
		dao = new Gestione_Dao();
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
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.prenota(e, selectedValueCol1, selectedValueCol3, id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

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

}