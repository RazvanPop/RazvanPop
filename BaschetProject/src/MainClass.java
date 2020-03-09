import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainClass {
	public static void main(String[] args)
	{
	secondbox sb = new secondbox();
	sb.setVisible(true);
	
	sb.getBtnNewButton().addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			sb.ADAUGARE_ECHIPA_NOUA(sb.getTextField().getText(), sb.getTextField_1().getText());
		}
	});
	
	sb.getBtnNewButton_1().addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			sb.ADAUGARE_JUCATOR_NOU(sb.getTextField_5().getText(), sb.getTextField_4().getText(),sb.getTextField_3().getText(),sb.getTextField_2().getText());
		}
	});
	
	sb.getBtnNewButton_2().addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			sb.ADAUGARE_NOTA_NOUA(sb.getTextField_6().getText());
		}
	});
	
	sb.getBtnNewButton_3().addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			sb.ADAUGARE_SPONSOR_NOU(sb.getTextField_7().getText(),sb.getTextField_8().getText());
		}
	});

	}
}
