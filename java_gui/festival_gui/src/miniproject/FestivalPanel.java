package miniproject;

 
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FestivalPanel extends JPanel {

	JTextField tfName, tfYear, tfFestival, tfInstrumental, tfCountry, tfGenre, tfExplain;


	public FestivalPanel() {
		setLayout(new GridLayout(7,1,5,5));

	//col = name, year, festival, instrumental, country, genre, explain
 
		tfName = new JTextField();
		tfYear = new JTextField();
		tfFestival = new JTextField();
		tfInstrumental = new JTextField();
		tfCountry = new JTextField();
		tfGenre = new JTextField();
		tfExplain = new JTextField();
		
		add(new JLabel("�̸�"));
		add(tfName);
		add(new JLabel("����"));
		add(tfYear);
		add(new JLabel("�佺Ƽ����"));
		add(tfFestival);
		add(new JLabel("�Ǳ� ��"));
		add(tfInstrumental);
		add(new JLabel("����"));
		add(tfCountry);
		add(new JLabel("�帣"));
		add(tfGenre);
		add(new JLabel("�Ұ�"));
		add(tfExplain);
	

	}//������


}//end

