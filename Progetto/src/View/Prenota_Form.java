package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prenota_Form extends JFrame implements ActionListener {
 

    public Prenota_Form() {
        super("Prenota una stanza"); 
        
     // Centrare la finestra nella schermata
        setLocationRelativeTo(null);
        
             
        
        // Aggiunta componenti alla GUI
        JPanel panel = new JPanel(new GridLayout(6, 2));
     
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
        
        
      //
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