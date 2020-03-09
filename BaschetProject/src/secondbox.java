import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class secondbox extends JFrame {

	private String url = "jdbc:mysql://localhost/proiectbd";
	private String uid = "root";
	private String pw = "";
	private Connection con;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	public JTextField getTextField_7() {
		return textField_7;
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}

	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_3; 
	private JLabel label;

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondbox frame = new secondbox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	
	}

	/**
	 * Create the frame.
	 */
	public secondbox() {
		connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Adauga echipa Noua");
		btnNewButton.setBounds(24, 414, 159, 49);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Adauga jucator Nou");
		btnNewButton_1.setBounds(259, 410, 159, 56);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Adauga Nota Noua");
		btnNewButton_2.setBounds(481, 406, 149, 57);
		contentPane.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(36, 220, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(36, 315, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDenumire = new JLabel("Denumire :");
		lblDenumire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDenumire.setBounds(36, 203, 116, 16);
		contentPane.add(lblDenumire);

		JLabel lblAnInfintare = new JLabel("An infintare :");
		lblAnInfintare.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAnInfintare.setBounds(36, 299, 116, 16);
		contentPane.add(lblAnInfintare);

		textField_2 = new JTextField();
		textField_2.setBounds(269, 315, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(269, 220, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(269, 130, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(269, 40, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNume = new JLabel("Nume :");
		lblNume.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNume.setBounds(270, 24, 115, 16);
		contentPane.add(lblNume);

		JLabel lblNewLabel = new JLabel("Prenume :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(269, 114, 116, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Post :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(270, 203, 115, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Numar Tricou :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(269, 299, 116, 16);
		contentPane.add(lblNewLabel_2);

		textField_6 = new JTextField();
		textField_6.setBounds(489, 315, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nota Noua :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(490, 299, 115, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(489, 130, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(489, 40, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		btnNewButton_3 = new JButton("ADAUGARE SPONSOR NOU");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(464, 219, 198, 38);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Venit :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(489, 24, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nume :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(489, 114, 56, 16);
		contentPane.add(lblNewLabel_5);
		/*
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Razvan\\Desktop\\imagesB(1).jpg"));
		label.setBounds(0, 0, 600, 414);
		contentPane.add(label);
		*/
		

	}

	public void connectDB() {
		try {
			Class.forName("com.sql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e);
		}

		con = null;
		try {
			con = DriverManager.getConnection(url, uid, pw);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}
	}

	private void doUpdate(String updateStr) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(updateStr);
			System.out.println("Operatia s-a efectuat cu succes!");
		} catch (SQLException e) {
			System.out.println("Operatia nu s-a putut efectua! :" + e);
		}
	}

	private String convertSQLString(String st) {
		return st.replaceAll("'", "''");
	}

	public void ADAUGARE_ECHIPA_NOUA(String denumire, String an_infintare) {
		CallableStatement cstmt = null;

		try {
			String sql = "{call ADAUGARE_ECHIPA_NOUA(?,?)}";
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, denumire);
			cstmt.setString(2, an_infintare);
			cstmt.execute();
			System.out.println("Operatia s-a efectuat cu succes!");
		} catch (SQLException e) {
			System.out.println("Operatia a esuat:" + e);
		}
	}

	public void ADAUGARE_JUCATOR_NOU(String nume, String prenume, String post, String numar_tricou) {
		CallableStatement cstmt = null;

		try {
			String sql = "{call ADAUGARE_JUCATOR_NOU(?,?,?,?)}";
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, nume);
			cstmt.setString(2, prenume);
			cstmt.setString(3, post);
			cstmt.setString(4, numar_tricou);
			cstmt.execute();
			System.out.println("Operatia s-a efectuat cu succes!");
		} catch (SQLException e) {
			System.out.println("Operatia a esuat:" + e);
		}
	}

	public void ADAUGARE_NOTA_NOUA(String nota) {
		CallableStatement cstmt = null;

		try {
			String sql = "{call ADAUGARE_NOTA_NOUA(?)}";
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, nota);
			cstmt.execute();
			System.out.println("Operatia s-a efectuat cu succes!");
		} catch (SQLException e) {
			System.out.println("Operatia a esuat:" + e);
		}
	}
	
	public void ADAUGARE_SPONSOR_NOU(String nume, String venit) {
		CallableStatement cstmt = null;

		try {
			String sql = "{call ADAUGARE_SPONSOR_NOU(?,?)}";
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, nume);
			cstmt.setString(2, venit);
			cstmt.execute();
			System.out.println("Operatia s-a efectuat cu succes!");
		} catch (SQLException e) {
			System.out.println("Operatia a esuat:" + e);
		}
	}
}