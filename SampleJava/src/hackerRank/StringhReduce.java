package hackerRank;

import java.util.Stack;

public class StringhReduce {
	static String superReducedString(String s) {
		if(null==s)
			return null;
		if(s.length()==0)
			return "Empty String";
		Stack<Character> st = new Stack<Character>();
		for(int i=s.length()-1;i>=0;i--)
		{
			if(st.isEmpty())
				st.push(s.charAt(i));
			else if(st.peek()==s.charAt(i))
			{
				st.pop();
			}
			else
			{
				st.push(s.charAt(i));
			}
		}
		if(st.isEmpty())
			return "Empty String";
		String result = "";
		while(!st.isEmpty())
		{
			result+=st.pop();
		}
		return result;
	}
}
