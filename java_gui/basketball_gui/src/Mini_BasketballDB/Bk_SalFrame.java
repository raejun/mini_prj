package Mini_BasketballDB;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bk_SalFrame extends JFrame{
	JTable table;
	Vector vData;
	Vector vCol;
	// »ý¼ºÀÚ
	public Bk_SalFrame () {
		setTitle("JTable ¼±¼ö ¿¬ºÀ");
		setSize(600, 600);
		BkPlayer_DAO dao = new BkPlayer_DAO();
		vData = dao.PlayerSal();

		vCol = new Vector();
		vCol.add("¼±¼ö¸í");
		vCol.add("½ÃÁð");
		vCol.add("¿¬ºÀ");

		DefaultTableModel model2 = new DefaultTableModel(vData, vCol);
		table = new JTable(model2);
		JScrollPane pane2 = new JScrollPane(table);
		add(pane2);
		
		setVisible(true);
	}
}