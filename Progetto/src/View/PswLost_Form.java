package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.UIManager;


import Controller.PswController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class PswLost_Form extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbl1 = new JLabel("Inserire nuova password:");
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;	
	private PswController controller; // aggiunta del controller

	/**
	 * Launch the application.
	 */
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
		
		controller = new PswController(this); 
		
		setLocationRelativeTo(null); //centra finestra
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{54, 50, 190, 190, 50, 0};
		gbl_contentPane.rowHeights = new int[]{40, 50, 50, 50, 51, 45, 50, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Inserire username:");
		lblNewLabel.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 2;
		contentPane.add(lbl1, gbc_lbl1);			
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel lbl2 = new JLabel("Conferma password:");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.fill = GridBagConstraints.VERTICAL;
		gbc_lbl2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2.gridx = 1;
		gbc_lbl2.gridy = 3;
		contentPane.add(lbl2, gbc_lbl2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.BOTH;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.gridx = 2;
		gbc_passwordField_1.gridy = 3;
		contentPane.add(passwordField_1, gbc_passwordField_1);
		
		JButton btn = new JButton("Aggiorna");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.insets = new Insets(0, 0, 5, 5);
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.gridx = 2;
		gbc_btn.gridy = 5;
		contentPane.add(btn, gbc_btn);
		
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