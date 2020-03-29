package amazone;

import java.util.Stack;

public class DesignAndImplementSpecialStackDataStructure {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> auxStack = new Stack<Integer>();
	int pop()
	{
		auxStack.pop();
		return stack.pop();
	}
	void push(int num)
	{
		stack.push(num);
		if(auxStack.isEmpty())
		{
			auxStack.push(num);
			return;
		}
		
		if(auxStack.peek()<num)
		{
			auxStack.push(auxStack.peek());
		} else
		{
			auxStack.push(num);
		}
	}
	int getMin()
	{
		return auxStack.peek();
	}
	public static void main(String[] args) {
		DesignAndImplementSpecialStackDataStructure obj = new DesignAndImplementSpecialStackDataStructure();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.push(5);
		System.out.println(obj.getMin());
		
	}
}
