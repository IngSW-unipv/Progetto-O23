package interfacciaGrafica;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Benvenuto_Form extends JFrame {

    public Benvenuto_Form() {
        // Impostare il titolo della finestra
        super("Benvenuto");

        // Creare un layout con le griglie
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        // Creare i bottoni
        JButton pulsantelogin = new JButton("Login");
        JButton pulsantesignup = new JButton("Sign up");
        
        
    

        // Impostare le dimensioni preferite dei bottoni
        Dimension dimensioniBottoni = new Dimension(80, 30);
        pulsantelogin.setPreferredSize(dimensioniBottoni);
        pulsantesignup.setPreferredSize(dimensioniBottoni);

        // Impostare i vincoli del GridBagConstraints per centrare i bottoni
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;  // Non estendere i bottoni
        gbc.gridx = 0;  // Colonna 0
        gbc.gridy = 0;  // Riga 0
        gbc.weightx = 0.5;  // Peso orizzontale
        gbc.ipadx = 50;  // Padding orizzontale
        gbc.ipady = 20;  // Padding verticale
        add(pulsantelogin, gbc);

        gbc.gridx = 1;  // Colonna 1
        gbc.weightx = 0.5;  // Peso orizzontale
        gbc.ipadx = 50;  // Padding orizzontale
        gbc.ipady = 20;  // Padding verticale
        add(pulsantesignup, gbc);

        // Centrare la finestra nella schermata
        setLocationRelativeTo(null);

        // Impostare il comportamento di default alla chiusura della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mostrare la finestra
        pack();
        setVisible(true);
    
    
    //NEW WINDOWS
//LOGIN CASE    
        pulsantelogin.addActionListener(new ActionListener() {
            @Override
                // Questo metodo viene chiamato quando il pulsante viene cliccato
            	 public void actionPerformed(ActionEvent e) {
            	        if (e.getSource() == pulsantelogin) {
            	            new Login_Form();
            	            dispose(); // Chiude la finestra della prima classe
            	        }
            	          
            	}
         });
            
    
    
 //SIGNUP CASE   
    pulsantesignup.addActionListener(new ActionListener() {
        @Override
            // Questo metodo viene chiamato quando il pulsante viene cliccato
        	 public void actionPerformed(ActionEvent e) {
        	        if (e.getSource() == pulsantesignup) {
        	            new SignUp_Form();
        	            dispose(); // Chiude la finestra della prima classe
        	        }
        	          
        	}
     });
        }

   
    class FinestraNuova extends JFrame {

        public FinestraNuova(String titolo) {
            // Impostare il titolo della nuova finestra
            super(titolo);

            // Creare un pannello di contenuti
            JPanel contenuto = new JPanel();

            // Aggiungere un'etichetta al pannello di contenuti
            contenuto.add(new JLabel("Questo è il contenuto della nuova finestra"));

            // Aggiungere il pannello di contenuti alla finestra
            add(contenuto);

            // Impostare il comportamento di default alla chiusura della finestra
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Centrare la finestra nella schermata
            setLocationRelativeTo(null);

            // Mostrare la nuova finestra
            pack();
            setVisible(true);
        }
    }
}
