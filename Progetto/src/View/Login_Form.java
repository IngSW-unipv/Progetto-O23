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

public class Login_Form extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	
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
		setBounds(100, 100, 634, 440);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Thonburi", Font.PLAIN, 18));
		lblUsername.setBounds(74, 115, 98, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Thonburi", Font.PLAIN, 18));
		lblPassword.setBounds(74, 187, 98, 16);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Thonburi", Font.PLAIN, 18));
		username.setBounds(215, 100, 225, 50);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton btnAccedi = new JButton("Accedi al tuo account");
		
		btnAccedi.addActionListener(new ActionListener() {   

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.handleLogin();	//delego lavoro al controller
				
			}
			
		});													

		btnAccedi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccedi.setBounds(215, 263, 230, 35);
		contentPane.add(btnAccedi);
	
		JButton btnPsw = new JButton("Password dimenticata?");
		btnPsw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPsw.setBounds(215, 310, 230, 35);
		contentPane.add(btnPsw);
		btnPsw.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PswLost_Form pswForm =new PswLost_Form();
				pswForm.setVisible(true);
 	            dispose();
			}
		}); 

				
		
		JButton btnBack = new JButton("Torna indietro");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Benvenuto_Form benForm =new Benvenuto_Form();
				benForm.setVisible(true);
 	            dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(215, 357, 230, 35);
		contentPane.add(btnBack);
		
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(154, 205, 50));
		lblLogin.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lblLogin.setBounds(275, 6, 112, 68);
		contentPane.add(lblLogin);
		
		password = new JPasswordField();
		password.setFont(new Font("Thonburi", Font.PLAIN, 18));
		password.setBounds(215, 172, 225, 50);
		contentPane.add(password);
	}	
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
}	    
