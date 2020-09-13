package HackerRank.certification;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class JavaStack {
	boolean isBalanced(String s)
    {
        if(s==null || s.length()==0)
            return true;

        Set<Character> open = new TreeSet<Character>();
        open.add('{');
        open.add('[');
        open.add('(');
        Set<Character> close = new TreeSet<Character>();
        close.add(']');
        close.add('}');
        close.add(')');
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
        	char cha = s.charAt(i);
        	if(open.contains(cha))
        		st.push(cha);
        	else if (close.contains(cha) && st.size()!=0)
        	{
        		if(cha==']' && st.peek()=='[')
        			st.pop();
        		else if(cha=='}' && st.peek()=='{')
        			st.pop();
        		else if(cha==')' && st.peek()=='(')
        			st.pop();
        		else
        			return false;
        	}
        	else
        		return false;
        		
        }
        if(st.isEmpty())
        	return true;
        return false;
    }
}
