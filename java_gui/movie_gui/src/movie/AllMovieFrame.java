package movie;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllMovieFrame extends JFrame {
	JTable table;
	Vector vData;
	Vector vCol;
	public AllMovieFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("영화정보관리 미니 프로젝트");
		setSize(600,400);
		MovieDAO dao = new MovieDAO();
		vData = dao.allMovies();
		vCol = new Vector();
		vCol.add("영화코드");
		vCol.add("영화제목");
		vCol.add("감독");
		vCol.add("장르");
		vCol.add("등급");
		vCol.add("출연배우");
		vCol.add("상영시간");
		vCol.add("배급사");
		vCol.add("개봉일");
		vCol.add("설명");
		DefaultTableModel model = new DefaultTableModel(vData, vCol);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		setVisible(true);
		
	}//생성자
}//end