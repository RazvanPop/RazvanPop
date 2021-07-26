package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Controller.PlantaOp;
import Model.Planta;
import Model.PlantaConnection;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class InserarePlantaView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserarePlantaView window = new InserarePlantaView();
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
	public InserarePlantaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 731);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInserarePlanta = new JLabel("Inserare Planta");
		lblInserarePlanta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblInserarePlanta.setBounds(325, 26, 297, 45);
		frame.getContentPane().add(lblInserarePlanta);
		
		textField = new JTextField();
		textField.setBounds(439, 142, 264, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Denumire :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(174, 142, 264, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tip :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(184, 214, 135, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(439, 221, 264, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Specie :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(174, 315, 135, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(439, 315, 264, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tip carnivor :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(174, 398, 135, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(439, 407, 264, 29);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(" Zona :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(174, 511, 227, 36);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(439, 518, 264, 29);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		final JButton btnNewButton = new JButton("ADAUGA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantaConnection planta = new PlantaConnection();
				Planta p = new Planta(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
				planta.insert(p);
				//planta.notifyAllObservers();
				JOptionPane.showMessageDialog(btnNewButton, "Planta adaugata cu succes");
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(315, 599, 253, 61);
		frame.getContentPane().add(btnNewButton);
	}
}
