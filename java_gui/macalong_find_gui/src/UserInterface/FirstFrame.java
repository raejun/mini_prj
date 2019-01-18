package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DBConnect.DAO;
import DBConnect.DuplicateDTO;
import DBConnect.ImportInfo;
import DBConnect.RecommendDTO;
import DBConnect.SignInDTO;
import DBConnect.SignUpDTO;
import LimitInput.LimitInput;


public class FirstFrame extends JFrame {
	
	private String id;
	private DAO d = new DAO();
	private int count = 0;
	
	public FirstFrame(){
		setTitle("환영합니다");
		setSize(1000,1000);
		setResizable(false);
		setLocation(500,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	//첫 패널
	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10,10,80,25);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10,40,80,25);
		panel.add(passLabel);
		
		JTextField idTxt = new JTextField(20);;
		
		idTxt.setBounds(100,10,160,25);
		panel.add(idTxt);
		
		JTextField pwTxt = new JPasswordField(20);
		pwTxt.setBounds(100,40,160,25);
		panel.add(pwTxt);
		
		JButton signUpBtn;
		JButton signInBtn;
		
		signInBtn = new JButton("로그인");
		signInBtn.setBounds(160,80,100,25);
		panel.add(signInBtn);
		signInBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("로그인 클릭");
				LimitInput input = new LimitInput();
				if(input.checkHan(idTxt) == 0 || input.checkNull(pwTxt) == 0) {
					if(input.checkHan(idTxt) == 0) {
						JOptionPane.showMessageDialog(null, "아이디에는 영문과 숫자 입력만 가능합니다.");
						idTxt.setText("");
						pwTxt.setText("");
					}else if(input.checkNull(pwTxt) == 0){
						JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요.");
						idTxt.setText("");
						pwTxt.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "유효한 값을 입력해주세요");
						idTxt.setText("");
						pwTxt.setText("");
					}
					
				}else {
					SignInDTO s = new SignInDTO();
					String tempid = idTxt.getText();
					String temppw = pwTxt.getText();
					s.setId(tempid);
					s.setPw(temppw);
					
					if(d.signin(s) == 1) {
						id = tempid;
						remove(panel);
						JPanel pan = new JPanel();
						placeInfoPanel(pan, id);
						add(pan);
						setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "회원정보가 없습니다.");
						idTxt.setText("");
						pwTxt.setText("");
					}					
				}
			}
			
		});
		
		signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(10,80,100,25);
		panel.add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("회원가입 클릭");
				JPanel pan = new JPanel();
				remove(panel);
				placeSignUpPanel(pan);
				add(pan);
				setVisible(true);
			}
			
		});
	}
	
	//회원가입 패널
	public void placeSignUpPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10,10,80,25);
		panel.add(userLabel);
		
		JButton duplicateBtn = new JButton("중복확인");
		duplicateBtn.setBounds(290,10,100,25);
		panel.add(duplicateBtn);
		
		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10,40,80,25);
		panel.add(passLabel);
		
		JLabel nickName = new JLabel("닉네임");
		nickName.setBounds(10,70,80,25);
		panel.add(nickName);
		
		JLabel sub = new JLabel("인근 지하철 역");
		sub.setBounds(10,100,80,25);
		panel.add(sub);
		
		JTextField s_idTxt;
		JTextField s_pwTxt;
		JTextField nickTxt;
		JTextField subTxt;
		JButton completeBtn;
		
		s_idTxt = new JTextField(20);
		s_idTxt.setBounds(100,10,160,25);
		panel.add(s_idTxt);
		
		s_pwTxt = new JPasswordField(20);
		s_pwTxt.setBounds(100,40,160,25);
		panel.add(s_pwTxt);
		
		nickTxt = new JTextField(20);
		nickTxt.setBounds(100,70,160,25);
		panel.add(nickTxt);
		
		subTxt = new JTextField(20);
		subTxt.setBounds(100,100,160,25);
		panel.add(subTxt);
		
		duplicateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DuplicateDTO du = new DuplicateDTO();
				du.setId(s_idTxt.getText());
				int ok = d.checkduplicate(du);
				
				if(ok == 0) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
					s_idTxt.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					count++;
				}
				
				
			}
			
		});
		
		completeBtn = new JButton("완료");
		completeBtn.setBounds(160,130,100,25);
		panel.add(completeBtn);
		completeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LimitInput input = new LimitInput();
				if(input.checkHan(s_idTxt) == 0 || input.checkNumOREng(subTxt) == 0 || input.checkNull(s_pwTxt) == 0 || input.checkNull(nickTxt) == 0 || input.checkSub(subTxt) == 0) {
					if(input.checkHan(s_idTxt) == 0) {
						JOptionPane.showMessageDialog(null, "아이디에는 영문과 숫자 입력만 가능합니다.");
						s_idTxt.setText("");
					}
					if(input.checkNumOREng(subTxt) == 0){
						JOptionPane.showMessageDialog(null, "지하철역은 한글만 입력 가능합니다.");
						subTxt.setText("");
					}
					if(input.checkSub(subTxt) == 0){
						JOptionPane.showMessageDialog(null, "노선도에 없는 역입니다");
						subTxt.setText("");
					}
					if(input.checkNull(s_pwTxt) == 0 || input.checkNull(nickTxt) == 0) {
						JOptionPane.showMessageDialog(null, "값을 입력해주세요.");
						s_pwTxt.setText("");
						nickTxt.setText("");
					}
					
				}else {
					if(count != 0) {
						SignUpDTO signUp = new SignUpDTO();
						signUp.setId(s_idTxt.getText());
						signUp.setPw(s_pwTxt.getText());
						signUp.setNickname(nickTxt.getText());
						signUp.setSub(subTxt.getText());
						
						d.insertMember(signUp);
						
						remove(panel);
						
						JPanel panel = new JPanel();
						placeLoginPanel(panel);
						
						add(panel);
						
						setVisible(true);	
					}else {
						JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요.");
					}
				}
			}
			
		});		
	}
	
	//로그인 후 화면
	public void placeInfoPanel(JPanel panel, String id) {
		panel.setLayout(null);
		
		ImportInfo i = new ImportInfo();
		i.setId(id);
		
		String[] info = new String[2];
		info = d.selectinfo(i);
		
		JLabel userLabel = new JLabel("안녕하세요! " + info[0] + "님, " + info[1] + "역 부근에 사시는군요!");
		userLabel.setBounds(0,0,500,30);
		panel.add(userLabel); 
		
		JLabel line = new JLabel("---------------------------------------------------------------------------");
		line.setBounds(0,15,500,30);
		panel.add(line);
		
		JLabel recommend = new JLabel(info[1] + "역 부근 마카롱 판매점 입니다!");
		recommend.setBounds(0,30,500,30);
		panel.add(recommend);
		
		JLabel line2 = new JLabel("----------------------------------------------------");
		line2.setBounds(0,45,500,30);
		panel.add(line2);
		
		RecommendDTO r = new RecommendDTO();
		r.setSub(info[1]);
		
		String[] temp = new String[3];
		temp = d.recommemdMarket(r);
		
		HashMap<String, String> h = new HashMap<String, String>();
		h = d.findMarket(temp);
		
		ArrayList<String> a = new ArrayList<>();
		a = d.getMenu(h);
		
		int add = 30;
		for(String x : h.keySet()) {
			JLabel rec = new JLabel(h.get(x)+"역에 " +"'"+ x + "'"+ " 집이 있습니다!" );
			rec.setBounds(0,30+add,500,30);
			panel.add(rec);
			add+=30;
		}
		
		JLabel line3 = new JLabel("----------------------------------------------------");
		line3.setBounds(0,15+add,500,30);
		panel.add(line3);
		
		int add2 = 30;
		for(int k = 0; k < a.size(); k+=3) {
			JLabel rec2 = new JLabel(a.get(k+2)+" 집에 "+a.get(k)+" 메뉴가 " + a.get(k+1)+"개 남아있어요!");
			rec2.setBounds(0, add+add2, 500, 30);
			panel.add(rec2);
			add2+=30;
		}
		
		JButton updateplace = new JButton("다른 곳 보기");
		updateplace.setBounds(0, add+add2+30, 500, 30);
		panel.add(updateplace);
		updateplace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				remove(panel);
				JPanel panel = new JPanel();
				differentplace(panel);
				
				add(panel);
				setVisible(true);
			}
			
		});
	}
	
	//다른 장소 찾기
	public void differentplace(JPanel panel) {
		panel.setLayout(null);
		
		JLabel sub = new JLabel("지하철 역 입력 : ");
		sub.setBounds(0,10,500,30);
		panel.add(sub);
		
		JTextField subTxt = new JTextField();
		subTxt.setBounds(150,10,200,30);
		panel.add(subTxt);
		
		JButton findBtn = new JButton("찾기");
		findBtn.setBounds(0,90,500,30);
		panel.add(findBtn);
		findBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LimitInput limit = new LimitInput();
				if(limit.checkNumOREng(subTxt) == 0) {
					System.out.println("유효하지 않은 필드 값");
					JOptionPane.showMessageDialog(null, "한글만 입력해주세요!");
					subTxt.setText("");
				}else if(limit.checkSub(subTxt) == 0) {
					JOptionPane.showMessageDialog(null, "노선도에 없는 역입니다!");
					subTxt.setText("");
				}else{
					remove(panel);
					JPanel panel = new JPanel();
					find(panel,subTxt.getText());
					
					add(panel);
					setVisible(true);	
				}
					
			}
			
		});	
	}
	
	//인근 역의 마카롱 판매점 찾기
	public void find(JPanel panel, String sub) {
		panel.setLayout(null);
		
		RecommendDTO r = new RecommendDTO();
		r.setSub(sub);

		JLabel sublabel = new JLabel(sub + "역 부근 마카롱 판매점입니다!");
		sublabel.setBounds(0,10,500,30);
		panel.add(sublabel);		
		
		JLabel line2 = new JLabel("----------------------------------------------------");
		line2.setBounds(0,45,500,30);
		panel.add(line2);
		
		String[] t = new String[3];
		t = d.recommemdMarket(r);
		
		HashMap<String, String> h = new HashMap<String, String>();
		h = d.findMarket(t);
		
		ArrayList<String> a = new ArrayList<>();
		a = d.getMenu(h);
		
		int add = 30;
		for(String x : h.keySet()) {
			JLabel rec = new JLabel(h.get(x)+"역에 " +"'"+ x + "'"+ " 집이 있습니다!" );
			rec.setBounds(0,30+add,500,30);
			panel.add(rec);
			add+=30;
		}
		
		JLabel line3 = new JLabel("----------------------------------------------------");
		line3.setBounds(0,15+add,500,30);
		panel.add(line3);
		
		int add2 = 30;
		for(int k = 0; k < a.size(); k+=3) {
			JLabel rec2 = new JLabel(a.get(k+2)+" 집에 "+a.get(k)+" 메뉴가 " + a.get(k+1)+"개 남아있어요!");
			rec2.setBounds(0, add+add2, 500, 30);
			panel.add(rec2);
			add2+=30;
		}
		
		JButton updateplace = new JButton("다른 곳 보기");
		updateplace.setBounds(0, add+add2+30, 500, 30);
		panel.add(updateplace);
		updateplace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				remove(panel);
				JPanel panel = new JPanel();
				differentplace(panel);
				
				add(panel);
				setVisible(true);
			}
			
		});				
			
	}
}
