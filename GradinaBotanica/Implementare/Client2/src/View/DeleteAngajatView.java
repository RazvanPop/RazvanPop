package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Controller.AngajatOp;
import Model.AngajatConnection;

import javax.swing.JButton;

public class DeleteAngajatView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAngajatView window = new DeleteAngajatView();
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
	public DeleteAngajatView() {
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
		
		JLabel lblNewLabel = new JLabel("STERGERE ANGAJAT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(284, 32, 361, 88);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(366, 311, 403, 55);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNume = new JLabel("NUME :");
		lblNume.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNume.setBounds(157, 311, 210, 55);
		frame.getContentPane().add(lblNume);
		
		final JButton btnNewButton = new JButton("STERGERE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AngajatConnection angajat = new AngajatConnection();
				//Angajat a = new Angajat(textField.getText());
				angajat.delete(textField.getText());
				JOptionPane.showMessageDialog(btnNewButton, "Angajat sters cu succes");
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(334, 509, 264, 88);
		frame.getContentPane().add(btnNewButton);
	}

}
