package GeeksForGeeks;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> s = new Stack<Integer>();
	void enqueue(int x)
	{
		s.push(x);
	}
	int dequeue()
	{
		if(s.isEmpty())
			return -1;
		if(s.size()==1)
			return s.pop();
		
		int x = s.pop();
		int res  = dequeue();
		s.push(x);
		return res;
	}
	public static void main(String[] args) {
		
	}
}
