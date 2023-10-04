package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

import Controller.LoginController;
import Controller.PswController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class PswLost_Form extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbl1 = new JLabel("Inserire nuova password:");
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;	
	private PswController controller; // aggiunta del controller

	 // creazione frame
	public PswLost_Form() {
		
		controller = new PswController(this); 
		
		setLocationRelativeTo(null); //centra finestra
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl1.setBounds(54, 69, 193, 62);
		contentPane.add(lbl1);			
		
		JButton btn = new JButton("Aggiorna");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn.setBounds(303, 236, 190, 50);
		contentPane.add(btn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		passwordField.setBounds(303, 81, 190, 40);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		passwordField_1.setBounds(303, 140, 190, 40);
		contentPane.add(passwordField_1);
		
		JLabel lbl2 = new JLabel("Conferma password:");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBounds(54, 129, 193, 62);
		contentPane.add(lbl2);
		
		JLabel lblNewLabel = new JLabel("Inserire username:");
		lblNewLabel.setFont(new Font("Thonburi", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 6, 193, 62);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(303, 19, 190, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.modifyPassword();;	//delego lavoro al controller
			}
			
		});
		
		}
		
	public String getUsername() {
		return textField.getText();
	}
	
	public String getPassword() {
		return new String (passwordField.getPassword());
	}
	
	public String GetPasswordConferma() {
		return  new String (passwordField_1.getPassword());
	}
	

	
}