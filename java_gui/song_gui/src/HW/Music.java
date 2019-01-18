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
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE); //â�ݱ�
	      setTitle("��� ���� ������ ���̽�");
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
	      
	      btnInsert = new JButton("���� ���");
	      btnSelect = new JButton("���� �˻�"); 
	      btnUpdate = new JButton("���� ����");
	      btnDelete = new JButton("���� ����");
	      btnExit = new JButton("����");
	      btnAll = new JButton("��ü ��� ����");
	      tfSearch = new JTextField(10);
	      
	      
	      btnInsert.addActionListener(this);
	      btnSelect.addActionListener(this);
	      btnUpdate.addActionListener(this);
	      btnDelete.addActionListener(this);
	      btnExit.addActionListener(this);
	      tfSearch.addActionListener(this);
	      btnAll.addActionListener(this);// ������ ���  ���͸� ���� �� ActionEvent ��
	      
	      pNorth.add(btnInsert);
	      pNorth.add(btnUpdate);
	      pNorth.add(btnDelete);
	      pNorth.add(btnExit);
	   
	      pSouth.add(btnAll);
	      pSouth.add(tfSearch);
	      pSouth.add(btnSelect);
	      // p1 ����� �߾ӿ� ���̱�
	      p1=new MusicPanel();
	      add(p1);
	      setVisible(true);
	}//������
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
		//�̸��� �����´�
		String Artist = tfSearch.getText();
		//MemberDTO mem ���� �� DB�� ������ ��´�
		MusicDAO dao = new MusicDAO();
		MusicDTO mu = dao.selectMusic(Artist);
		if(mu.getArtist() == null) {
			System.out.println("���� �뷡");
			JOptionPane.showMessageDialog(this, "�����ϴ�", 
					"search ok?", JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println(mu);			
			//ȭ�鿡 ������
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
		// ȭ�鿡 �Է°����� ������
		String Artist = p1.tfArtist.getText();
		String Title = p1.tfTitle.getText();
		int Length = Integer.parseInt(p1.tfLength.getText());
		String Genre = (String) p1.cbGenre.getSelectedItem();
		int Ranking = Integer.parseInt(p1.tfRanking.getText());
		String Release = p1.tfRelease.getText();
		String Composer = p1.tfComposer.getText();
		// MemberDTO mem ��ü�� ���� �� �����͸� ����
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
		//3. MemberDAO ��ü�� ���� �� insertMember(mem)�� ���ा
		MusicDAO dao = new MusicDAO();
		dao.insertMusic(mu);
		JOptionPane.showMessageDialog(this, "���强��", "save ok?", JOptionPane.INFORMATION_MESSAGE);
	}//mainInsert
	   private MusicDTO del() {
		      // ȭ�鿡 �Է°����� ������
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
		JOptionPane.showMessageDialog(this, "���� ����", "delete ok?", JOptionPane.INFORMATION_MESSAGE);
	}//delete
	private void muUpdate() {
		MusicDTO mu = captureView();
		MusicDAO dao = new MusicDAO();
		dao.updateMusic(mu);
		JOptionPane.showMessageDialog(this, "���� ����", "update ok?", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		Music f = new Music();
	}//main
}//end
