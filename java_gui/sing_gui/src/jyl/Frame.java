package jyl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
	public static void main(String[] args) {
		Dimension dim = new Dimension(400, 300);

		JFrame frame = new JFrame("Table House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);

		String header[] = { "����̸�", "�Ǳ��", "�帣", "�뷡�̸�" };
		String contents[][] = { /* 2�������� �����.2������ rowData��� �ϰ� 1������ columnNames��� �Ѵ�. */
				{ "Muse", "3", "Rock", "Hysteria" }, { "Olivia Ong", "5", "Jazz", "Love Fool" },
				{ "Oasis", "4", "Rock", "Don't look back in anger" },

		};// string contents, �ش��� ���� �ۼ�

		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model); /* JTable ��ü ����, Jtabled���� �Ʊ� �ۼ��� ����� ���� �ִ� �ڵ��ʿ� */
		JScrollPane scrollpane = new JScrollPane(table); /* �ڽ����� �÷��� Ui���� ĭ�� �����ϸ� ��ũ���� �����Ѵ� */
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JTextField nameField = new JTextField(5);
		JTextField subject1 = new JTextField(3);
		JTextField subject2 = new JTextField(3);
		JTextField subject3 = new JTextField(3);

		panel.add(nameField);
		panel.add(subject1);
		panel.add(subject2);
		panel.add(subject3);

		JButton addBtn = new JButton("�߰�");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputStr[] = new String[4];

				inputStr[0] = nameField.getText();
				inputStr[1] = subject1.getText();
				inputStr[2] = subject2.getText();
				inputStr[3] = subject3.getText();
				model.addRow(inputStr);

				nameField.setText("");
				subject1.setText("");
				subject2.setText("");
				subject3.setText("");

			}
		});
		JButton cancelBtn = new JButton("����");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() == -1) {
					return;
				} // if
				else {
					model.removeRow(table.getSelectedRow());
				} // else
			}
		});

		panel.add(addBtn);
		panel.add(cancelBtn);

		frame.add(scrollpane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
