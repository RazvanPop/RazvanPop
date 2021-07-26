package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(281, 32, 360, 64);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnInserareAngajat = new JButton("Inserare Angajat");
		btnInserareAngajat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserareAngajatView nou = new InserareAngajatView();
				nou.main(null);
			}
		});
		btnInserareAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnInserareAngajat.setBounds(348, 188, 230, 56);
		frame.getContentPane().add(btnInserareAngajat);
		
		JButton btnStergereAngajat = new JButton("Stergere Angajat");
		btnStergereAngajat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteAngajatView nou = new DeleteAngajatView();
				nou.main(null);
			}
		});
		btnStergereAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnStergereAngajat.setBounds(348, 373, 230, 56);
		frame.getContentPane().add(btnStergereAngajat);
		
		JButton btnUpdateAngajat = new JButton("Update Angajat");
		btnUpdateAngajat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditareAngajatView nou = new EditareAngajatView();
				nou.main(null);
			}
		});
		btnUpdateAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdateAngajat.setBounds(348, 548, 230, 46);
		frame.getContentPane().add(btnUpdateAngajat);
	}

}
