package interfacciaGrafica;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.*;

public class SignUp_Form extends JFrame implements ActionListener {
    private JTextField nomeCampo;
    private JTextField cognomeCampo;
    private JTextField emailCampo;
    private JTextField CFCampo;
    private JTextField DataNascitaCampo;
    
    private JDateChooser DateChooser;
    
    private JPasswordField passwordCampo;
    private JButton registratiButton;
    private JButton BackButton;

    public SignUp_Form() {
        super("Registrazione Utente");
        
     // Centrare la finestra nella schermata
        setLocationRelativeTo(null);

        
        //creazione calendar
        DateChooser = new JDateChooser();
        DateChooser.setBounds(320,90,200,30);

        
        // Creazione campi di testo
        nomeCampo = new JTextField(20);
        cognomeCampo = new JTextField(20);
        CFCampo = new JTextField(20);
        DataNascitaCampo = new JTextField(8);
        emailCampo = new JTextField(20);
        passwordCampo = new JPasswordField(20);
        
        
        // Creazione pulsante di registrazione
        registratiButton = new JButton("Registrati");
        registratiButton.addActionListener(this);
        
        //creazione pulsante per tornare indietro
        
        BackButton = new JButton("Torna indietro");
        BackButton.addActionListener(this);
        
        // Creazione etichette
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel cognomeLabel = new JLabel("Cognome:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel CFLabel = new JLabel("Codice Fiscale:");
        JLabel tornaindietroLabel = new JLabel("torna indietro:");
        JLabel DataNascitaLabel = new JLabel("Data Di nascita");
        
        // Aggiunta componenti alla GUI
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(nomeLabel);
        panel.add(nomeCampo);
        panel.add(cognomeLabel);
        panel.add(cognomeCampo);
        panel.add(DataNascitaLabel);
        panel.add(DateChooser);
        panel.add(CFLabel);
        panel.add(CFCampo);
        panel.add(emailLabel);
        panel.add(emailCampo);
        panel.add(passwordLabel);
        panel.add(passwordCampo);
        panel.add(new JLabel()); // Aggiunta di una riga vuota
        panel.add(registratiButton);
        panel.add(tornaindietroLabel);
        panel.add(BackButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Qui puoi inserire il codice per la registrazione dell'utente
        // Utilizzando i dati inseriti nei campi di testo
        // Quando l'utente ha completato la registrazione, puoi chiudere la finestra della GUI

        dispose();
    }

 //   public static void main(String[] args) {
 //       new RegistrazioneUtente();
 //   }
}