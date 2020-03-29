package newDynamic;

import java.util.Stack;
// check MyStack file too for other approach
public class DesignAndImplementSpecialStackDataStructure {
	static class UpdatedStack extends Stack<Integer>
	{
		Stack<Integer> min = new Stack<Integer>();
		void push(int n)
		{
			if(super.isEmpty())
			{
				super.push(n);
				min.push(n);
			}
			else
			{
				super.push(n);
				if(min.peek()>n)
				{
					min.push(n);
				}
			}
		}
		public Integer pop()
		{
			int n = super.pop();
			if(n==min.peek())
			{
				min.pop();
			}
			return n;
		}
		public Integer min()
		{
			return min.peek();
		}
		public static void main(String[] args) {
			UpdatedStack s = new UpdatedStack();
	        s.push(10);
	        s.push(20);
	        s.push(30);
	        System.out.println(s.min());
	        s.push(5);
	        System.out.println(s.min());
		}
	}

}
