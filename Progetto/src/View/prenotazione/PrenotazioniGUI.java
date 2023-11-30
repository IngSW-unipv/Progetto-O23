package View.prenotazione;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;
import Model.Cliente;
import Model.User;
import View.cliente.ClienteGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import Controller.prenotazione.PrenotazioneGUIController;

public class PrenotazioniGUI extends JFrame {

	public JTable table;
	private static JLabel lblId;
	private static int id;
	private static Cliente c;
	private PrenotazioneGUIController controller; // aggiunta del controller
	public JTable table_1;
	private String selectedValueCol1;
	




	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					PrenotazioniGUI frame = new PrenotazioniGUI(lblId, id, c);

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}


	public PrenotazioniGUI(JLabel lblId, int id, User u) {
		
		PrenotazioniGUI.lblId=lblId;
		PrenotazioniGUI.id=id;
		PrenotazioniGUI.c = c;
		
		controller = new PrenotazioneGUIController(this);

		setBounds(258, 11, 576, 520);

		getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Le tue prenotazioni");

		lbl.setBounds(212, 8, 150, 21);

		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 18));

		getContentPane().add(lbl);


		JPanel panel = new JPanel();

		panel.setBackground(new Color(102, 204, 102));

		panel.setBounds(0, 33, 562, 450);

		getContentPane().add(panel);

		panel.setLayout(null);


		table = new JTable();

		table.setBounds(11, 34, 520, 123);

		JButton btnNewButton = new JButton("Torna indietro");

		btnNewButton.setFont(new Font("Thonburi", Font.PLAIN, 16));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				ClienteGUI cl = new ClienteGUI(id, c);
				cl.setLbl(lblId);

				cl.setVisible(true);

				dispose();


			}

		});

		btnNewButton.setBounds(211, 412, 144, 32);

		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("ID utente  " + id);
		lblNewLabel.setBounds(10, 159, 98, 39);
		panel.add(lblNewLabel);
		
		table_1 = new JTable();
		
		table_1.addMouseListener(new MouseAdapter() {

			 public void mouseClicked(MouseEvent e) {
				 int selectedRow = table_1.getSelectedRow();
	                if (selectedRow != -1) {
	                    // Ottieni i valori delle colonne desiderate per la riga selezionata
	                    selectedValueCol1 = (String) table_1.getValueAt(selectedRow, 0);  // Prima colonna
	                   
	                      }
	            }
	        });
		
		
		
		table_1.setBounds(10, 23, 542, 148);
		panel.add(table_1);

		JButton btnNewButton_1 = new JButton("Visualizza Prenotazioni");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.riempitabella(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(20, 208, 184, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Elimina Prenotazione");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.eliminaPrenotazione(e, selectedValueCol1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(20, 277, 200, 49);
		panel.add(btnNewButton_2);

	}
	
	public int getID() {
		return id;
	}
}