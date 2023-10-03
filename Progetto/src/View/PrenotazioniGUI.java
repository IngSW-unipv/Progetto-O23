package View;



import javax.swing.*;

import javax.swing.table.DefaultTableModel;



import java.awt.*;

import java.awt.event.*;







public class PrenotazioniGUI extends JFrame {

	private JTable table;
	private static JLabel lblId;
	private static int id;





	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					PrenotazioniGUI frame = new PrenotazioniGUI(lblId, id);

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

	public PrenotazioniGUI(JLabel lblId, int id) {
		
		PrenotazioniGUI.lblId=lblId;
		PrenotazioniGUI.id=id;


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


		table = new JTable();

		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(

				new Object[][] {

					{null,null, null, null},

					{null, null, null, null},

				},

				new String[] {

						"Data Prenotazione", "Numero Stanza", "Check in", "Check out"

				}

				));

		table.getColumnModel().getColumn(0).setPreferredWidth(116);

		table.getColumnModel().getColumn(1).setPreferredWidth(146);

		table.getColumnModel().getColumn(2).setPreferredWidth(156);

		table.getColumnModel().getColumn(3).setPreferredWidth(166);


		JButton btnNewButton = new JButton("Torna indietro");

		btnNewButton.setFont(new Font("Thonburi", Font.PLAIN, 16));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ClienteGUI cl = new ClienteGUI(id);
				cl.setLbl(lblId);

				cl.setVisible(true);

				dispose();


			}

		});

		btnNewButton.setBounds(211, 412, 144, 32);

		panel.add(btnNewButton);




	}

}

