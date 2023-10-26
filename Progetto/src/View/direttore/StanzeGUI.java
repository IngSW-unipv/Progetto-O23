package View.direttore;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

import Controller.direttore.StanzaActionListener;
import Model.User;
import Model.direttore.Direttore;
import Model.direttore.DirettoreDAO;

public class StanzeGUI extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private DirettoreDAO dao;
	public static JLabel lbl;
	private static int id;
	private static Direttore dir;

/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StanzeGUI frame = new StanzeGUI(lbl, id, dir);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @param lbl 
	 */
	public StanzeGUI(JLabel lbl, int id, Direttore dir) {
		
		StanzeGUI.lbl = lbl;
		StanzeGUI.id=id;
		StanzeGUI.dir=dir;
		
		dao = new DirettoreDAO();
		
		StanzaActionListener stanza = new StanzaActionListener(dao, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{20, 30, 20, 344, 20, 0};
		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Stanze");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yuppy SC", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
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
		gbc_btn.gridx = 1;
		gbc_btn.gridy = 1;
		contentPane.add(btn, gbc_btn);
		
		JButton btnBack = new JButton("Indietro");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 3;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirettoreGUI dip = new DirettoreGUI(id, dir);
				dip.setLbl(lbl);
				dispose();
			}
		});
		
		
		
		
	}
}

