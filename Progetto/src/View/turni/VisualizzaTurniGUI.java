package View.turni;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTable;

import Model.User;
import Model.dipendente.Dipendenti;
import View.DipGUI;


import javax.swing.JButton;
import javax.swing.JFrame;


import Controller.turni.VisualizzaTurniGUIController;

public class VisualizzaTurniGUI extends JFrame{
	public JTable table;
	private static JLabel lblId;
	private static int id;
	private static Dipendenti d;
	private VisualizzaTurniGUIController controller; // aggiunta del controller
	public JTable table_1;
	private String selectedValueCol1;

public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

	public void run() {

		try {

			VisualizzaTurniGUI frame = new VisualizzaTurniGUI(lblId, id, d);

			frame.setVisible(true);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

});

}


public VisualizzaTurniGUI(JLabel lblId, int id, User u) {

VisualizzaTurniGUI.lblId=lblId;
VisualizzaTurniGUI.id=id;
VisualizzaTurniGUI.d = d;

controller = new VisualizzaTurniGUIController(this);

setBounds(258, 11, 576, 520);

getContentPane().setLayout(null);

JLabel lbl = new JLabel("I tuoi turni");

lbl.setBounds(212, 8, 150, 21);

lbl.setFont(new Font("Yuppy TC", Font.PLAIN, 18));

getContentPane().add(lbl);


JPanel panel = new JPanel();

panel.setBackground(new Color(102, 204, 102));

panel.setBounds(0, 33, 562, 450);

getContentPane().add(panel);

panel.setLayout(null);


table = new JTable();

table.setBounds(11, 34, 520, 123);

JButton btnNewButton = new JButton("Torna indietro");

btnNewButton.setFont(new Font("Thonburi", Font.PLAIN, 16));

btnNewButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

		
		DipGUI cl = new DipGUI(id, d);
		cl.setLbl(lblId);

		cl.setVisible(true);

		dispose();


	}

});

btnNewButton.setBounds(211, 412, 144, 32);

panel.add(btnNewButton);



JLabel lblNewLabel = new JLabel("ID utente  " + id);
lblNewLabel.setBounds(10, 159, 98, 39);
panel.add(lblNewLabel);

table_1 = new JTable();

table_1.addMouseListener(new MouseAdapter() {

	 public void mouseClicked(MouseEvent e) {
		 int selectedRow = table_1.getSelectedRow();
            if (selectedRow != -1) {
                // Ottieni i valori delle colonne desiderate per la riga selezionata
                selectedValueCol1 = (String) table_1.getValueAt(selectedRow, 0);  // Prima colonna
               
                  }
        }
    });



table_1.setBounds(10, 23, 542, 148);
panel.add(table_1);

JButton btnNewButton_1 = new JButton("Visualizza Turni");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			controller.riempitabella(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});
btnNewButton_1.setBounds(20, 208, 184, 39);
panel.add(btnNewButton_1);



}

public int getID() {
return id;
}


public void MostraTurni(int id2, JTable table_12) {
// TODO Auto-generated method stub

}



}
