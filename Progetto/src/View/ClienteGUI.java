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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ClienteGUI extends JFrame{
	
	private JPanel contentPane;
	
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
		paneAcc.addMouseListener(new PanelMouse(paneAcc));
		paneAcc.setBounds(0, 165, 248, 40);
		paneMenu.add(paneAcc);
		paneAcc.setBackground(new Color(102, 204, 102));
		paneAcc.setLayout(null);
		
		JLabel lblAcc = new JLabel("Account");
		lblAcc.setBounds(91, 5, 65, 23);
		paneAcc.add(lblAcc);
		lblAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt));
		paneSt.setBounds(0, 204, 248, 40);
		paneMenu.add(paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(null);
		
		JLabel lblSt = new JLabel("Le tue prenotazioni");
		lblSt.setBounds(49, 5, 149, 23);
		paneSt.add(lblSt);
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel panePr = new JPanel();
		panePr.addMouseListener(new PanelMouse(panePr));
		panePr.setBounds(0, 243, 248, 40);
		paneMenu.add(panePr);
		panePr.setBackground(new Color(102, 204, 102));
		panePr.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(94, 16, 0, 0);
		panePr.add(label);
		
		JLabel lblPr = new JLabel("Prenota");
		lblPr.setBounds(94, 6, 59, 23);
		panePr.add(lblPr);
		lblPr.setFont(new Font("Thonburi", Font.PLAIN, 16));
		
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut));
		paneOut.setBounds(0, 282, 248, 40);
		paneMenu.add(paneOut);
		paneOut.setBackground(new Color(102, 204, 102));
		paneOut.setLayout(null);
		
		JLabel lblOut = new JLabel("Logout");
		lblOut.setBounds(96, 6, 55, 23);
		paneOut.add(lblOut);
		lblOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
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
