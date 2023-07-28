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
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Gestione_Dao dao = new Gestione_Dao();
		            boolean loggedIn = dao.login(getUsername(), getPassword());
		            if (loggedIn) {
		                JOptionPane.showMessageDialog(null, "Accesso effettuato con successo!");
		                // Aggiungere qui il codice per aprire la finestra successiva
		            } else {
		                JOptionPane.showMessageDialog(null, "Username o password non validi.");
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore durante l'accesso: " + ex.getMessage());
		        }
		    }
		});
		
		btnAccedi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccedi.setBounds(215, 263, 230, 35);
		contentPane.add(btnAccedi);
		
		
		
		
		
		JButton btnPsw = new JButton("Password dimenticata?");
		btnPsw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPsw.setBounds(215, 310, 230, 35);
		contentPane.add(btnPsw);
		
		
		JButton btnBack = new JButton("Torna indietro");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(215, 357, 230, 35);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
		        
	            // Questo metodo viene chiamato quando il pulsante viene cliccato
	        	 public void actionPerformed(ActionEvent e) {
	        		Benvenuto_Form regForm =new Benvenuto_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });
	
		
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


	
	public JTextField getusername() {
		return username;
	}
	
	public JTextField getpassword() {
		return password;
	}	
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
}	    
