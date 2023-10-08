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
import javax.swing.ImageIcon;



public class Benvenuto_Form extends JFrame {

    
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnD;
	public JButton btnC;
	
	
	private final JLabel lbl2 = new JLabel("Benvenuto, selezionare il tipo ");


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

	
	 // creazione frame
	 
	public Benvenuto_Form() {
		setLocationRelativeTo(null); //centra finestra
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl2.setForeground(new Color(0, 128, 0));
		lbl2.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lbl2.setBounds(62, 6, 608, 94);
		contentPane.add(lbl2);
		
		btnD = new JButton("Dipendente");
		btnD.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnD.setBounds(62, 184, 216, 94);
		contentPane.add(btnD);
		/*btnD.addActionListener(new ActionListener() {
            
            
        	 public void actionPerformed(ActionEvent e) {
        	        
        	            Login_Form loginForm =new Login_Form();
        	            loginForm.setVisible(true);
        	            dispose(); 
        	          
        	}
     });*/
		
		JButton btnC = new JButton("Cliente");
		btnC.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnC.setBounds(431, 184, 216, 94);
		contentPane.add(btnC);
		 //SIGNUP CASE   
	    btnC.addActionListener(new ActionListener() {
	        
	            
	        	 public void actionPerformed(ActionEvent e) {
	        		Home_Form regForm =new Home_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });
		
		JLabel lbl1 = new JLabel("di utente:");
		lbl1.setForeground(new Color(0, 128, 0));
		lbl1.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lbl1.setBounds(248, 70, 280, 64);
		contentPane.add(lbl1);
		
		setVisible(true);
		
	}


	public JButton getBtnD() {
		return btnD;
	}


	public JButton getBtnC() {
		return btnC;
	}


	
	
}