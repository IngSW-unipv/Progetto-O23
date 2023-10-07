package View;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Model.Cliente;
import Model.User;

import java.awt.Color;



public class Registration_Form extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField nome;
    public JTextField cognome;
    public JTextField cf;
    public String giorni[]
            = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
    public String mesi[]
            = { "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12" };
    public String anni[]
            = { "1980", "1981", "1982", "1983",
            	"1984", "1985", "1986", "1987",
            	"1988", "1989", "1990", "1991",
            	"1992", "1993", "1994", "1995",
            	"1996", "1997", "1998", "1999",
                "2000", "2001", "2002", "2003",
               };
    public JComboBox data;
    public JComboBox mese;
    public JComboBox anno;
    public JTextField email;
    public JTextField cell;
    public JTextField via;
    public JTextField citta;        
    public JTextField provincia;
    public JTextField cap;
    public JTextField username;    
    public JPasswordField password;
    public JButton btnReg;
    public JButton btnBack;

    
        
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration_Form frame = new Registration_Form();
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

    public Registration_Form() {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1124, 661);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(181,247,157));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblReg = new JLabel("Registrazione");
        lblReg.setForeground(new Color(154, 205, 50));
        lblReg.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
        lblReg.setBounds(429, 18, 270, 50);
        contentPane.add(lblReg);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblNome.setBounds(58, 101, 99, 16);
        contentPane.add(lblNome);

        JLabel lblCognome = new JLabel("Cognome:");
        lblCognome.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblCognome.setBounds(520, 95, 110, 29);
        contentPane.add(lblCognome);
        
        data = new JComboBox(giorni);
        data.setFont(new Font("Arial", Font.PLAIN, 16));
        data.setSize(72, 20);
        data.setLocation(707, 159);
        contentPane.add(data);
 
        mese = new JComboBox(mesi);
        mese.setFont(new Font("Arial", Font.PLAIN, 16));
        mese.setSize(80, 20);
        mese.setLocation(791, 159);
        contentPane.add(mese);
 
        anno = new JComboBox(anni);
        anno.setFont(new Font("Arial", Font.PLAIN, 16));
        anno.setSize(88, 20);
        anno.setLocation(883, 159);
        contentPane.add(anno);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblEmail.setBounds(58, 222, 124, 16);
        contentPane.add(lblEmail);

        nome = new JTextField();
        nome.setFont(new Font("Thonburi", Font.PLAIN, 18));
        nome.setBounds(214, 80, 225, 50);
        contentPane.add(nome);
        nome.setColumns(10);

        cognome = new JTextField();
        cognome.setFont(new Font("Thonburi", Font.PLAIN, 18));
        cognome.setBounds(710, 80, 225, 50);
        contentPane.add(cognome);
        cognome.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Thonburi", Font.PLAIN, 18));
        email.setBounds(214, 205, 225, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Thonburi", Font.PLAIN, 18));
        username.setBounds(214, 392, 225, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblUsername.setBounds(58, 408, 99, 26);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblPassword.setBounds(520, 409, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Cell:");
        lblMobileNumber.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblMobileNumber.setBounds(520, 225, 139, 18);
        contentPane.add(lblMobileNumber);

        cell = new JTextField();
        cell.setFont(new Font("Thonburi", Font.PLAIN, 18));
        cell.setBounds(707, 205, 228, 50);
        contentPane.add(cell);
        cell.setColumns(10);

        password = new JPasswordField();
        password.setFont(new Font("Thonburi", Font.PLAIN, 18));
        password.setBounds(707, 392, 225, 50);
        contentPane.add(password);

        btnReg = new JButton("Registrati");     
        btnReg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnReg.setBounds(619, 513, 180, 70);
        contentPane.add(btnReg);
        
        JLabel lblDate = new JLabel("Data Di Nascita: ");
        lblDate.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblDate.setForeground(new Color(0, 0, 0));
        lblDate.setBounds(520, 163, 159, 16);
        contentPane.add(lblDate);
        
        JLabel lblVia = new JLabel("Via:");
        lblVia.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblVia.setBounds(58, 281, 112, 16);
        contentPane.add(lblVia);
        
        JLabel lbnCitta = new JLabel("Città :");
        lbnCitta.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lbnCitta.setBounds(520, 276, 99, 26);
        contentPane.add(lbnCitta);
        
        via = new JTextField();
        via.setFont(new Font("Thonburi", Font.PLAIN, 18));
        via.setBounds(214, 267, 225, 50);
        contentPane.add(via);
        via.setColumns(10);
        
        citta = new JTextField();
        citta.setFont(new Font("Thonburi", Font.PLAIN, 18));
        citta.setBounds(707, 267, 225, 50);
        contentPane.add(citta);
        citta.setColumns(10);
        
        JLabel lblCF = new JLabel("Codice Fiscale:");
        lblCF.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblCF.setBounds(58, 163, 133, 16);
        contentPane.add(lblCF);
        
        cf = new JTextField();
        cf.setFont(new Font("Thonburi", Font.PLAIN, 18));
        cf.setBounds(214, 143, 225, 50);
        contentPane.add(cf);
        cf.setColumns(10);
        
        JLabel lblProv = new JLabel("Provincia:");
        lblProv.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblProv.setBounds(58, 343, 99, 16);
        contentPane.add(lblProv);
        
        provincia = new JTextField();
        provincia.setFont(new Font("Thonburi", Font.PLAIN, 18));
        provincia.setBounds(214, 329, 225, 50);
        contentPane.add(provincia);
        provincia.setColumns(10);
        
        JLabel lblCAP = new JLabel("CAP:");
        lblCAP.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lblCAP.setBounds(520, 346, 61, 16);
        contentPane.add(lblCAP);
        
        cap = new JTextField();
        cap.setFont(new Font("Thonburi", Font.PLAIN, 18));
        cap.setBounds(707, 329, 225, 50);
        contentPane.add(cap);
        cap.setColumns(10);
        
        JButton btnIndietro = new JButton("Indietro");
        btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnIndietro.setBounds(350, 513, 180, 70);
        contentPane.add(btnIndietro);
        
        setVisible(true);
             
        
    }
    
    

	public JButton getBtnReg() {
		return btnReg;
	}

	public void setBtnReg(JButton btnReg) {
		this.btnReg = btnReg;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JComboBox getData() {
		return data;
	}

	public void setData(JComboBox data) {
		this.data = data;
	}

	public JComboBox getMese() {
		return mese;
	}

	public void setMese(JComboBox mese) {
		this.mese = mese;
	}

	public JComboBox getAnno() {
		return anno;
	}

	public void setAnno(JComboBox anno) {
		this.anno = anno;
	}
}