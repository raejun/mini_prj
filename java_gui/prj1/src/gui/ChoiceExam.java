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
		System.out.println("���� ���� ���� �����=" + item);
	}//itemStateChanged
	public ChoiceExam() {
		setTitle("Choice ����");
		setSize(400, 300);
		setLayout(new FlowLayout());
		Label b = new Label("���డ�� ���� ���� : ");
		add(b);
		c = new Choice();
		c.add("�ѱ�");
		c.add("�̱�");
		c.add("�߱�");
		c.add("�Ϻ�");
		c.add("�ε��׽þ�");
		c.add("�±�");
		c.addItemListener(this);
		add(c);
		setVisible(true);
	}//������
	public static void main(String[] args) {
		new ChoiceExam();
	}//main
}//end
