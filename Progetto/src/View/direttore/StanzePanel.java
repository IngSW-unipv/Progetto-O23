package View.direttore;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

import Controller.direttore.StanzaActionListener;
import Model.direttore.Direttore;
import Model.direttore.DirettoreDAO;

public class StanzePanel extends JPanel {

	public JTable table;
	private DirettoreDAO dao;
	public static JLabel lbl;

	/**
	 * Create the frame.
	 
	 */
	public StanzePanel() {
		
		dao = new DirettoreDAO();
		
		StanzaActionListener stanza = new StanzaActionListener(dao, this);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 541);
		//contentPane = new JPanel();
		setBackground(new Color(181,247,157));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 20, 300, 10};
		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Stanze");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yuppy SC", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null); // impedisco di poter modificare i campi da tabella
		scrollPane.setViewportView(table);
		
		
		JButton btn = new JButton("Aggiorna");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stanza.actionPerformed(e);
			}
		});
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 1;
		add(btn, gbc_btn);
		
		
		
		
	}
}

