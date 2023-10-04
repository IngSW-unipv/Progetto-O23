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
import Model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class DipGUI extends JFrame{
	public AcController controller;
	public JPanel contentPane;
	public JLabel lblDip;  //////////////
	private static int id;
	private static User u;
	
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

	public DipGUI(int id,User u){
		
		DipGUI.id = id;
		DipGUI.u=u;
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 562);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
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
		JPanel paneAcc = new JPanel();
		paneAcc.addMouseListener(new PanelMouse(paneAcc){
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountDip dip =new AccountDip(getLbl(), id,u);
				dip.setVisible(true);
				dispose();
			}
		});
		paneAcc.setBounds(0, 230, 248, 40);
		paneMenu.add(paneAcc);
		paneAcc.setBackground(new Color(102, 204, 102));
		paneAcc.setLayout(null);
		JLabel lblAcc = new JLabel("Account");
		lblAcc.setBounds(91, 5, 65, 23);
		paneAcc.add(lblAcc);
		lblAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt) {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImieiTurniGUI tu =new ImieiTurniGUI(getLbl(), id);
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
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut) {
			@Override
			//chiedo conferma logout e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
					Benvenuto_Form ben = new Benvenuto_Form();
					ben.setVisible(true);
					DipGUI.this.dispose();
				}
			}
		});
		paneOut.setBounds(0, 308, 248, 40);
		paneMenu.add(paneOut);
		paneOut.setBackground(new Color(102, 204, 102));
		paneOut.setLayout(null);
		JLabel lblOut = new JLabel("Logout");
		lblOut.setBounds(96, 6, 55, 23);
		paneOut.add(lblOut);
		lblOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JLabel lblTitolo = new JLabel("Welcome");
		lblTitolo.setBounds(28, 168, 197, 51);
		paneMenu.add(lblTitolo);
		lblTitolo.setFont(new Font("Yuppy TC", Font.PLAIN, 45));
		
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