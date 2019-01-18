package prj1;
public class Ex10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputPass = "abcd";
		String dbPass = "password1234";
		boolean ok = inputPass.equals(dbPass);
		if(ok) {
			System.out.println("로그인");
		} else {
			System.out.println("비밀번호가 틀립니다!");
		}
	}//main
}
