package interfacciaGrafica;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Login_Success_GUI extends JFrame implements ActionListener {
    private JButton Prenota;
    private JButton EliminaACC;
    private JButton IMieiOrdini;
    private JButton LogOut;

    public Login_Success_GUI() {
        super("Benvenuto " + "Username"); //to fix, we need username showing
        
     // Centrare la finestra nella schermata
        setLocationRelativeTo(null);
        
        
        //creazione pulsante per prenota
        Prenota = new JButton("Prenota una stanza");
        Prenota.addActionListener(this);
        
        //creazione pulsante per EliminaACC
        EliminaACC = new JButton("Elimina Account");
        EliminaACC.addActionListener(this);
        
        //creazione pulsante per IMieiOrdini
        IMieiOrdini = new JButton("I miei ordini");
        IMieiOrdini.addActionListener(this);
        
        //creazione pulsante per LogOut
        LogOut = new JButton("esci");
        LogOut.addActionListener(this);
/*        
        // Creazione etichette
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel tornaindietroLabel = new JLabel("torna indietro:");
*/        
        
        // Aggiunta componenti alla GUI
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(IMieiOrdini);
        panel.add(Prenota);
        panel.add(EliminaACC);
        panel.add(LogOut);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
        
        
      //IMieiOrdini CASE    
        IMieiOrdini.addActionListener(new ActionListener() {
            @Override
                // Questo metodo viene chiamato quando il pulsante viene cliccato
            	 public void actionPerformed(ActionEvent e) {
            	        if (e.getSource() == IMieiOrdini) {
            	            new IMieiOrdini_Form();
            	            dispose(); // Chiude la finestra della prima classe
            	        }
            	          
            	}
         });
        
        //Prenota CASE    
        Prenota.addActionListener(new ActionListener() {
            @Override
                // Questo metodo viene chiamato quando il pulsante viene cliccato
            	 public void actionPerformed(ActionEvent e) {
            	        if (e.getSource() == Prenota) {
            	            new Prenota_Form();
            	            dispose(); // Chiude la finestra della prima classe
            	        }
            	          
            	}
         });
        
        //EliminaACC CASE    
        EliminaACC.addActionListener(new ActionListener() {
            @Override
                // Questo metodo viene chiamato quando il pulsante viene cliccato
            	 public void actionPerformed(ActionEvent e) {
            	        if (e.getSource() == EliminaACC) {
            	            new EliminaACC_Form();
            	            dispose(); // Chiude la finestra della prima classe
            	        }
            	          
            	}
         });
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