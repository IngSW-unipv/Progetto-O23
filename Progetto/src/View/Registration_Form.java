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
import javax.swing.border.EmptyBorder;

import Model.User;

import java.awt.Color;



public class Registration_Form extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nome;
    private JTextField cognome;
    private JTextField cf;
    private String date[]
            = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
        private String mesi[]
            = { "Jan", "feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sup", "Oct", "Nov", "Dec" };
        private String anni[]
            = { "1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019" };
    private JComboBox data;
    private JComboBox mese;
    private JComboBox anno;
    private JTextField email;
    private JTextField cell;
    private JTextField via;
    private JTextField città;        
    private JTextField provincia;
    private JTextField cap;
    private JTextField username;    
    private JPasswordField password;
    private JButton btnReg;
    private JButton btnBack;

    
        
    
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
        
        data = new JComboBox(date);
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
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User(cf.getText(), nome.getText(), cognome.getText(), java.sql.Date.valueOf(anno.getSelectedItem()+"-"+(mese.getSelectedIndex()+1)+"-"+data.getSelectedItem()), cell.getText(), via.getText(), città.getText(), provincia.getText(), Integer.parseInt(cap.getText()), email.getText(), username.getText(), new String(password.getPassword()));
                    user.registrazione(cf.getText(), nome.getText(), cognome.getText(), java.sql.Date.valueOf(anno.getSelectedItem()+"-"+(mese.getSelectedIndex()+1)+"-"+data.getSelectedItem()).toString(), cell.getText(), via.getText(), città.getText(), provincia.getText(), Integer.parseInt(cap.getText()), email.getText(), username.getText(), new String(password.getPassword()));
                    JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo!");
                } catch (SQLException | NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante la registrazione: " + ex.getMessage());
                } 
           
            } 
        });
        
                
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
        
        JLabel lbnCitta = new JLabel("Città:");
        lbnCitta.setFont(new Font("Thonburi", Font.PLAIN, 18));
        lbnCitta.setBounds(520, 276, 99, 26);
        contentPane.add(lbnCitta);
        
        via = new JTextField();
        via.setFont(new Font("Thonburi", Font.PLAIN, 18));
        via.setBounds(214, 267, 225, 50);
        contentPane.add(via);
        via.setColumns(10);
        
        città = new JTextField();
        città.setFont(new Font("Thonburi", Font.PLAIN, 18));
        città.setBounds(707, 267, 225, 50);
        contentPane.add(città);
        città.setColumns(10);
        
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
        
        JButton btnBack = new JButton("Torna indietro");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBack.setBounds(341, 513, 180, 70);
        contentPane.add(btnBack);
    }
}