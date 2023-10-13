package View;





import java.awt.Color;



import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import javax.swing.JTable;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.sql.Time;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;

import javax.swing.JTextField;



import Controller.DirController;

import Model.User;

import Model.direttore.DirettoreDAO;

import dao.DBConnessione;



public class LavoratoriGUI extends JFrame {



	private JPanel contentPane;

	public JTable table;

	private DirettoreDAO dao;

	private Connection conn;

	public static JLabel lbl;

	private static int id;

	private static User u;

	private JTextField IdField;

	private JTextField DayField;

	private JTextField OiField;

	private JTextField OfField;



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


		IdField = new JTextField();

		GridBagConstraints gbc_IdField = new GridBagConstraints();

		gbc_IdField.insets = new Insets(0, 0, 5, 5);

		gbc_IdField.fill = GridBagConstraints.BOTH;

		gbc_IdField.gridx = 2;

		gbc_IdField.gridy = 2;

		contentPane.add(IdField, gbc_IdField);

		IdField.setColumns(10);


		JLabel lblDay = new JLabel("Giorno:");

		lblDay.setFont(new Font("Thonburi", Font.PLAIN, 16));

		GridBagConstraints gbc_lblDay = new GridBagConstraints();

		gbc_lblDay.anchor = GridBagConstraints.EAST;

		gbc_lblDay.insets = new Insets(0, 0, 5, 5);

		gbc_lblDay.gridx = 1;

		gbc_lblDay.gridy = 3;

		contentPane.add(lblDay, gbc_lblDay);


		DayField = new JTextField();

		GridBagConstraints gbc_DayField = new GridBagConstraints();

		gbc_DayField.insets = new Insets(0, 0, 5, 5);

		gbc_DayField.fill = GridBagConstraints.BOTH;

		gbc_DayField.gridx = 2;

		gbc_DayField.gridy = 3;

		contentPane.add(DayField, gbc_DayField);

		DayField.setColumns(10);


		JLabel lblIn = new JLabel("Orario d'inizio:");

		GridBagConstraints gbc_lblIn = new GridBagConstraints();

		gbc_lblIn.anchor = GridBagConstraints.EAST;

		lblIn.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblIn.insets = new Insets(0, 0, 5, 5);

		gbc_lblIn.gridx = 1;

		gbc_lblIn.gridy = 4;

		contentPane.add(lblIn, gbc_lblIn);


		OiField = new JTextField();

		GridBagConstraints gbc_OiField = new GridBagConstraints();

		gbc_OiField.insets = new Insets(0, 0, 5, 5);

		gbc_OiField.fill = GridBagConstraints.BOTH;

		gbc_OiField.gridx = 2;

		gbc_OiField.gridy = 4;

		contentPane.add(OiField, gbc_OiField);

		OiField.setColumns(10);


		JLabel lblFi = new JLabel("Orario di fine:");

		GridBagConstraints gbc_lblFi = new GridBagConstraints();

		gbc_lblFi.anchor = GridBagConstraints.EAST;

		lblFi.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblFi.insets = new Insets(0, 0, 5, 5);

		gbc_lblFi.gridx = 1;

		gbc_lblFi.gridy = 5;

		contentPane.add(lblFi, gbc_lblFi);


		OfField = new JTextField();

		GridBagConstraints gbc_OfField = new GridBagConstraints();

		gbc_OfField.insets = new Insets(0, 0, 5, 5);

		gbc_OfField.fill = GridBagConstraints.BOTH;

		gbc_OfField.gridx = 2;

		gbc_OfField.gridy = 5;

		contentPane.add(OfField, gbc_OfField);

		OfField.setColumns(10);


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

		btnMo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Connessione al database

				DBConnessione d =new DBConnessione();

				Connection con=null;

				con=d.connessione(con);

				PreparedStatement stmt = null;



				try {

					String sql ="update turni_lavoro set id_l='"+Integer.valueOf(IdField.getText())+"', giorno='"+Date.valueOf(DayField.getText())+"',ora_inizio='"+Time.valueOf(OiField.getText())+"', ora_fine='"+Time.valueOf(OfField.getText())+"' where id_l='"+Integer.valueOf(IdField.getText())+"' and giorno='"+Date.valueOf(DayField.getText())+"'";

					stmt=con.prepareStatement(sql);





					stmt.executeUpdate();

					System.out.println("Modifica completata con successo");



				} catch (SQLException e1) {

					e1.printStackTrace();

				} 



			}

		});


		JButton btn = new JButton("Aggiungi");



		GridBagConstraints gbc_btn = new GridBagConstraints();

		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btn.fill = GridBagConstraints.BOTH;

		gbc_btn.insets = new Insets(0, 0, 5, 5);

		gbc_btn.gridx = 1;

		gbc_btn.gridy = 8;

		contentPane.add(btn, gbc_btn);

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Connessione al database

				DBConnessione d =new DBConnessione();

				Connection con=null;

				con=d.connessione(con);

				PreparedStatement stmt = null;



				try {

					String sql ="insert into turni_lavoro (id_l, giorno, ora_inizio, ora_fine) values (?, ?, ?, ?)";

					stmt=con.prepareStatement(sql);

					stmt.setInt(1, Integer.valueOf(IdField.getText()));

					stmt.setDate(2, Date.valueOf(DayField.getText()));

					stmt.setTime(3, Time.valueOf(OiField.getText()));

					stmt.setTime(4, Time.valueOf(OfField.getText()));



					stmt.executeUpdate();

					System.out.println("Aggiunta completata con successo");



				} catch (SQLException e1) {

					e1.printStackTrace();

				} 



			}

		});


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



	