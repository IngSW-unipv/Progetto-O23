package View;


import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.AcController;
import Controller.ClientController;
import Controller.ClienteGUIController;
import Controller.PswController;
import Model.Cliente;
import Model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class ClienteGUI extends JFrame{
	public JPanel contentPane;
	private JLabel lblCl;
	private static int id;
	private static Cliente u;
	private JButton btnLogout;
	private JButton btnIMieiDati;
	
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI(id,u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClienteGUI(int id,Cliente u){
		ClienteGUI.id = id;
		ClienteGUI.u = u;
		
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181,247,157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(102, 204, 102));
		paneMenu.setBounds(0, 0, 248, 540);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ClienteGUI.class.getResource("/logo/Senza titolo.png")));
		lblLogo.setBounds(6, 16, 236, 135);
		paneMenu.add(lblLogo);
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = getLbl();
				PrenotazioniGUI tp =new PrenotazioniGUI(getLbl(), id, u);
				tp.setVisible(true);
				dispose();
			}
		});
		paneSt.setBounds(0, 204, 248, 40);
		paneMenu.add(paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblSt = new JLabel("Le tue prenotazioni");
		paneSt.add(lblSt);
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel panePr = new JPanel();
		/*panePr.addMouseListener(new PanelMouse(panePr){
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.riempitabella();
				JLabel lbl = getLbl();
				PrenotaGUI pr =new PrenotaGUI(getLbl(), id);
				pr.setVisible(true);
				dispose();
			}
		});*/
		panePr.setBounds(0, 243, 248, 40);
		paneMenu.add(panePr);
		panePr.setBackground(new Color(102, 204, 102));
		panePr.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblPr = new JLabel("Prenota");
		panePr.add(lblPr);
		panePr.addMouseListener(new PanelMouse(panePr){
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblPr.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel panelElAcc = new JPanel();
		panelElAcc.setToolTipText("Elimina Account");
		panelElAcc.addMouseListener(new PanelMouse(panelElAcc){
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panelElAcc.setBackground(new Color(102, 204, 102));
		panelElAcc.setBounds(0, 282, 248, 40);
		paneMenu.add(panelElAcc);
		panelElAcc.setBackground(new Color(102, 204, 102));
		panelElAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblElAcc = new JLabel("Elimina Account");
		lblElAcc.setFont(new Font("Dialog", Font.PLAIN, 16));
		panelElAcc.add(lblElAcc);
		panelElAcc.addMouseListener(new PanelMouse(panelElAcc) {
			@Override
			//chiedo conferma eliminazione e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare il tuo account?") == 0) {
					Benvenuto_Form ben = new Benvenuto_Form();
					ben.setVisible(true);
					ClienteGUI.this.dispose();
				}
			}
		});
		
		btnLogout = new JButton("Log Out");
		btnLogout.setBackground(new Color(102, 204, 102));
		btnLogout.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLogout.setBounds(0, 322, 248, 40);
		paneMenu.add(btnLogout);
		
		btnIMieiDati = new JButton("I miei dati");
		btnIMieiDati.setToolTipText("");
		btnIMieiDati.setForeground(Color.BLACK);
		btnIMieiDati.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnIMieiDati.setBackground(new Color(102, 204, 102));
		btnIMieiDati.setBounds(0, 165, 248, 40);
		paneMenu.add(btnIMieiDati);
		
		JLabel lblNewLabel = new JLabel("Id cliente:");
		lblNewLabel.setBounds(728, 6, 60, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Thonburi", Font.PLAIN, 12));
		
		JLabel lblCl = new JLabel();
		lblCl.setText(String.valueOf(id));
		lblCl.setBounds(790, 5, 64, 20);
    	contentPane.add(lblCl);
    	setVisible(true);
	}
	
	public JLabel getLbl() {
		return lblCl;
	}
	
	public void setLbl(JLabel lblcl) {
		this.lblCl = lblcl;
	}
	
	private class PanelMouse extends MouseAdapter {
		JPanel contentPane;
		public PanelMouse(JPanel contentPane) {
			this.contentPane=contentPane;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			contentPane.setBackground(new Color(102, 204, 102));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}

	public JButton getBtnIMieiDati() {
		return btnIMieiDati;
	}

	public void setBtnIMieiDati(JButton btnIMieiDati) {
		this.btnIMieiDati = btnIMieiDati;
	}

	
	
	
	
}