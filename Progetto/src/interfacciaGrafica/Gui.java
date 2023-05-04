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

public class Gui extends JFrame {

    public Gui() {
        // Impostare il titolo della finestra
        super("La mia finestra GUI");

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
        public void actionPerformed(ActionEvent e) {
            // Questo metodo viene chiamato quando il pulsante viene cliccato
            System.out.println("Il pulsante è stato cliccato!");
            dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FinestraNuova finestraNuova = new FinestraNuova("login");
                    finestraNuova.setVisible(true);
                }
            });
        }
    });
    
    
 //SIGNUP CASE   
    pulsantesignup.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Questo metodo viene chiamato quando il pulsante viene cliccato
            System.out.println("Il pulsante è stato cliccato!");
            dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    FinestraNuova finestraNuova = new FinestraNuova("sign up");
                    finestraNuova.setVisible(false);
                    
                    JFrame signup = new JFrame("Sign Up");
                    signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    signup.setSize(400, 400);
                    finestraNuova.setContentPane(new JTextField (20));
                    JPanel panel = new JPanel(); // the panel is not visible in output
                    JLabel label = new JLabel("Enter Text");
                    JTextField tf = new JTextField(10);
                    JLabel label1 = new JLabel("Enter Text");
                    JTextField tf1 = new JTextField(10);
                    JLabel label2 = new JLabel("Enter Text");
                    JTextField tf2 = new JTextField(10);
                    
                    //per finire dobbiamo metter una girglia, chiedi a chatgpt e lui ti saprà aiutare
                    panel.add(label); // Components Added using Flow Layout
                    panel.add(tf);
                    panel.add(label1);
                    panel.add(tf1);
                    panel.add(label2);
                    panel.add(tf2);
                    signup.getContentPane().add(BorderLayout.SOUTH, panel);
                    signup.setVisible(true);


                }
            });
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