package interfacciaGrafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login_Form extends JFrame implements ActionListener {
   private JTextField emailCampo;
    private JPasswordField passwordCampo;
    private JButton LoginButton;
    private JButton BackButton;
    private JButton PasswordDimenticataButton;

    public Login_Form() {
        super("Registrazione Utente");
        
     // Centrare la finestra nella schermata
        setLocationRelativeTo(null);


        // Creazione campi di testo
        emailCampo = new JTextField(20);
        passwordCampo = new JPasswordField(20);
        
        
        // Creazione pulsante di registrazione
        LoginButton = new JButton("Accedi al tuo account");
        LoginButton.addActionListener(this);
        
        //creazione pulsante per tornare indietro
        
        BackButton = new JButton("Torna indietro");
        BackButton.addActionListener(this);
        
        //creazione pulsante per password dimenticata
        PasswordDimenticataButton = new JButton("Password dimenticata?");
        PasswordDimenticataButton.addActionListener(this);
        
        // Creazione etichette
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel tornaindietroLabel = new JLabel("torna indietro:");
        
        // Aggiunta componenti alla GUI
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(emailLabel);
        panel.add(emailCampo);
        panel.add(passwordLabel);
        panel.add(passwordCampo);
        panel.add(new JLabel()); // Aggiunta di una riga vuota
        panel.add(LoginButton);
        panel.add(new JLabel());
        panel.add(PasswordDimenticataButton);
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