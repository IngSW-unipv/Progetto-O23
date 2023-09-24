package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PrenotaPanel extends JFrame {
	private JTable table;
	private JTextField NuField;

	/**
	 * Create the panel.
	 */
	public PrenotaPanel() {
		setBackground(new Color(240, 240, 240));
		
		setBounds(258, 11, 576, 520);
		setLayout(null);
		JLabel lblPr = new JLabel("Prenotazione");
		lblPr.setBounds(235, 8, 104, 21);
		lblPr.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
		add(lblPr);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 102));
		panel.setBounds(7, 35, 562, 450);
		add(panel);
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
		
		JLabel lbl = new JLabel("Scrivere la stanza da prenotare:");
		lbl.setFont(new Font("Thonburi", Font.PLAIN, 16));
		lbl.setBackground(Color.WHITE);
		lbl.setBounds(10, 244, 259, 32);
		panel.add(lbl);
		
		NuField = new JTextField();
		NuField.setBounds(20, 285, 86, 20);
		panel.add(NuField);
		NuField.setColumns(10);
		
		JButton btnConf = new JButton("Prenota");
		btnConf.setFont(new Font("Thonburi", Font.PLAIN, 14));
		btnConf.setBounds(139, 278, 103, 32);
		panel.add(btnConf);
		

	}

}
