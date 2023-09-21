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
	AccountUtPannel a ;
	PrenotaPanel p1;
	PrenotazioniPanel p2;
	EliminAccountPannel ea;
	
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
		
		a = new AccountUtPannel();
		a.setSize(586, 512);
		a.setLocation(0, 0);
		p1 = new PrenotaPanel();
		p1.setSize(586, 512);
		p1.setLocation(0, 0);
		p2 = new PrenotazioniPanel();
		p2.setSize(586, 512);
		p2.setLocation(0, 0);
		ea = new EliminAccountPannel();
		ea.setSize(586, 512);
		ea.setLocation(0, 0);
		
		
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
				menuClicked(a);
				
			}
	});
		paneAcc.setBounds(0, 165, 248, 40);
		paneMenu.add(paneAcc);
		paneAcc.setBackground(new Color(102, 204, 102));
		paneAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAcc = new JLabel("Account");
		paneAcc.add(lblAcc);
		lblAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(p2);
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
				menuClicked(p1);
			}
	});
		panePr.setBounds(0, 243, 248, 40);
		paneMenu.add(panePr);
		panePr.setBackground(new Color(102, 204, 102));
		panePr.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPr = new JLabel("Prenota");
		panePr.add(lblPr);
		lblPr.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut) {
				@Override
				//chiedo conferma logout e richiamo il form benvenuto
				public void mouseClicked(MouseEvent e) {
					
					if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
						Benvenuto_Form ben = new Benvenuto_Form();
						ben.setVisible(true);
						ClienteGUI.this.dispose();
					}
					
				}
				
			});
		paneOut.setBounds(0, 321, 248, 40);
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
				menuClicked(ea);
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
		
		
		JPanel paneWindow = new JPanel();
		paneWindow.setBounds(258, 11, 576, 520);
		contentPane.add(paneWindow);
		
		paneWindow.setLayout(null);
		
		paneWindow.add(a);
		paneWindow.add(p1);
		paneWindow.add(p2);
		paneWindow.add(ea);
		
		menuClicked(a);
	}
	
	
	public void menuClicked(JPanel panel) {
		a.setVisible(false);
		p1.setVisible(false);
		p2.setVisible(false);
		ea.setVisible(false);
		
		
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
