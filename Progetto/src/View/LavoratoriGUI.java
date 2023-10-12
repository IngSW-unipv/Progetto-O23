package View;


import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DirController;
import Model.User;
import Model.direttore.DirettoreDAO;
import dao.Gestione_Dao;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class LavoratoriGUI extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private DirettoreDAO dao;
	private Connection conn;
	public static JLabel lbl;
	private static int id;
	private static User u;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LavoratoriGUI frame = new LavoratoriGUI(lbl, id, u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lbl 
	 */
	public LavoratoriGUI(JLabel lbl, int id, User u) {
		
		LavoratoriGUI.lbl = lbl;
		LavoratoriGUI.id=id;
		LavoratoriGUI.u=u;
		
		dao = new DirettoreDAO();
		
		DirController controller = new DirController(dao, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 117, 120, 344, 20, 0};
		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40,40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Lavoratori");
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
		gbc_scrollPane.gridheight = 11;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 2;
		contentPane.add(lblId, gbc_lblId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDay = new JLabel("Giorno:");
		lblDay.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.anchor = GridBagConstraints.EAST;
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.gridx = 1;
		gbc_lblDay.gridy = 3;
		contentPane.add(lblDay, gbc_lblDay);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIn = new JLabel("Orario d'inizio:");
		GridBagConstraints gbc_lblIn = new GridBagConstraints();
		gbc_lblIn.anchor = GridBagConstraints.EAST;
		lblIn.setFont(new Font("Thonburi", Font.PLAIN, 16));
		gbc_lblIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIn.gridx = 1;
		gbc_lblIn.gridy = 4;
		contentPane.add(lblIn, gbc_lblIn);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFi = new JLabel("Orario di fine:");
		GridBagConstraints gbc_lblFi = new GridBagConstraints();
		gbc_lblFi.anchor = GridBagConstraints.EAST;
		lblFi.setFont(new Font("Thonburi", Font.PLAIN, 16));
		gbc_lblFi.insets = new Insets(0, 0, 5, 5);
		gbc_lblFi.gridx = 1;
		gbc_lblFi.gridy = 5;
		contentPane.add(lblFi, gbc_lblFi);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnAg = new JButton("Aggiorna");
		btnAg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAg = new GridBagConstraints();
		gbc_btnAg.fill = GridBagConstraints.BOTH;
		gbc_btnAg.insets = new Insets(0, 0, 5, 5);
		gbc_btnAg.gridx = 1;
		gbc_btnAg.gridy = 7;
		contentPane.add(btnAg, gbc_btnAg);
		btnAg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});
		
		JButton btnMo = new JButton("Modifica");
		GridBagConstraints gbc_btnMo = new GridBagConstraints();
		btnMo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gbc_btnMo.fill = GridBagConstraints.BOTH;
		gbc_btnMo.insets = new Insets(0, 0, 5, 5);
		gbc_btnMo.gridx = 2;
		gbc_btnMo.gridy = 7;
		contentPane.add(btnMo, gbc_btnMo);
		
		JButton btn = new JButton("Aggiungi");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		GridBagConstraints gbc_btn = new GridBagConstraints();
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.gridx = 1;
		gbc_btn.gridy = 8;
		contentPane.add(btn, gbc_btn);
		
		JButton btnCancella = new JButton("Cancella");
		GridBagConstraints gbc_btnCancella = new GridBagConstraints();
		btnCancella.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gbc_btnCancella.fill = GridBagConstraints.BOTH;
		gbc_btnCancella.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancella.gridx = 2;
		gbc_btnCancella.gridy = 8;
		contentPane.add(btnCancella, gbc_btnCancella);
		
		JButton btnBack = new JButton("Indietro");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 10;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirettoreGUI dip = new DirettoreGUI(id, u);
				dip.setLbl(lbl);
				dispose();
			}
		});
		
		
		
		
	}
}

	