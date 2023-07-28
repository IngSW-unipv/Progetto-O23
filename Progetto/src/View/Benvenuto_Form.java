package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Benvenuto_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbl = new JLabel("Benvenuto Utente ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benvenuto_Form frame = new Benvenuto_Form();
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
	public Benvenuto_Form() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 402);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lbl.setBounds(171, 44, 390, 108);
		contentPane.add(lbl);
		
		JButton btnReg = new JButton("Registrazione");
		btnReg.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnReg.setBounds(62, 184, 216, 94);
		contentPane.add(btnReg);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnLogin.setBounds(431, 184, 216, 94);
		contentPane.add(btnLogin);
		
		
		
		btnLogin.addActionListener(new ActionListener() {
            
                // Questo metodo viene chiamato quando il pulsante viene cliccato
            	 public void actionPerformed(ActionEvent e) {
            	        
            	            Login_Form loginForm =new Login_Form();
            	            loginForm.setVisible(true);
            	            dispose(); // Chiude la finestra della prima classe
            	        
            	          
            	}
         });
            
    
    
 //SIGNUP CASE   
    btnReg.addActionListener(new ActionListener() {
        
            // Questo metodo viene chiamato quando il pulsante viene cliccato
        	 public void actionPerformed(ActionEvent e) {
        		Registration_Form regForm =new Registration_Form();
 	            regForm.setVisible(true);
 	            dispose();
        	          
        	}
     });
		
		
	}
}
