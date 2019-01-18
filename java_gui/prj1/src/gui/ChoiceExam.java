package gui;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ChoiceExam extends Frame implements ItemListener {
	Choice c;
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e);
		String item = c.getSelectedItem();
		System.out.println("여행 가고 싶은 나라는=" + item);
	}//itemStateChanged
	public ChoiceExam() {
		setTitle("Choice 예제");
		setSize(400, 300);
		setLayout(new FlowLayout());
		Label b = new Label("여행가고 싶은 나라 : ");
		add(b);
		c = new Choice();
		c.add("한국");
		c.add("미국");
		c.add("중국");
		c.add("일본");
		c.add("인도네시아");
		c.add("태국");
		c.addItemListener(this);
		add(c);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new ChoiceExam();
	}//main
}//end
