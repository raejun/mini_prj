package HW;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Music extends JFrame implements ActionListener {
	JPanel pNorth, pSouth, pEast, pWest;
	   JButton btnInsert, btnSelect, btnUpdate, btnDelete, btnExit, btnAll;
	   JTextField tfSearch;
	   MusicPanel p1;
	   public Music() {
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE); //창닫기
	      setTitle("띵곡 관리 데이터 베이스");
	      setSize(800,400);
	      pNorth = new JPanel();
	      pNorth.setBackground(Color.BLACK);
	      add(pNorth, BorderLayout.NORTH);
	      
	      pSouth = new JPanel();
	      pSouth.setBackground(Color.BLACK);
	      add(pSouth, BorderLayout.SOUTH);
	      
	      pEast = new JPanel();
	      pEast.setBackground(Color.BLACK);
	      add(pEast, BorderLayout.EAST);
	      
	      pWest = new JPanel();
	      pWest.setBackground(Color.BLACK);
	      add(pWest, BorderLayout.WEST);
	      
	      btnInsert = new JButton("정보 등록");
	      btnSelect = new JButton("정보 검색"); 
	      btnUpdate = new JButton("정보 수정");
	      btnDelete = new JButton("정보 삭제");
	      btnExit = new JButton("종료");
	      btnAll = new JButton("전체 목록 보기");
	      tfSearch = new JTextField(10);
	      
	      
	      btnInsert.addActionListener(this);
	      btnSelect.addActionListener(this);
	      btnUpdate.addActionListener(this);
	      btnDelete.addActionListener(this);
	      btnExit.addActionListener(this);
	      tfSearch.addActionListener(this);
	      btnAll.addActionListener(this);// 리스너 등록  엔터를 쳣을 때 ActionEvent 발
	      
	      pNorth.add(btnInsert);
	      pNorth.add(btnUpdate);
	      pNorth.add(btnDelete);
	      pNorth.add(btnExit);
	   
	      pSouth.add(btnAll);
	      pSouth.add(tfSearch);
	      pSouth.add(btnSelect);
	      // p1 만들어 중앙에 붙이기
	      p1=new MusicPanel();
	      add(p1);
	      setVisible(true);
	}//생성자
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnInsert) {
			muInsert();
		}else if(obj==btnSelect) {
			muSelect();
		}else if(obj==btnUpdate) {
			muUpdate();
		}else if(obj==btnDelete) {
			muDelete();
		}else if(obj==btnExit) {
			System.exit(0);
		}else if(obj == btnAll) {
			new AllMusicFrame();
		}
	}//actionPerformed
	private void muSelect() {
		//이름을 가져온다
		String Artist = tfSearch.getText();
		//MemberDTO mem 생성 후 DB의 내용을 담는다
		MusicDAO dao = new MusicDAO();
		MusicDTO mu = dao.selectMusic(Artist);
		if(mu.getArtist() == null) {
			System.out.println("없는 노래");
			JOptionPane.showMessageDialog(this, "없습니다", 
					"search ok?", JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println(mu);			
			//화면에 보여줌
			p1.tfArtist.setText(mu.getArtist());
			p1.tfTitle.setText(mu.getTitle());
			p1.tfLength.setText(""+mu.getLength());
			p1.tfGenre.setText(mu.getGenre());
			p1.tfRanking.setText(""+mu.getRanking());
			p1.tfRelease.setText(mu.getRelease());
			p1.tfComposer.setText(mu.getComposer());

		}//else
	}//memSelect
	private MusicDTO captureView() {
		// 화면에 입력값들을 가져옴
		String Artist = p1.tfArtist.getText();
		String Title = p1.tfTitle.getText();
		int Length = Integer.parseInt(p1.tfLength.getText());
		String Genre = (String) p1.cbGenre.getSelectedItem();
		int Ranking = Integer.parseInt(p1.tfRanking.getText());
		String Release = p1.tfRelease.getText();
		String Composer = p1.tfComposer.getText();
		// MemberDTO mem 객체를 만든 후 데이터를 셋팅
		MusicDTO mu = new MusicDTO();
		mu.setArtist(Artist);
		mu.setTitle(Title);
		mu.setLength(Length);
		mu.setGenre(Genre);
		mu.setRanking(Ranking);
		mu.setRelease(Release);
		mu.setComposer(Composer);
		return mu;
	}//captureView
	private void muInsert() {
		MusicDTO mu = captureView();
		//3. MemberDAO 객체를 만든 후 insertMember(mem)를 실행ㅎ
		MusicDAO dao = new MusicDAO();
		dao.insertMusic(mu);
		JOptionPane.showMessageDialog(this, "저장성공", "save ok?", JOptionPane.INFORMATION_MESSAGE);
	}//mainInsert
	   private MusicDTO del() {
		      // 화면에 입력값들을 가져옴
		      String Artist = p1.tfArtist.getText();
		      String Title = p1.tfTitle.getText();
		      String Length = p1.tfLength.getText();
		      String Genre = (String) p1.cbGenre.getSelectedItem();
		      String Ranking = p1.tfRanking.getText();
		      String Release = p1.tfRelease.getText();
		      String Composer = p1.tfComposer.getText();
		      MusicDTO mu = new MusicDTO();
		      mu.setArtist(Artist);
		      mu.setTitle(Title);
		      mu.setGenre(Genre);
		      mu.setRelease(Release);
		      mu.setComposer(Composer);
		      return mu;
		   }
	private void muDelete() {
		MusicDTO del = del();
		MusicDAO dao = new MusicDAO();
		dao.deleteMusic(del);
		JOptionPane.showMessageDialog(this, "삭제 성공", "delete ok?", JOptionPane.INFORMATION_MESSAGE);
	}//delete
	private void muUpdate() {
		MusicDTO mu = captureView();
		MusicDAO dao = new MusicDAO();
		dao.updateMusic(mu);
		JOptionPane.showMessageDialog(this, "수정 성공", "update ok?", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		Music f = new Music();
	}//main
}//end
