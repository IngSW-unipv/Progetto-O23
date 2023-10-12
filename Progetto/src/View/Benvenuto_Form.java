package View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{62, 216, 153, 216, 62, 0};
		gbl_contentPane.rowHeights = new int[] {90, 0, 0, 50, 94, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		lbl2.setForeground(new Color(0, 128, 0));
		lbl2.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.anchor = GridBagConstraints.NORTH;
		gbc_lbl2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2.gridwidth = 3;
		gbc_lbl2.gridx = 1;
		gbc_lbl2.gridy = 1;
		contentPane.add(lbl2, gbc_lbl2);
		
		JLabel lbl1 = new JLabel("di utente:");
		lbl1.setForeground(new Color(0, 128, 0));
		lbl1.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.anchor = GridBagConstraints.SOUTH;
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridwidth = 3;
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 2;
		contentPane.add(lbl1, gbc_lbl1);
		
		btnD = new JButton("Dipendente");
		btnD.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.fill = GridBagConstraints.BOTH;
		gbc_btnD.insets = new Insets(0, 0, 0, 5);
		gbc_btnD.gridx = 1;
		gbc_btnD.gridy = 4;
		contentPane.add(btnD, gbc_btnD);
		
		JButton btnC_1 = new JButton("Cliente");
		btnC_1.setFont(new Font("Thonburi", Font.PLAIN, 18));
		GridBagConstraints gbc_btnC_1 = new GridBagConstraints();
		gbc_btnC_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnC_1.fill = GridBagConstraints.BOTH;
		gbc_btnC_1.gridx = 3;
		gbc_btnC_1.gridy = 4;
		contentPane.add(btnC_1, gbc_btnC_1);
		//SIGNUP CASE   
	    /*btnC_1.addActionListener(new ActionListener() {
	        
	            
	        	 public void actionPerformed(ActionEvent e) {
	        		Home_Form regForm =new Home_Form();
	 	            regForm.setVisible(true);
	 	            dispose();
	        	          
	        	}
	     });*/
		/*btnD.addActionListener(new ActionListener() {
            
            
        	 public void actionPerformed(ActionEvent e) {
        	        
        	            Login_Form loginForm =new Login_Form();
        	            loginForm.setVisible(true);
        	            dispose(); 
        	          
        	}
     });*/
		
		setVisible(true);
		
	}


	public JButton getBtnD() {
		return btnD;
	}


	public JButton getBtnC() {
		return btnC;
	}


	
	
}