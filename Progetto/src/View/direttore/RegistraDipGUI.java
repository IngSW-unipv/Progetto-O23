package View.direttore;

import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Model.direttore.Direttore;
import Controller.direttore.RegDipAL;


public class RegistraDipGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cognome;
	private JTextField cf;
	private JTextField email;
	private JTextField cell;
	private JTextField via;
	private JTextField citta;        
	private JTextField provincia;
	private JTextField cap;
	private JTextField username;
	private JTextField ruolo;
	private JTextField stipendio;

	private JPasswordField password;
	private JDateChooser dateChooser;

	private JButton btnReg;
	private JButton btnBack;

	private JLabel checkU;
	private JLabel checkE;

	private static int id;
	private static Direttore dir;
	private static JLabel lbl;


	public RegistraDipGUI(Direttore dir) {

		this.dir=dir;
	
		RegDipAL reg = new RegDipAL(dir, this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1124, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 133, 200, 65, 133, 200, 133};
		gbl_contentPane.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblReg = new JLabel("Registrazione dipendente");
		lblReg.setForeground(new Color(154, 205, 50));
		lblReg.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		GridBagConstraints gbc_lblReg = new GridBagConstraints();
		gbc_lblReg.insets = new Insets(0, 0, 5, 0);
		gbc_lblReg.gridwidth = 8;
		gbc_lblReg.gridx = 0;
		gbc_lblReg.gridy = 0;
		contentPane.add(lblReg, gbc_lblReg);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);

		nome = new JTextField();
		nome.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_nome = new GridBagConstraints();
		gbc_nome.fill = GridBagConstraints.BOTH;
		gbc_nome.insets = new Insets(0, 0, 5, 5);
		gbc_nome.gridx = 2;
		gbc_nome.gridy = 1;
		contentPane.add(nome, gbc_nome);
		nome.setColumns(10);

		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCognome = new GridBagConstraints();
		gbc_lblCognome.anchor = GridBagConstraints.WEST;
		gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognome.gridx = 4;
		gbc_lblCognome.gridy = 1;
		contentPane.add(lblCognome, gbc_lblCognome);

		cognome = new JTextField();
		cognome.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_cognome = new GridBagConstraints();
		gbc_cognome.fill = GridBagConstraints.BOTH;
		gbc_cognome.insets = new Insets(0, 0, 5, 5);
		gbc_cognome.gridx = 5;
		gbc_cognome.gridy = 1;
		contentPane.add(cognome, gbc_cognome);
		cognome.setColumns(10);

		JLabel lblCF = new JLabel("Codice Fiscale:");
		lblCF.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCF = new GridBagConstraints();
		gbc_lblCF.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCF.gridx = 1;
		gbc_lblCF.gridy = 2;
		contentPane.add(lblCF, gbc_lblCF);

		cf = new JTextField();
		cf.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_cf = new GridBagConstraints();
		gbc_cf.fill = GridBagConstraints.BOTH;
		gbc_cf.insets = new Insets(0, 0, 5, 5);
		gbc_cf.gridx = 2;
		gbc_cf.gridy = 2;
		contentPane.add(cf, gbc_cf);
		cf.setColumns(10);

		JLabel lblDate = new JLabel("Data Di Nascita: ");
		lblDate.setFont(new Font("Thonburi", Font.PLAIN, 16));
		lblDate.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 4;
		gbc_lblDate.gridy = 2;
		contentPane.add(lblDate, gbc_lblDate);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d-MM-yyyy");
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 5;
		gbc_dateChooser.gridy = 2;
		contentPane.add(dateChooser, gbc_dateChooser);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		contentPane.add(lblEmail, gbc_lblEmail);

		email = new JTextField();
		email.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.fill = GridBagConstraints.BOTH;
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridx = 2;
		gbc_email.gridy = 3;
		contentPane.add(email, gbc_email);
		email.setColumns(10);

		checkE = new JLabel("");
		GridBagConstraints gbc_checkE = new GridBagConstraints();
		gbc_checkE.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkE.insets = new Insets(0, 0, 5, 5);
		gbc_checkE.gridx = 3;
		gbc_checkE.gridy = 3;
		contentPane.add(checkE, gbc_checkE);

		JLabel lblMobileNumber = new JLabel("Cell:");
		lblMobileNumber.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMobileNumber = new GridBagConstraints();
		gbc_lblMobileNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMobileNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNumber.gridx = 4;
		gbc_lblMobileNumber.gridy = 3;
		contentPane.add(lblMobileNumber, gbc_lblMobileNumber);

		cell = new JTextField();
		cell.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_cell = new GridBagConstraints();
		gbc_cell.fill = GridBagConstraints.BOTH;
		gbc_cell.insets = new Insets(0, 0, 5, 5);
		gbc_cell.gridx = 5;
		gbc_cell.gridy = 3;
		contentPane.add(cell, gbc_cell);
		cell.setColumns(10);

		JLabel lblVia = new JLabel("Via:");
		lblVia.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblVia = new GridBagConstraints();
		gbc_lblVia.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVia.insets = new Insets(0, 0, 5, 5);
		gbc_lblVia.gridx = 1;
		gbc_lblVia.gridy = 4;
		contentPane.add(lblVia, gbc_lblVia);

		via = new JTextField();
		getVia().setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_via = new GridBagConstraints();
		gbc_via.fill = GridBagConstraints.BOTH;
		gbc_via.insets = new Insets(0, 0, 5, 5);
		gbc_via.gridx = 2;
		gbc_via.gridy = 4;
		contentPane.add(getVia(), gbc_via);
		getVia().setColumns(10);

		JLabel lbnCitta = new JLabel("Citta:");
		lbnCitta.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lbnCitta = new GridBagConstraints();
		gbc_lbnCitta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbnCitta.insets = new Insets(0, 0, 5, 5);
		gbc_lbnCitta.gridx = 4;
		gbc_lbnCitta.gridy = 4;
		contentPane.add(lbnCitta, gbc_lbnCitta);

		citta = new JTextField();
		citta.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_citta = new GridBagConstraints();
		gbc_citta.fill = GridBagConstraints.BOTH;
		gbc_citta.insets = new Insets(0, 0, 5, 5);
		gbc_citta.gridx = 5;
		gbc_citta.gridy = 4;
		contentPane.add(citta, gbc_citta);
		citta.setColumns(10);

		JLabel lblProv = new JLabel("Provincia:");
		lblProv.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblProv = new GridBagConstraints();
		gbc_lblProv.anchor = GridBagConstraints.WEST;
		gbc_lblProv.insets = new Insets(0, 0, 5, 5);
		gbc_lblProv.gridx = 1;
		gbc_lblProv.gridy = 5;
		contentPane.add(lblProv, gbc_lblProv);

		provincia = new JTextField();
		provincia.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_provincia = new GridBagConstraints();
		gbc_provincia.fill = GridBagConstraints.BOTH;
		gbc_provincia.insets = new Insets(0, 0, 5, 5);
		gbc_provincia.gridx = 2;
		gbc_provincia.gridy = 5;
		contentPane.add(provincia, gbc_provincia);
		provincia.setColumns(10);

		JLabel lblCAP = new JLabel("CAP:");
		lblCAP.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCAP = new GridBagConstraints();
		gbc_lblCAP.anchor = GridBagConstraints.WEST;
		gbc_lblCAP.insets = new Insets(0, 0, 5, 5);
		gbc_lblCAP.gridx = 4;
		gbc_lblCAP.gridy = 5;
		contentPane.add(lblCAP, gbc_lblCAP);

		cap = new JTextField();
		cap.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_cap = new GridBagConstraints();
		gbc_cap.fill = GridBagConstraints.BOTH;
		gbc_cap.insets = new Insets(0, 0, 5, 5);
		gbc_cap.gridx = 5;
		gbc_cap.gridy = 5;
		contentPane.add(cap, gbc_cap);
		cap.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 6;
		contentPane.add(lblUsername, gbc_lblUsername);

		username = new JTextField();
		username.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.gridx = 2;
		gbc_username.gridy = 6;
		contentPane.add(username, gbc_username);
		username.setColumns(10);

		checkU = new JLabel("");
		GridBagConstraints gbc_checkU = new GridBagConstraints();
		gbc_checkU.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkU.insets = new Insets(0, 0, 5, 5);
		gbc_checkU.gridx = 3;
		gbc_checkU.gridy = 6;
		contentPane.add(checkU, gbc_checkU);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 4;
		gbc_lblPassword.gridy = 6;
		contentPane.add(lblPassword, gbc_lblPassword);

		password = new JPasswordField();
		password.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 5;
		gbc_password.gridy = 6;
		contentPane.add(password, gbc_password);

		JLabel lblRu = new JLabel("Ruolo:");
		lblRu.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRu = new GridBagConstraints();
		gbc_lblRu.anchor = GridBagConstraints.WEST;
		gbc_lblRu.insets = new Insets(0, 0, 5, 5);
		gbc_lblRu.gridx = 1;
		gbc_lblRu.gridy = 7;
		contentPane.add(lblRu, gbc_lblRu);

		ruolo = new JTextField();
		ruolo.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_ruolo = new GridBagConstraints();
		gbc_ruolo.insets = new Insets(0, 0, 5, 5);
		gbc_ruolo.fill = GridBagConstraints.BOTH;
		gbc_ruolo.gridx = 2;
		gbc_ruolo.gridy = 7;
		contentPane.add(ruolo, gbc_ruolo);
		ruolo.setColumns(10);

		JLabel lblSt = new JLabel("Stipendio:");
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSt = new GridBagConstraints();
		gbc_lblSt.anchor = GridBagConstraints.WEST;
		gbc_lblSt.insets = new Insets(0, 0, 5, 5);
		gbc_lblSt.gridx = 4;
		gbc_lblSt.gridy = 7;
		contentPane.add(lblSt, gbc_lblSt);

		stipendio = new JTextField();
		stipendio.setFont(new Font("Thonburi", Font.PLAIN, 16));
		GridBagConstraints gbc_stipendio = new GridBagConstraints();
		gbc_stipendio.insets = new Insets(0, 0, 5, 5);
		gbc_stipendio.fill = GridBagConstraints.BOTH;
		gbc_stipendio.gridx = 5;
		gbc_stipendio.gridy = 7;
		contentPane.add(stipendio, gbc_stipendio);
		stipendio.setColumns(10);

		btnBack = new JButton("Annulla");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();


			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 9;
		contentPane.add(btnBack, gbc_btnBack);

		btnReg = new JButton("Registrati");     
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.actionPerformed(e);
				dispose(); 
			}
		});
		btnReg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnReg = new GridBagConstraints();
		gbc_btnReg.fill = GridBagConstraints.BOTH;
		gbc_btnReg.insets = new Insets(0, 0, 5, 5);
		gbc_btnReg.gridx = 5;
		gbc_btnReg.gridy = 9;
		contentPane.add(btnReg, gbc_btnReg);

		setVisible(true);

	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JLabel getLbl() {
		return lbl;
	}

	public static void setLbl(JLabel lbl) {
		RegistraDipGUI.lbl = lbl;
	}


	public JButton getBtnReg() {
		return btnReg;
	}

	public void setBtnReg(JButton btnReg) {
		this.btnReg = btnReg;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public void setCheckU(String text) {
		checkU.setText(text);

	}

	public void setCheckE(String text) {
		checkE.setText(text);

	}

	public JTextField getVia() {
		return via;
	}

	public JTextField getNome() {
		return nome;
	}

	public JTextField getCognome() {
		return cognome;
	}

	public JTextField getCf() {
		return cf;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getCell() {
		return cell;
	}

	public JTextField getCitta() {
		return citta;
	}

	public JTextField getProvincia() {
		return provincia;
	}

	public JTextField getCap() {
		return cap;
	}

	public JTextField getUsername() {
		return username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public JTextField getRuolo() {
		return ruolo;
	}

	public JTextField getStipendio() {
		return stipendio;
	}

}