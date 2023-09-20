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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ClienteGUI extends JFrame{
	
	private JPanel contentPane;
	private AccountUtPannel account;
	private PrenotaPanel prenota;
	private PrenotazioniPanel prenotazioni;
	private EliminAccountPannel elimina;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ClienteGUI(){
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 562);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		account = new AccountUtPannel();
		elimina = new EliminAccountPannel();
		prenota = new PrenotaPanel();
		prenotazioni = new PrenotazioniPanel();
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(102, 204, 102));
		paneMenu.setBounds(0, 0, 248, 540);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ClienteGUI.class.getResource("/logo/Senza titolo.png")));
		lblLogo.setBounds(6, 16, 236, 135);
		paneMenu.add(lblLogo);
		
		JPanel paneAcc = new JPanel();
		paneAcc.addMouseListener(new PanelMouse(paneAcc){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(account);
			}
	});
		paneAcc.setBounds(0, 165, 248, 40);
		paneMenu.add(paneAcc);
		paneAcc.setBackground(new Color(102, 204, 102));
		paneAcc.setLayout(null);
		
		JLabel lblAcc = new JLabel("Account");
		lblAcc.setBounds(91, 5, 65, 23);
		paneAcc.add(lblAcc);
		lblAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(prenotazioni);
			}
	});
		paneSt.setBounds(0, 204, 248, 40);
		paneMenu.add(paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(null);
		
		JLabel lblSt = new JLabel("Le tue prenotazioni");
		lblSt.setBounds(49, 5, 149, 23);
		paneSt.add(lblSt);
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel panePr = new JPanel();
		panePr.addMouseListener(new PanelMouse(panePr){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(prenota);
			}
	});
		panePr.setBounds(0, 243, 248, 40);
		paneMenu.add(panePr);
		panePr.setBackground(new Color(102, 204, 102));
		panePr.setLayout(null);
		
		JLabel lblPr = new JLabel("Prenota");
		lblPr.setBounds(94, 6, 59, 23);
		panePr.add(lblPr);
		lblPr.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut) {
				@Override
				//chiedo conferma logout e richiamo il form benvenuto
				public void mouseClicked(MouseEvent e) {
					
					if (JOptionPane.showConfirmDialog(null, "sei sicuro") == 0) {
						Benvenuto_Form ben = new Benvenuto_Form();
						ben.setVisible(true);
						ClienteGUI.this.dispose();
					}
					
				}
				
			});
		paneOut.setBounds(0, 324, 248, 40);
		paneMenu.add(paneOut);
		paneOut.setBackground(new Color(102, 204, 102));
		paneOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JLabel lblOut = new JLabel("Logout");
		lblOut.setBounds(96, 6, 55, 23);
		paneOut.add(lblOut);
		lblOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel panelElAcc = new JPanel();
		panelElAcc.setToolTipText("Elimina Account");
		panelElAcc.addMouseListener(new PanelMouse(panelElAcc){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(elimina);
			}
	});
		panelElAcc.setBackground(new Color(102, 204, 102));
		panelElAcc.setBounds(0, 283, 248, 40);
		paneMenu.add(panelElAcc);
		panelElAcc.setBackground(new Color(102, 204, 102));
		panelElAcc.setLayout(null);
		
		JLabel lblElAcc = new JLabel("Elimina Account");
		lblElAcc.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblElAcc.setBounds(64, 11, 125, 18);
		panelElAcc.add(lblElAcc);
		
		JPanel paneWindow = new JPanel();
		paneWindow.setBounds(258, 11, 576, 501);
		contentPane.add(paneWindow);
		
		paneWindow.add(account);
		paneWindow.add(elimina);
		paneWindow.add(prenota);
		paneWindow.add(prenotazioni);
		
		menuClicked(account);
	}
	
	
	public void menuClicked(JPanel panel) {
		account.setVisible(false);
		elimina.setVisible(false);
		prenota.setVisible(false);
		prenotazioni.setVisible(false);
		
		
		panel.setVisible(true);
		
		
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
