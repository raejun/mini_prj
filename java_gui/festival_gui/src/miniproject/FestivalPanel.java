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
		
		add(new JLabel("이름"));
		add(tfName);
		add(new JLabel("연도"));
		add(tfYear);
		add(new JLabel("페스티벌명"));
		add(tfFestival);
		add(new JLabel("악기 수"));
		add(tfInstrumental);
		add(new JLabel("국가"));
		add(tfCountry);
		add(new JLabel("장르"));
		add(tfGenre);
		add(new JLabel("소개"));
		add(tfExplain);
	

	}//생성자


}//end

