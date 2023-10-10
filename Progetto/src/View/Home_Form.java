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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class Home_Form extends JFrame {

	private JPanel contentPane;
	

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
		setBounds(100, 100, 726, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{62, 216, 153, 216, 62, 0};
		gbl_contentPane.rowHeights = new int[] {90, 0, 0, 0, 50, 94, 40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbl = new JLabel("Benvenuto cliente,");
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.fill = GridBagConstraints.VERTICAL;
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridwidth = 3;
		gbc_lbl.gridx = 1;
		gbc_lbl.gridy = 1;
		contentPane.add(lbl, gbc_lbl);
		
		
		
		JButton btnReg = new JButton("Registrazione");
		btnReg.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_btnReg = new GridBagConstraints();
		gbc_btnReg.fill = GridBagConstraints.BOTH;
		gbc_btnReg.insets = new Insets(0, 0, 5, 5);
		gbc_btnReg.gridx = 1;
		gbc_btnReg.gridy = 5;
		contentPane.add(btnReg, gbc_btnReg);
		
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
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 5;
		contentPane.add(btnLogin, gbc_btnLogin);
		
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
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.fill = GridBagConstraints.VERTICAL;
		gbc_btnBack.gridwidth = 3;
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 6;
		contentPane.add(btnBack, gbc_btnBack);
		
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
