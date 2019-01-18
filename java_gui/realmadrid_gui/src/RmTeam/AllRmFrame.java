package RmTeam;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AllRmFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;

	public AllRmFrame() {
		
		setTitle("RealMadrid 선수단");
		setSize(400, 350);
		rmDAO dao = new rmDAO();
		vData = dao.allrms();
		vCol = new Vector();
		vCol.add("선수번호");
		vCol.add("이름");
		vCol.add("키");
		vCol.add("몸무게");
		vCol.add("나이");
		vCol.add("포지션");
		vCol.add("국가");
		vCol.add("입단일");
		
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		
		add(pane);
		setVisible(true);
	}//생성자
	
}// class
