package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LoginController;
import Model.User;
import dao.Gestione_Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Login_Form extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	public JButton btnAccedi;
	public JButton btnPsw;
	public JLabel lblLogin;
	public JButton btnBack;
	
	private LoginController controller; // aggiunta del controller

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form frame = new Login_Form();
					
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */    
	public Login_Form() {
		super("Accesso");
		
		controller = new LoginController(this); 
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 10, 23, 43, 0};
		gbl_contentPane.rowHeights = new int[]{68, 50, 50, 41, 35, 35, 35, 50, 0};
		gbl_contentPane.columnWeights = new double[]{ 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		
		lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(154, 205, 50));
		lblLogin.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 0;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		username = new JTextField();
		username.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 0);
		gbc_username.gridx = 1;
		gbc_username.gridy = 1;
		contentPane.add(username, gbc_username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.insets = new Insets(0, 0, 5, 0);
		gbc_password.gridx = 1;
		gbc_password.gridy = 2;
		contentPane.add(password, gbc_password);
		
		btnAccedi = new JButton("Accedi al tuo account");
		
				btnAccedi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_btnAccedi = new GridBagConstraints();
				gbc_btnAccedi.fill = GridBagConstraints.BOTH;
				gbc_btnAccedi.insets = new Insets(0, 0, 5, 0);
				gbc_btnAccedi.gridx = 1;
				gbc_btnAccedi.gridy = 4;
				contentPane.add(btnAccedi, gbc_btnAccedi);
		
						
				
				btnBack = new JButton("Torna indietro");
				btnBack.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Benvenuto_Form benForm =new Benvenuto_Form();
						benForm.setVisible(true);
 	            dispose();
					}
				});
				
					btnPsw = new JButton("Password dimenticata?");
					btnPsw.setFont(new Font("Tahoma", Font.PLAIN, 20));
					GridBagConstraints gbc_btnPsw = new GridBagConstraints();
					gbc_btnPsw.fill = GridBagConstraints.BOTH;
					gbc_btnPsw.insets = new Insets(0, 0, 5, 0);
					gbc_btnPsw.gridx = 1;
					gbc_btnPsw.gridy = 5;
					contentPane.add(btnPsw, gbc_btnPsw);
					btnPsw.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							PswLost_Form pswForm =new PswLost_Form();
							pswForm.setVisible(true);
 	            dispose();
						}
					}); 
				btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.fill = GridBagConstraints.BOTH;
				gbc_btnBack.gridx = 1;
				gbc_btnBack.gridy = 6;
				contentPane.add(btnBack, gbc_btnBack);
		/*btnAccedi.addActionListener(new ActionListener() {   

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleLogin();	//delego lavoro al controller

			}
			
		});		*/											
		
		setVisible(true);
	}	
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	
}	    
