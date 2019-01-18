package gui2;
import javax.swing.JFrame;
public class Swing1 extends JFrame {
	public Swing1() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//x 누르면 종료
		setTitle("스윙스읭");
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Swing1();
	}//main
}//end
