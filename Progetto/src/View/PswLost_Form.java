package View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class PswLost_Form extends JFrame {

    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbl1 = new JLabel("Inserire nuova password:");
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public char[] getPasswordField() {
		return passwordField.getPassword();
	}
	
	public char[] getPasswordField_1() {
		return passwordField.getPassword();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PswLost_Form frame = new PswLost_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 // creazione frame
	 
	public PswLost_Form() {
		setLocationRelativeTo(null); //centra finestra
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 400);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
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
		passwordField_1.setBounds(303, 153, 190, 40);
		contentPane.add(passwordField_1);
		
		JLabel lbl2 = new JLabel("Conferma password:");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBounds(54, 143, 193, 62);
		contentPane.add(lbl2);
	
	}



}