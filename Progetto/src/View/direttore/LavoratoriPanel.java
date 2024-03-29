package View.direttore;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Controller.direttore.GestioneLavAL;
import java.awt.event.*;

import Model.dipendente.DipendentiDAO;
import Model.direttore.Direttore;

public class LavoratoriPanel extends JPanel {

	private JTable table;

	private DipendentiDAO dao;

	public static JLabel lbl;
	
	private Direttore dir;

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

	 * Create the frame.

	 * @param dir

	 */

	public LavoratoriPanel(Direttore dir) {
		this.dir=dir;
		dao = new DipendentiDAO();


		GestioneLavAL controller = new GestioneLavAL(dao, dir, this);

		setBounds(100, 100, 1440, 500);


		setBackground(new Color(181,247,157));

		setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[]{190, 190, 0};

		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};

		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};

		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

		setLayout(gbl_contentPane);


		JLabel lblNewLabel = new JLabel("Dipendenti");

		lblNewLabel.setForeground(new Color(0, 0, 0));

		lblNewLabel.setFont(new Font("Yuppy SC", Font.PLAIN, 20));

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;

		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);

		gbc_lblNewLabel.gridx = 2;

		gbc_lblNewLabel.gridy = 0;

		add(lblNewLabel, gbc_lblNewLabel);


		JScrollPane scrollPane = new JScrollPane();

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();

		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);

		gbc_scrollPane.fill = GridBagConstraints.BOTH;

		gbc_scrollPane.gridheight = 8;

		gbc_scrollPane.gridx = 2;

		gbc_scrollPane.gridy = 2;

		add(scrollPane, gbc_scrollPane);


		table = new JTable(); 
		table.setDefaultEditor(Object.class, null); // impedisco di poter modificare i campi da tabella

		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {

			 public void mouseClicked(MouseEvent e) { 
				// rendo campi e bottoni che mi servono editabili
				 RuField.setEditable(true); 
				 StField.setEditable(true);
				 
				 btnCancella.setEnabled(true);
				 btnMo.setEnabled(true);
				 
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

		gbc_lblId.gridx = 0;

		gbc_lblId.gridy = 2;

		add(lblId, gbc_lblId);


		IdField = new JTextField();
		IdField.setEditable(false);

		GridBagConstraints gbc_IdField = new GridBagConstraints();

		gbc_IdField.insets = new Insets(0, 0, 5, 5);

		gbc_IdField.fill = GridBagConstraints.BOTH;

		gbc_IdField.gridx = 1;

		gbc_IdField.gridy = 2;

		add(IdField, gbc_IdField);

		IdField.setColumns(10);


		JLabel lblRu = new JLabel("Ruolo:");

		GridBagConstraints gbc_lblRu = new GridBagConstraints();

		gbc_lblRu.anchor = GridBagConstraints.EAST;

		lblRu.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblRu.insets = new Insets(0, 0, 5, 5);

		gbc_lblRu.gridx = 0;

		gbc_lblRu.gridy = 3;

		add(lblRu, gbc_lblRu);


		RuField = new JTextField();
		RuField.setEditable(false);

		GridBagConstraints gbc_RuField = new GridBagConstraints();

		gbc_RuField.insets = new Insets(0, 0, 5, 5);

		gbc_RuField.fill = GridBagConstraints.BOTH;

		gbc_RuField.gridx = 1;

		gbc_RuField.gridy = 3;

		add(RuField, gbc_RuField);

		RuField.setColumns(10);


		JLabel lblSt = new JLabel("Stipendio:");

		GridBagConstraints gbc_lblSt = new GridBagConstraints();

		gbc_lblSt.anchor = GridBagConstraints.EAST;

		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));

		gbc_lblSt.insets = new Insets(0, 0, 5, 5);

		gbc_lblSt.gridx = 0;

		gbc_lblSt.gridy = 4;

		add(lblSt, gbc_lblSt);


		StField = new JTextField();
		StField.setEditable(false);

		GridBagConstraints gbc_StField = new GridBagConstraints();

		gbc_StField.insets = new Insets(0, 0, 5, 5);

		gbc_StField.fill = GridBagConstraints.BOTH;

		gbc_StField.gridx = 1;

		gbc_StField.gridy = 4;

		add(StField, gbc_StField);

		StField.setColumns(10);


		btnAg = new JButton("Aggiorna");

		getBtnAg().setFont(new Font("Tahoma", Font.PLAIN, 16));

		GridBagConstraints gbc_btnAg = new GridBagConstraints();

		gbc_btnAg.fill = GridBagConstraints.BOTH;

		gbc_btnAg.insets = new Insets(0, 0, 5, 5);

		gbc_btnAg.gridx = 0;

		gbc_btnAg.gridy = 7;

		add(getBtnAg(), gbc_btnAg);

		getBtnAg().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				controller.actionPerformed(e);

			}

		});


		btnMo = new JButton("Salva");
		btnMo.setEnabled(false);

		GridBagConstraints gbc_btnMo = new GridBagConstraints();

		getBtnMo().setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnMo.fill = GridBagConstraints.BOTH;

		gbc_btnMo.insets = new Insets(0, 0, 5, 5);

		gbc_btnMo.gridx = 1;

		gbc_btnMo.gridy = 7;

		add(getBtnMo(), gbc_btnMo);
		btnMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.actionPerformed(e);
			}
		});
		btnCancella = new JButton("Cancella");
		btnCancella.setEnabled(false);
		btnCancella.setToolTipText("Dipendente fuori organico");

		btnCancella.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
				//doppio controllo sul tasto cancella visto che è importante
                	if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare il dipendente?"
                			+ "Questa azione cancellerà eventuali turni presenti per il dipendente selezionato") == 0) {
                		controller.actionPerformed(e);
                		init();
                	}
                }
			}
		});

		GridBagConstraints gbc_btnCancella = new GridBagConstraints();

		btnCancella.setFont(new Font("Tahoma", Font.PLAIN, 16));

		gbc_btnCancella.fill = GridBagConstraints.BOTH;

		gbc_btnCancella.insets = new Insets(0, 0, 5, 5);

		gbc_btnCancella.gridx = 1;

		gbc_btnCancella.gridy = 8;

		add(btnCancella, gbc_btnCancella);
		
		btnNewButton = new JButton("Registra nuovo dipendente");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistraDipGUI dip = new RegistraDipGUI(dir);
				//dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(btnNewButton, gbc_btnNewButton);





	}
	
	public void init() {
		IdField.setText("");
		RuField.setText("");
		StField.setText("");
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
	
	public JTable getTable() {
		return table;
	}

	public JButton getBtnMo() {
		return btnMo;
	}



	

}