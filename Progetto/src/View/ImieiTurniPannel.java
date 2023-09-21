package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ImieiTurniPannel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ImieiTurniPannel() {
		
		setBounds(258, 11, 576, 520);
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("I tuoi turni");
		lblNewLabel.setBounds(245, 8, 83, 21);
		lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 102));
		panel.setBounds(7, 35, 562, 450);
		add(panel);
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
		

	}

}
