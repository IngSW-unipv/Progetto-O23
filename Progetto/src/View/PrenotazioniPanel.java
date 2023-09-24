package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.TextArea;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import java.awt.ScrollPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class PrenotazioniPanel extends JFrame {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PrenotazioniPanel() {
		
		setBounds(258, 11, 576, 520);
		setLayout(null);
		JLabel lbl = new JLabel("Le tue prenotazioni");
		lbl.setBounds(212, 8, 150, 21);
		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 18));
		add(lbl);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 102));
		panel.setBounds(7, 35, 562, 450);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 536, 119);
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
		

	}
}
