package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.PlantaOp;

public class AngajatView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AngajatView window = new AngajatView();
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
	public AngajatView() {
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
		
		JLabel lblAngajat = new JLabel("Angajat");
		lblAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngajat.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAngajat.setBounds(264, 13, 408, 57);
		frame.getContentPane().add(lblAngajat);
		
		JButton btnInserare = new JButton("Inserare planta");
		btnInserare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserarePlantaView nou = new InserarePlantaView();
				nou.main(null);
			}
		});
		btnInserare.setBounds(337, 112, 248, 57);
		frame.getContentPane().add(btnInserare);
		
		JButton btnStergerePlanta = new JButton("Stergere planta");
		btnStergerePlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePlantaView nou = new DeletePlantaView();
				nou.main(null);
			}
		});
		btnStergerePlanta.setBounds(337, 262, 248, 57);
		frame.getContentPane().add(btnStergerePlanta);
		
		JButton btnUpdatePlanta = new JButton("Actualizare planta");
		btnUpdatePlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarePlantaView nou = new EditarePlantaView();
				nou.main(null);
			}
		});
		btnUpdatePlanta.setBounds(337, 402, 248, 57);
		frame.getContentPane().add(btnUpdatePlanta);
		
		JButton btnSalvareRaport = new JButton("Salvare raport");
		btnSalvareRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantaOp p = new PlantaOp();
				p.PlanteTxt();
				p.PlanteCSV();
			}
		});
		btnSalvareRaport.setBounds(337, 528, 248, 51);
		frame.getContentPane().add(btnSalvareRaport);
	}
}
