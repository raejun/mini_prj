package jyl;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JY_FestivalPanel extends JPanel {
	
	public JY_FestivalPanel () {
		 String header[] = {"밴드이름","악기수","장르","노래이름"};
		    String contents[][] = { /*2차원으로 만든다.2차원을 rowData라고 하고 1차원을 columnNames라고 한다.*/
		          {"Muse","3","Rock","Hysteria"},
		          {"Olivia Ong","5","Jazz","Love Fool"},
		          {"Oasis","4","Rock","Don't look back in anger"},
		          
		    };//string contents, 해더와 내용 작성
		    	DefaultTableModel model = new DefaultTableModel(contents, header);
				JTable table = new JTable(model); /*JTable 객체 생성, Jtabled에다 아까 작성한 헤더와 내용 넣는 코딩필요*/
				JScrollPane scrollpane = new JScrollPane(table); /*자신위에 올려진 Ui들이 칸이 부족하면 스크롤을 제공한다*/
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				
				
				add(scrollpane);
				add(panel);
	}
   
	
}
