package View;


import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import Model.Cliente;
import View.prenota.PrenotaGUI;
import View.prenotazione.PrenotazioniGUI;
import logout.controller.LogOutCliController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;

public class ClienteGUI extends JFrame{
	public JPanel contentPane;
	private JLabel lblCl;
	private static int id;
	private static Cliente u;
	
	
	 
	
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
		panePr.addMouseListener(new PanelMouse(panePr){
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotaGUI prenota = new PrenotaGUI(lblCl, id);
				prenota.setVisible(true);
				ClienteGUI.this.dispose();
			}
		});
		
		
		panePr.setBounds(0, 243, 248, 40);
		paneMenu.add(panePr);
		panePr.setBackground(new Color(102, 204, 102));
		panePr.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblPr = new JLabel("Prenota");
		panePr.add(lblPr);
		
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
		
		JPanel paneDati = new JPanel();
		paneDati .setBackground(new Color(102, 204, 102));
		paneDati .setBounds(0, 165, 248, 40);
		paneMenu.add(paneDati );
		paneDati .setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIMieiDati = new JLabel("I miei dati");
		lblIMieiDati.setFont(new Font("Dialog", Font.PLAIN, 16));
		paneDati .add(lblIMieiDati);
		paneDati.addMouseListener(new PanelMouse(paneDati){
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JLabel lbl = getLbl();
				AccountCl cl =new AccountCl(getLbl(), id,u);
				cl.setVisible(true);
				
			}
		});
		
		JPanel panelLogOut = new JPanel();
		panelLogOut.setToolTipText("Log Out");
		panelLogOut.setBackground(new Color(102, 204, 102));
		panelLogOut.setBounds(0, 320, 248, 40);
		paneMenu.add(panelLogOut);
		panelLogOut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.setFont(new Font("Dialog", Font.PLAIN, 16));
		panelLogOut.add(lblLogOut);
		
		panelLogOut.addMouseListener(new PanelMouse(panelLogOut) {
			@Override
			//chiedo conferma logout e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				JOptionPane opzione = null;
				LogOutCliController controller = new LogOutCliController(opzione, u);
				controller.actionPerformed(e);
				dispose();
			}
		});
		
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



}