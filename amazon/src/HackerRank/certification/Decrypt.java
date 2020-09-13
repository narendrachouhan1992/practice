package HackerRank.certification;

import java.util.Stack;

public class Decrypt {
	public static String decryptPassword1(String s) {

		Stack<Character> st = new Stack<Character>();

		int i = 0;
		while (i < s.length() && isNeumeric(s.charAt(i))) {
			st.push(s.charAt(i++));
		}
		String res = "";
		if (i == s.length()) {
			while (!st.isEmpty()) {
				res += st.pop();
			}
			return res;
		}
		while (i < s.length()) {
			if (Character.isUpperCase(s.charAt(i)) && i + 2 < s.length() && Character.isLowerCase(s.charAt(i + 1))
					&& s.charAt(i + 2) == '*') {
				res += s.charAt(i + 1);
				res += s.charAt(i);
				i = i + 3;
			} else if (s.charAt(i) == '0') {
				res += st.pop();
				i++;
			} else
				res += s.charAt(i++);
		}
		return res;
	}

	public static String decryptPassword(String s) {

		Stack<Character> st = new Stack<Character>();

		int i = 0;
		while (i < s.length() && isNeumeric(s.charAt(i))) {
			st.push(s.charAt(i++));
		}
		if (i == s.length()) {
			return s;
		}
		char[] sa = s.substring(i).toCharArray();
		i=0;
		while (i < sa.length) {
			if(sa[i]=='*' && Character.isLowerCase(sa[i-1]) && Character.isUpperCase(sa[i-2]))
			{
				char temp =  sa[i-1];
				sa[i-1 ] = sa[i-2];
				sa[i-2] = temp;
			}
			else if(sa[i] == '0')
			{
				sa[i]= st.pop();
			}
		
			
			i++;
				
		}
		s = new String(sa);
		s = 
		 return "";
	}

	private static boolean isNeumeric(char a) {
		if (a >= '0' && a <= '9')
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(decryptPassword("51Pa*0Lp*0e"));
	}

}
