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

public class PrenotaPanel extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PrenotaPanel() {
		setBackground(new Color(240, 240, 240));
		
		setBounds(258, 11, 576, 520);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Prenotazione");
		lblNewLabel.setBounds(249, 5, 92, 21);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 102));
		panel.setBounds(25, 37, 541, 453);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 521, 75);
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
		
		JLabel lblNewLabel_1 = new JLabel("Stanze Prenotabili");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(210, 11, 155, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Scrivere la stanza da prenotare");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 244, 223, 32);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(20, 287, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Prenota");
		btnNewButton.setBounds(151, 287, 89, 23);
		panel.add(btnNewButton);
		

	}

}
