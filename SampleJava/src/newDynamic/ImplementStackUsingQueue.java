package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue
{
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
}
public class ImplementStackUsingQueue {
	void push(StackUsingQueue stack, int num)
	{
		stack.q1.add(num);
	}
	int pop(StackUsingQueue stack)
	{
		if(stack.q1.isEmpty())
		{
			return -1;
		}
		else
		{
			while(stack.q1.size() != 1)
			{
				stack.q2.add(stack.q1.peek());
				stack.q1.remove();
			}
			int res = stack.q1.peek();
			stack.q1.remove();
			
			Queue<Integer> temp = stack.q1;
			stack.q1 = stack.q2;
			stack.q2 = temp;
			return res;
		}
	}
	int top(StackUsingQueue stack)
	{
		if(stack.q1.isEmpty())
		{
			return -1;
		}
		else
		{
			while(stack.q1.size() == 1)
			{
				stack.q2.add(stack.q1.peek());
				stack.q1.remove();
			}
			int res = stack.q1.peek();
			 stack.q2.add(stack.q1.peek());
			 stack.q1.remove();
			
			Queue<Integer> temp = stack.q1;
			stack.q1 = stack.q2;
			stack.q2 = temp;
			return res;
		}
	}
	public static void main(String[] args) {
		ImplementStackUsingQueue obj = new ImplementStackUsingQueue();
		StackUsingQueue stack = new StackUsingQueue();
		obj.push(stack, 1);
		obj.push(stack, 2);
		obj.push(stack, 3);
		obj.push(stack, 4);
		System.out.println(obj.pop(stack));
		System.out.println(obj.pop(stack));
		System.out.println(obj.pop(stack));
		
	}
}
