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
import Model.Angajat;
import Model.AngajatConnection;

import javax.swing.JButton;

public class EditareAngajatView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditareAngajatView window = new EditareAngajatView();
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
	public EditareAngajatView() {
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
		
		JLabel lblUpdateEmployee = new JLabel("Editare Angajat");
		lblUpdateEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblUpdateEmployee.setBounds(389, 52, 320, 72);
		frame.getContentPane().add(lblUpdateEmployee);
		
		textField = new JTextField();
		textField.setBounds(390, 198, 351, 55);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(390, 316, 351, 55);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 313, 127, 55);
		frame.getContentPane().add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(390, 424, 351, 55);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Parola :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(83, 432, 127, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNume = new JLabel("Nume :");
		lblNume.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNume.setBounds(83, 195, 173, 55);
		frame.getContentPane().add(lblNume);
		
		final JButton btnNewButton = new JButton("EDITARE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AngajatConnection angajat = new AngajatConnection();
				Angajat a = new Angajat(textField.getText(), textField_2.getText(), textField_3.getText());
				angajat.update(a);
				JOptionPane.showMessageDialog(btnNewButton, "Angajat modificat cu succes");
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(396, 553, 275, 72);
		frame.getContentPane().add(btnNewButton);
	}

}
