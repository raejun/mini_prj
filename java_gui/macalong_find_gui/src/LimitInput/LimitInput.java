package LimitInput;

import java.util.regex.Pattern;

import javax.swing.JTextField;

public class LimitInput {
	//공백막기
	public int checkNull(JTextField field) {
		if(field.getText().equals("")) {
			return 0;
		}else {
			return 1;
		}
	}

	//숫자입력, 영문입력막기
	public int checkNumOREng(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[0-9]+$", field.getText())) || (Pattern.matches("^[a-zA-Z]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//한글입력막기
	public int checkHan(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//지하철역 유효하지 않은 값 막기
	public int checkSub(JTextField field) {
		String[] sub = {"응암", "역촌", "불광", "독바위", "연신내", "구산", "응암", "새절", "증산", "디지털미디어시티", "월드컵경기장", "마포구청", "망원", "합정", "상수", "광흥창", "대흥", "공덕", "효창공원앞","삼각지","녹사평", "이태원", "한강진", "버티고개", "약수", "청구", "신당", "동묘앞", "창신", "보문", "안암", "고려대", "월곡", "상월곡", "돌곶이", "석계", "태릉입구", "화랑대", "봉화산"};
		for(int i =0; i <sub.length; i++) {
			if(field.getText().equals(sub[i])) { return 1; }
			else {continue;}
		}
		return 0;
	}
}
