package utility;
import java.util.*;
public class Util04 {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("=== �ʱ�ȭ ������ ���� ===");
		System.out.println("v.size()="+v.size());//9
		System.out.println("v.capacity()= "+v.capacity());//10
		System.out.println(v);
		for(int i =0; i<9; i++) {
			v.add(i); //v.add(new Integer(i));
		}//for
		System.out.println("=== 9�� ������ ������ ���� ===");
		System.out.println("v.size()="+v.size());//9
		System.out.println("v.capacity()= "+v.capacity());//10
		System.out.println(v);
		v.add(9);
		v.add(10);
		System.out.println("=== 11�� ������ ������ ���� ===");
		System.out.println("v.size()="+v.size());//9
		System.out.println("v.capacity()= "+v.capacity());//10
		System.out.println(v);
	}//main

}//end
