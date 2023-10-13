package View;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Controller.AcController;
import Model.User;


public class DirettoreGUI extends JFrame{
	public JPanel contentPane;
	private JLabel lblCl;
	private static int id;
	private static User u;
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirettoreGUI frame = new DirettoreGUI(id,u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DirettoreGUI(int id,User u){
		DirettoreGUI.id = id;
		DirettoreGUI.u = u;
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 562);
		contentPane = new JPanel();
		contentPane.setBackground((new Color(181,247,157)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{258, 457, 20, 20, 0};
		gbl_contentPane.rowHeights = new int[]{530, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(102, 204, 102));
		GridBagConstraints gbc_paneMenu = new GridBagConstraints();
		gbc_paneMenu.fill = GridBagConstraints.BOTH;
		gbc_paneMenu.insets = new Insets(0, 0, 0, 5);
		gbc_paneMenu.gridx = 0;
		gbc_paneMenu.gridy = 0;
		contentPane.add(paneMenu, gbc_paneMenu);
		GridBagLayout gbl_paneMenu = new GridBagLayout();
		gbl_paneMenu.columnWidths = new int[]{248, 0};
		gbl_paneMenu.rowHeights = new int[]{135, 30, 0, 30, 30, 30, 30, 30, 30, 0};
		gbl_paneMenu.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_paneMenu.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		paneMenu.setLayout(gbl_paneMenu);
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(DirettoreGUI.class.getResource("/logo/Senza titolo.png")));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogo.gridx = 0;
		gbc_lblLogo.gridy = 0;
		paneMenu.add(lblLogo, gbc_lblLogo);
		JPanel paneAcc = new JPanel();
		paneAcc.addMouseListener(new PanelMouse(paneAcc){
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = getLbl();
				AccountCl cl =new AccountCl(getLbl(), id,u);
				cl.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_paneAcc = new GridBagConstraints();
		gbc_paneAcc.insets = new Insets(0, 0, 5, 0);
		gbc_paneAcc.gridx = 0;
		gbc_paneAcc.gridy = 1;
		paneMenu.add(paneAcc, gbc_paneAcc);
		paneAcc.setBackground(new Color(102, 204, 102));
		paneAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblAcc = new JLabel("Account");
		paneAcc.add(lblAcc);
		lblAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel paneLav = new JPanel();
		paneLav.addMouseListener(new PanelMouse(paneLav)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = getLbl();
				LavoratoriGUI tp =new LavoratoriGUI(getLbl(), id, u);
				tp.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_paneLav = new GridBagConstraints();
		gbc_paneLav.insets = new Insets(0, 0, 5, 0);
		gbc_paneLav.gridx = 0;
		gbc_paneLav.gridy = 2;
		paneMenu.add(paneLav, gbc_paneLav);
		paneLav.setBackground(new Color(102, 204, 102));
		paneLav.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblLav = new JLabel("Visualizza lavoratori");
		paneLav.add(lblLav);
		lblLav.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt){
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = getLbl();
				StanzeGUI pr =new StanzeGUI(getLbl(), id, u);
				pr.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_paneSt = new GridBagConstraints();
		gbc_paneSt.insets = new Insets(0, 0, 5, 0);
		gbc_paneSt.gridx = 0;
		gbc_paneSt.gridy = 3;
		paneMenu.add(paneSt, gbc_paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblSt = new JLabel("Visualizza stato stanze");
		paneSt.add(lblSt);
		
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel panelElAcc = new JPanel();
		panelElAcc.setToolTipText("Elimina Account");
		
		panelElAcc.setBackground(new Color(102, 204, 102));
		GridBagConstraints gbc_panelElAcc = new GridBagConstraints();
		gbc_panelElAcc.insets = new Insets(0, 0, 5, 0);
		gbc_panelElAcc.gridx = 0;
		gbc_panelElAcc.gridy = 4;
		paneMenu.add(panelElAcc, gbc_panelElAcc);
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
					DirettoreGUI.this.dispose();
				}
			}
		});
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut) {
			@Override
			//chiedo conferma logout e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
					Benvenuto_Form ben = new Benvenuto_Form();
					ben.setVisible(true);
					DirettoreGUI.this.dispose();
				}
			}
		});
		GridBagConstraints gbc_paneOut = new GridBagConstraints();
		gbc_paneOut.insets = new Insets(0, 0, 5, 0);
		gbc_paneOut.gridx = 0;
		gbc_paneOut.gridy = 5;
		paneMenu.add(paneOut, gbc_paneOut);
		paneOut.setBackground(new Color(102, 204, 102));
		paneOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JLabel lblOut = new JLabel("Logout");
		lblOut.setBounds(96, 6, 55, 23);
		paneOut.add(lblOut);
		lblOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
    	
    	JLabel lblNewLabel = new JLabel("Id:");
    	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
    	gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
    	gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
    	gbc_lblNewLabel.gridx = 2;
    	gbc_lblNewLabel.gridy = 0;
    	contentPane.add(lblNewLabel, gbc_lblNewLabel);
    	lblNewLabel.setFont(new Font("Thonburi", Font.PLAIN, 12));
    	
    	JLabel lblCl_1 = new JLabel();
    	lblCl_1.setText(String.valueOf(id));
    	GridBagConstraints gbc_lblCl_1 = new GridBagConstraints();
    	gbc_lblCl_1.insets = new Insets(0, 0, 0, 5);
    	gbc_lblCl_1.anchor = GridBagConstraints.NORTHWEST;
    	gbc_lblCl_1.gridx = 3;
    	gbc_lblCl_1.gridy = 0;
    	contentPane.add(lblCl_1, gbc_lblCl_1);
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