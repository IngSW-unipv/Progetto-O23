package View;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DirController;
import Model.User;
import Model.direttore.DirettoreDAO;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class StanzeGUI extends JFrame {

	private JPanel contentPane;
	public JTable table1;
	private DirettoreDAO dao;
	private Connection conn;
	public static JLabel lbl;
	private static int id;
	private static User u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StanzeGUI frame = new StanzeGUI(lbl, id, u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lbl 
	 */
	public StanzeGUI(JLabel lbl, int id, User u) {
		
		StanzeGUI.lbl = lbl;
		StanzeGUI.id=id;
		StanzeGUI.u=u;
		
		dao = new DirettoreDAO();
		
		DirController controller = new DirController(dao, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181, 247, 157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("mostra");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				controller.actionPerformed1(e1);
			}
		});
		
		
		
		btn.setBounds(37, 63, 117, 29);
		contentPane.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 19, 549, 238);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JButton btnNewButton = new JButton("indietro");
		btnNewButton.setBounds(37, 98, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirettoreGUI dip = new DirettoreGUI(id, u);
				dip.setLbl(lbl);
				dispose();
			}
		});
		
		
	}
}

	