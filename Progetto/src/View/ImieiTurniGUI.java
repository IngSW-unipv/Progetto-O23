package View;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Dipendenti;
import Model.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ImieiTurniGUI extends JFrame {
	private JTable table;
	private static JLabel lbl;
	private static int id;
	private static User u;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImieiTurniGUI frame = new ImieiTurniGUI(lbl, id, u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ImieiTurniGUI(JLabel lbl, int id, User u) {
		
		ImieiTurniGUI.lbl = lbl;
		ImieiTurniGUI.id=id;
		ImieiTurniGUI.u=u;
		
		setBounds(258, 11, 576, 520);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("I tuoi turni");
		lblNewLabel.setBounds(245, 8, 83, 21);
		lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 102));
		panel.setBounds(7, 35, 562, 450);
		getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 536, 110);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
						"Giorno", "Ora di inizio", "Ora di fine"
				}
				));
		JButton btn = new JButton("Aggiorna");
		btn.setFont(new Font("Thonburi", Font.PLAIN, 16));
		btn.setBounds(368, 168, 155, 35);
		panel.add(btn);
		JButton btnNewButton = new JButton("Torna indietro");
		btnNewButton.setFont(new Font("Thonburi", Font.PLAIN, 16));
		btnNewButton.setBounds(39, 168, 155, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DipGUI dip = new DipGUI(id, u);
				dip.setLbl(lbl);
				dispose();
			}
		});

	}
	

}
