package View.direttore;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Controller.direttore.LavActionListener;
import java.awt.event.*;

import Model.direttore.Direttore;
import Model.turni.TurniDao;




public class LavTurniGUI extends JFrame {



	private JPanel contentPane;

	public JTable table;

	private TurniDao dao;

	

	public static JLabel lbl;

	private int id;

	private Direttore dir;

	private JTextField IdField;

	private JTextField DayField;

	private JTextField OiField;

	private JTextField OfField;

	private JButton btnAg;
	private JButton btn;
	private JButton btnCancella;
	private JButton btnMo;
	
	private int idT;

/*
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					LavTurniGUI frame = new LavTurniGUI(lbl, id, dir);

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

	public LavTurniGUI(JLabel lbl, int id, Direttore dir) {


		this.lbl = lbl;

		this.id=id;

		this.dir=dir;


		dao = new TurniDao();


		LavActionListener controller = new LavActionListener(dao, this);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 888, 565);

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


		JLabel lblNewLabel = new JLabel("Turni lavoratori");

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
		table.setDefaultEditor(Object.class, null); // impedisco di poter modificare i campi da tabella
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {

			 public void mouseClicked(MouseEvent e) {
				 edit();
				 
				 btnCancella.setEnabled(true);
				 btnMo.setEnabled(true);
				 int row = table.getSelectedRow();
	                
	                    // Ottieni i valori delle colonne desiderate per la riga selezionata
	                    String id_l = (String) table.getValueAt(row, 0);  
	                    String giorno = (String) table.getValueAt(row, 1);
	                    String oraI = (String) table.getValueAt(row, 2);
	                    String oraF = (String) table.getValueAt(row, 3);
	                    idT = Integer.valueOf((String) table.getValueAt(row, 4));
	                    // imposta i valori nelle field
	                    IdField.setText(id_l);
	                    DayField.setText(giorno);
	                    OiField.setText(oraI);
	                    OfField.setText(oraF);
	                      
	            }
	        });
		


		JLabel lblId = new JLabel("Id:");

		lblId.setFont(new Font("Thonburi", Font.PLAIN, 16));

		GridBagConstraints gbc_lblId = new GridBagConstraints();

		gbc_lblId.anchor = GridBagConstraints.EAST;

		gbc_lblId.insets = new Insets(0, 0, 5, 5);

		gbc_lblId.gridx = 1;

		gbc_lblId.gridy = 2;

		contentPane.add(lblId, gbc_lblId);


		IdField = new JTextField();
		IdField.setEditable(false);

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
		DayField.setEditable(false);

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
		OiField.setEditable(false);

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
		OfField.setEditable(false);

		GridBagConstraints gbc_OfField = new GridBagConstraints();

		gbc_OfField.insets = new Insets(0, 0, 5, 5);

		gbc_OfField.fill = GridBagConstraints.BOTH;

		gbc_OfField.gridx = 2;

		gbc_OfField.gridy = 5;

		contentPane.add(OfField, gbc_OfField);

		OfField.setColumns(10);


		btnAg = new JButton("Aggiorna");

		getBtnAg().setFont(new Font("Tahoma", Font.PLAIN, 16));

		GridBagConstraints gbc_btnAg = new GridBagConstraints();

		gbc_btnAg.fill = GridBagConstraints.BOTH;

		gbc_btnAg.insets = new Insets(0, 0, 5, 5);

		gbc_btnAg.gridx = 1;

		gbc_btnAg.gridy = 7;

		contentPane.add(getBtnAg(), gbc_btnAg);

		getBtnAg().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				edit();
				controller.actionPerformed(e);	
				
			}

		});


		btnMo = new JButton("Salva");
		btnMo.setEnabled(false);
		btnMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.actionPerformed(e);
				unedit();
			}
		});

		GridBagConstraints gbc_btnMo = new GridBagConstraints();

		getBtnMo().setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnMo.fill = GridBagConstraints.BOTH;

		gbc_btnMo.insets = new Insets(0, 0, 5, 5);

		gbc_btnMo.gridx = 2;

		gbc_btnMo.gridy = 7;

		contentPane.add(getBtnMo(), gbc_btnMo);

		btn = new JButton("Aggiungi");



		GridBagConstraints gbc_btn = new GridBagConstraints();

		getBtn().setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btn.fill = GridBagConstraints.BOTH;

		gbc_btn.insets = new Insets(0, 0, 5, 5);

		gbc_btn.gridx = 1;

		gbc_btn.gridy = 8;

		contentPane.add(getBtn(), gbc_btn);
		
		getBtn().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				controller.actionPerformed(e);
				unedit();
			}

		});

		btnCancella = new JButton("Cancella");
		btnCancella.setEnabled(false);
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
				unedit();
			}
		});

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

				DirettoreGUI dip = new DirettoreGUI(id, dir);

				dip.setLbl(lbl);

				dispose();

			}

		});





	}
	
	public String getId_l() {
		return IdField.getText();
	}
	
	public String getGiorno() {
		return DayField.getText();
	}
	public String getOraI() {
		return OiField.getText();
	}
	public String getOraf() {
		return OfField.getText();
	}



	public JButton getBtnAg() {
		return btnAg;
	}

	public JButton getBtn() {
		return btn;
	}
	
	public JButton getBtnCancella() {
		return btnCancella;
	}



	public JButton getBtnMo() {
		return btnMo;
	}



	public int getIdT() {
		return idT;
	}
	
	private void edit() {
		IdField.setEditable(true);
		DayField.setEditable(true);
		OiField.setEditable(true);
		OfField.setEditable(true);
	}
	
	private void unedit() {
		IdField.setEditable(false);
		DayField.setEditable(false);
		OiField.setEditable(false);
		OfField.setEditable(false);
	}

}



	