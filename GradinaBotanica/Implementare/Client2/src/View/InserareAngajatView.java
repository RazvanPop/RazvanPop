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

public class InserareAngajatView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserareAngajatView window = new InserareAngajatView();
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
	public InserareAngajatView() {
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
		
		JLabel lblInserareAngajat = new JLabel("Inserare Angajat");
		lblInserareAngajat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblInserareAngajat.setBounds(337, 31, 267, 70);
		frame.getContentPane().add(lblInserareAngajat);
		
		textField = new JTextField();
		textField.setBounds(337, 159, 370, 70);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(337, 286, 370, 70);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(337, 414, 370, 65);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		final JLabel lblNewLabel = new JLabel("Nume :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 158, 135, 75);
		frame.getContentPane().add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel(" Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(136, 283, 135, 70);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Parola :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(136, 412, 135, 62);
		frame.getContentPane().add(lblNewLabel_2);
		
		final JButton btnNewButton = new JButton("ADAUGARE ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AngajatConnection angajat = new AngajatConnection();
				Angajat a = new Angajat(textField.getText(), textField_1.getText(), textField_2.getText());
				angajat.insert(a);
				JOptionPane.showMessageDialog(btnNewButton, "Angajat adaugat cu succes");
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(337, 550, 195, 75);
		frame.getContentPane().add(btnNewButton);
	}
}
