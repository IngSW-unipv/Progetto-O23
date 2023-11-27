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

import Model.User;
import Model.dipendente.Dipendenti;
import logout.controller.LogOutCliController;
import logout.controller.LogOutDipController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class DipGUI extends JFrame{

	public JPanel contentPane;
	public JLabel lblDip;  //////////////
	private static int id;
	private static Dipendenti u;
	
	
	//private AccountDip account;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DipGUI frame = new DipGUI(id,u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DipGUI(int id,Dipendenti u){
		
		DipGUI.id = id;
		DipGUI.u=u;
		
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
		lblLogo.setIcon(new ImageIcon(DipGUI.class.getResource("/logo/Senza titolo.png")));
		lblLogo.setBounds(6, 12, 236, 135);
		paneMenu.add(lblLogo);
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt) {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImieiTurniGUI tu =new ImieiTurniGUI(getLbl(), id, u);
				tu.setVisible(true);
				dispose();
			}
		});
		paneSt.setBounds(0, 269, 248, 40);
		paneMenu.add(paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(null);
		JLabel lblSt = new JLabel("Visualizza turni");
		lblSt.setBounds(66, 6, 122, 23);
		paneSt.add(lblSt);
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JLabel lblTitolo = new JLabel("Welcome");
		lblTitolo.setBounds(28, 168, 197, 51);
		paneMenu.add(lblTitolo);
		lblTitolo.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		
		JPanel paneDati = new JPanel();
		paneDati.setBackground(new Color(102, 204, 102));
		paneDati.setBounds(0, 230, 248, 40);
		paneMenu.add(paneDati);
		paneDati.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		paneDati.addMouseListener(new PanelMouse(paneDati){
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JLabel lbl = getLbl();
				AccountDip dip =new AccountDip(getLbl(), id,u);
				dip.setVisible(true);
				
			}
		});
		
		JLabel lblIMieiDati = new JLabel("I miei dati");
		lblIMieiDati.setFont(new Font("Dialog", Font.PLAIN, 16));
		paneDati.add(lblIMieiDati);
		
		JPanel panelLogOut = new JPanel();
		panelLogOut.setToolTipText("Log out");
		panelLogOut.setBackground(new Color(102, 204, 102));
		panelLogOut.setBounds(0, 309, 248, 40);
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
				LogOutDipController controller = new LogOutDipController(opzione, u);
				controller.actionPerformed(e);
				dispose();
			}
		});
		
		
		JLabel lbl = new JLabel("Id lavoratore:");
		lbl.setBounds(715, 6, 78, 16);
		contentPane.add(lbl);
		lbl.setFont(new Font("Thonburi", Font.PLAIN, 12));
		
		JLabel lblDip = new JLabel();
		lblDip.setText(String.valueOf(id));
		lblDip.setBounds(795, 5, 64, 20);
    	contentPane.add(lblDip);
    	setVisible(true);
		
		/////////////////////////
		
		
		
	}
	
	public JLabel getLbl() {
		return lblDip;
	}
	
	public void setLbl(JLabel lbldip) {
		this.lblDip = lbldip;
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
			contentPane.setBackground(new Color(102, 204, 102));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			contentPane.setBackground(new Color(102, 204, 102));
		}
		
	}


	
	
}