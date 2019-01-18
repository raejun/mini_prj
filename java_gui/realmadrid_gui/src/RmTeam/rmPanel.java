package RmTeam;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

public class rmPanel extends JPanel {
	JLabel lblP_id, lblName, lblHeight, lblWeight, lblAge, lblPositon, lblNation, lbltfJDate;
	JTextField tfP_id, tfName, tfHeight, tfWeight, tfAge, tfPosition, tfNation, tfJDate;
	JPanel pPositon;
	JComboBox cbPosition;

//	JFormattedTextField tfPositon1, Positon2;
	String[] arrPosition = { "선택", "FW", "MF", "DF", "GK" };
	private Image img;

	public rmPanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public rmPanel(Image img) {
		// 레알이미지
		this.img = img;
//		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		Dimension size = new Dimension(620, 300);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);

		setLayout(new GridLayout(7, 2, 5, 5)); // 7x2 표 + 좌우 5px만큼 빈칸
		tfP_id = new JTextField();
		tfName = new JTextField();
		tfHeight = new JTextField();
		tfWeight = new JTextField();
		tfAge = new JTextField();
		tfPosition = new JTextField();
		pPositon = new JPanel();
		cbPosition = new JComboBox(arrPosition);
		pPositon.add(cbPosition);
		tfNation = new JTextField();

		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ선수번호"));
		add(tfP_id);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ이름"));
		add(tfName);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ키"));
		add(tfHeight);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ몸무게"));
		add(tfWeight);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ나이"));
		add(tfAge);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ포지션"));
		add(pPositon);
		add(new JLabel("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ국가"));
		add(tfNation);
	}

}
