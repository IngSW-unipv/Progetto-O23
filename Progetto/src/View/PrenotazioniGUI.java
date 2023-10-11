package View;



import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import Model.User;

import java.awt.*;

import java.awt.event.*;



public class PrenotazioniGUI extends JFrame {

	private JTable table;
	private static JLabel lblId;
	private static int id;
	private static User u;





	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					PrenotazioniGUI frame = new PrenotazioniGUI(lblId, id, u);

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

	public PrenotazioniGUI(JLabel lblId, int id, User u) {
		
		PrenotazioniGUI.lblId=lblId;
		PrenotazioniGUI.id=id;
		PrenotazioniGUI.u = u;


		setBounds(258, 11, 576, 520);

		getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Le tue prenotazioni");

		lbl.setBounds(212, 8, 150, 21);

		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 18));

		getContentPane().add(lbl);


		JPanel panel = new JPanel();

		panel.setBackground(new Color(102, 204, 102));

		panel.setBounds(7, 35, 562, 450);

		getContentPane().add(panel);

		panel.setLayout(null);


		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 30, 543, 119);

		panel.add(scrollPane);


		table_1 = new JTable();

		scrollPane.setViewportView(table);

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

		table.getColumnModel().getColumn(0).setPreferredWidth(116);

		table.getColumnModel().getColumn(1).setPreferredWidth(146);

		table.getColumnModel().getColumn(2).setPreferredWidth(156);

		table.getColumnModel().getColumn(3).setPreferredWidth(166);


		JButton btnNewButton = new JButton("Torna indietro");

		btnNewButton.setFont(new Font("Thonburi", Font.PLAIN, 16));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				ClienteGUI cl = new ClienteGUI(id, u);
				cl.setLbl(lblId);

				cl.setVisible(true);

				dispose();


			}

		});

		btnNewButton.setBounds(211, 412, 144, 32);

		panel.add(btnNewButton);




	}

}

