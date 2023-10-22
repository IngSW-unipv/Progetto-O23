package View.direttore;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

import Controller.direttore.GestioneLavAL;
import java.awt.event.*;

import Model.User;
import Model.direttore.DipendentiDAO;
import Model.direttore.Direttore;
import Model.direttore.DirettoreDAO;
import Model.direttore.TurniDao;
import View.Registration_Form;
import dao.DBConnessione;



public class LavoratoriGUI extends JFrame {



	private JPanel contentPane;

	private JTable table;

	public JTable getTable() {
		return table;
	}



	private DipendentiDAO dao;

	

	public static JLabel lbl;

	private static int id;

	private static Direttore dir;

	private JTextField IdField;

	private JTextField RuField;

	private JTextField StField;

	private JButton btnAg;
	private JButton btnCancella;
	private JButton btnMo;
	
	private int id_l;
	private String stipendio;
	private JButton btnNewButton;


	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					LavoratoriGUI frame = new LavoratoriGUI(lbl, id, dir);

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

	public LavoratoriGUI(JLabel lbl, int id, Direttore dir) {


		LavoratoriGUI.lbl = lbl;

		LavoratoriGUI.id=id;

		LavoratoriGUI.dir=dir;


		dao = new DipendentiDAO();


		GestioneLavAL controller = new GestioneLavAL(dao, this);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1376, 500);

		contentPane = new JPanel();

		contentPane.setBackground(new Color(102, 204, 102));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[]{20, 190, 190, 344, 10, 0};

		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};

		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};

		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

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

		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);

		gbc_scrollPane.fill = GridBagConstraints.BOTH;

		gbc_scrollPane.gridheight = 8;

		gbc_scrollPane.gridx = 3;

		gbc_scrollPane.gridy = 2;

		contentPane.add(scrollPane, gbc_scrollPane);


		table = new JTable();

		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {

			 public void mouseClicked(MouseEvent e) {
				 
				 IdField.setEditable(true);
				 RuField.setEditable(true);
				 StField.setEditable(true);
				 
				 int row = table.getSelectedRow();
	                
	                    // Ottieni i valori delle colonne desiderate per la riga selezionata
	                    id_l = Integer.valueOf((String) table.getValueAt(row, 0));  
	                    String ruolo = (String) table.getValueAt(row, 3);
	                    stipendio = ((String) table.getValueAt(row, 4));
	                    
	                    // imposta i valori nelle field
	                    IdField.setText(String.valueOf(id_l));
	                    RuField.setText(ruolo);
	                    StField.setText(stipendio);
	                    
	                      
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


		JLabel lblRu = new JLabel("Ruolo:");

		GridBagConstraints gbc_lblRu = new GridBagConstraints();

		gbc_lblRu.anchor = GridBagConstraints.EAST;

		lblRu.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblRu.insets = new Insets(0, 0, 5, 5);

		gbc_lblRu.gridx = 1;

		gbc_lblRu.gridy = 3;

		contentPane.add(lblRu, gbc_lblRu);


		RuField = new JTextField();
		RuField.setEditable(false);

		GridBagConstraints gbc_RuField = new GridBagConstraints();

		gbc_RuField.insets = new Insets(0, 0, 5, 5);

		gbc_RuField.fill = GridBagConstraints.BOTH;

		gbc_RuField.gridx = 2;

		gbc_RuField.gridy = 3;

		contentPane.add(RuField, gbc_RuField);

		RuField.setColumns(10);


		JLabel lblSt = new JLabel("Stipendio:");

		GridBagConstraints gbc_lblSt = new GridBagConstraints();

		gbc_lblSt.anchor = GridBagConstraints.EAST;

		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblSt.insets = new Insets(0, 0, 5, 5);

		gbc_lblSt.gridx = 1;

		gbc_lblSt.gridy = 4;

		contentPane.add(lblSt, gbc_lblSt);


		StField = new JTextField();
		StField.setEditable(false);

		GridBagConstraints gbc_StField = new GridBagConstraints();

		gbc_StField.insets = new Insets(0, 0, 5, 5);

		gbc_StField.fill = GridBagConstraints.BOTH;

		gbc_StField.gridx = 2;

		gbc_StField.gridy = 4;

		contentPane.add(StField, gbc_StField);

		StField.setColumns(10);


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
				
				controller.actionPerformed(e);

			}

		});


		btnMo = new JButton("Modifica");

		GridBagConstraints gbc_btnMo = new GridBagConstraints();

		getBtnMo().setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnMo.fill = GridBagConstraints.BOTH;

		gbc_btnMo.insets = new Insets(0, 0, 5, 5);

		gbc_btnMo.gridx = 2;

		gbc_btnMo.gridy = 7;

		contentPane.add(getBtnMo(), gbc_btnMo);
		btnMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.actionPerformed(e);
			}
		});


		JButton btnBack = new JButton("Indietro");

		GridBagConstraints gbc_btnBack = new GridBagConstraints();

		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnBack.fill = GridBagConstraints.BOTH;

		gbc_btnBack.insets = new Insets(0, 0, 5, 5);

		gbc_btnBack.gridx = 1;

		gbc_btnBack.gridy = 8;

		contentPane.add(btnBack, gbc_btnBack);

		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DirettoreGUI dip = new DirettoreGUI(id, dir);

				dip.setLbl(lbl);

				dispose();

			}

		});
		btnCancella = new JButton("Cancella");
/*		
		btnCancella.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(e);
			}
		});
*/
		GridBagConstraints gbc_btnCancella = new GridBagConstraints();

		btnCancella.setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnCancella.fill = GridBagConstraints.BOTH;

		gbc_btnCancella.insets = new Insets(0, 0, 5, 5);

		gbc_btnCancella.gridx = 2;

		gbc_btnCancella.gridy = 8;

		contentPane.add(btnCancella, gbc_btnCancella);
		
		btnNewButton = new JButton("Registra nuovo dipendente");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration_Form dip = new Registration_Form(id);

				//dip.setLbl(lbl);

				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 10;
		contentPane.add(btnNewButton, gbc_btnNewButton);





	}
	
	public int getIdL() {
	
		return id_l;
	}
	public String getStipendio() {
		
		return StField.getText();
	}

	public String getRuolo() {
		return RuField.getText();
	}
	
	public JButton getBtnAg() {
		return btnAg;
	}
	
	public JButton getBtnCancella() {
		return btnCancella;
	}



	public JButton getBtnMo() {
		return btnMo;
	}



	

}