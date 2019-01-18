package gui2;
import javax.swing.JFrame;
public class Swing1 extends JFrame {
	public Swing1() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // X 클릭시 종료
		setTitle("스윙 예제");
		setSize(400, 300);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new Swing1();
	}//main
}//end
