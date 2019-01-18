package LimitInput;

import java.util.regex.Pattern;

import javax.swing.JTextField;

public class LimitInput {
	//°ø¹é¸·±â
	public int checkNull(JTextField field) {
		if(field.getText().equals("")) {
			return 0;
		}else {
			return 1;
		}
	}

	//¼ıÀÚÀÔ·Â, ¿µ¹®ÀÔ·Â¸·±â
	public int checkNumOREng(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[0-9]+$", field.getText())) || (Pattern.matches("^[a-zA-Z]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//ÇÑ±ÛÀÔ·Â¸·±â
	public int checkHan(JTextField field) {
		if(field.getText().equals("")||(Pattern.matches("^[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+$", field.getText()))) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//ÁöÇÏÃ¶¿ª À¯È¿ÇÏÁö ¾ÊÀº °ª ¸·±â
	public int checkSub(JTextField field) {
		String[] sub = {"ÀÀ¾Ï", "¿ªÃÌ", "ºÒ±¤", "µ¶¹ÙÀ§", "¿¬½Å³»", "±¸»ê", "ÀÀ¾Ï", "»õÀı", "Áõ»ê", "µğÁöÅĞ¹Ìµğ¾î½ÃÆ¼", "¿ùµåÄÅ°æ±âÀå", "¸¶Æ÷±¸Ã»", "¸Á¿ø", "ÇÕÁ¤", "»ó¼ö", "±¤ÈïÃ¢", "´ëÈï", "°ø´ö", "È¿Ã¢°ø¿ø¾Õ","»ï°¢Áö","³ì»çÆò", "ÀÌÅÂ¿ø", "ÇÑ°­Áø", "¹öÆ¼°í°³", "¾à¼ö", "Ã»±¸", "½Å´ç", "µ¿¹¦¾Õ", "Ã¢½Å", "º¸¹®", "¾È¾Ï", "°í·Á´ë", "¿ù°î", "»ó¿ù°î", "µ¹°ùÀÌ", "¼®°è", "ÅÂ¸ªÀÔ±¸", "È­¶û´ë", "ºÀÈ­»ê"};
		for(int i =0; i <sub.length; i++) {
			if(field.getText().equals(sub[i])) { return 1; }
			else {continue;}
		}
		return 0;
	}
}
