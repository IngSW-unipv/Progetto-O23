package View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home_Form extends JFrame {

	private JPanel contentPane;
	private final JLabel lbl = new JLabel("Benvenuto cliente,");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Form frame = new Home_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Home_Form() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lbl.setBounds(171, 44, 390, 108);
		contentPane.add(lbl);
		
		JButton btnReg = new JButton("Registrazione");
		btnReg.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnReg.setBounds(92, 184, 216, 94);
		contentPane.add(btnReg);
		
		//SIGNUP CASE   
	    btnReg.addActionListener(new ActionListener() {
	        
	        	 public void actionPerformed(ActionEvent e) {
	        		Registration_Form regForm =new Registration_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnLogin.setBounds(413, 184, 216, 94);
		contentPane.add(btnLogin);
		
		//LOGIN CASE
		btnLogin.addActionListener(new ActionListener() {
            
            
        	 public void actionPerformed(ActionEvent e) {
        	        
        	            Login_Form loginForm =new Login_Form();
        	            loginForm.setVisible(true);
        	            dispose(); 
        	        
        	          
        	}
     });
        
		
		JButton btnBack = new JButton("Torna indietro");
		btnBack.setFont(new Font("Thonburi", Font.PLAIN, 16));
		btnBack.setBounds(278, 304, 161, 38);
		contentPane.add(btnBack);
		
		 //SIGNUP CASE   
	    btnBack.addActionListener(new ActionListener() {
	        
	        
	        	 public void actionPerformed(ActionEvent e) {
	        		Benvenuto_Form regForm =new Benvenuto_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });
		
		
		
		
    
    

		
		
	}
}
