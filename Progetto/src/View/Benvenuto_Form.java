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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lbl = new JLabel("Benvenuto, selezionare il tipo ");

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
		setBounds(100, 100, 710, 400);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lbl.setForeground(new Color(0, 128, 0));
		lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lbl.setBounds(62, 6, 608, 94);
		contentPane.add(lbl);
		
		JButton btnD = new JButton("Dipendente");
		btnD.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnD.setBounds(62, 184, 216, 94);
		contentPane.add(btnD);
		btnD.addActionListener(new ActionListener() {
            
            // Questo metodo viene chiamato quando il pulsante viene cliccato
        	 public void actionPerformed(ActionEvent e) {
        	        
        	            Login_Form loginForm =new Login_Form();
        	            loginForm.setVisible(true);
        	            dispose(); // Chiude la finestra della prima classe
        	        
        	          
        	}
     });
		
		JButton btnC = new JButton("Cliente");
		btnC.setFont(new Font("Thonburi", Font.PLAIN, 18));
		btnC.setBounds(431, 184, 216, 94);
		contentPane.add(btnC);
		 //SIGNUP CASE   
	    btnC.addActionListener(new ActionListener() {
	        
	            // Questo metodo viene chiamato quando il pulsante viene cliccato
	        	 public void actionPerformed(ActionEvent e) {
	        		Home_Form regForm =new Home_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });
		
		JLabel lblNewLabel = new JLabel("di utente:");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		lblNewLabel.setBounds(248, 70, 280, 64);
		contentPane.add(lblNewLabel);
		
		
		
		
            
    
    

		
		
	}
}
