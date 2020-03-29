package hackerRank;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class QueueUsingStack {
	 public static class MyQueue<T> {
	        Stack<Integer> stackNewestOnTop = new Stack<Integer>();
	        Stack<Integer> stackOldestOnTop = new Stack<Integer>();

	        public void enqueue(Integer value) { // Push onto newest stack
	        	stackNewestOnTop.push(value);
	        }

	        public Integer peek() {
	        	while(!stackNewestOnTop.isEmpty())
	        	{
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
	        	return stackOldestOnTop.peek();
	        }

	        public Integer dequeue() {
	        	while(stackNewestOnTop.isEmpty())
	        	{
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
	        	return stackOldestOnTop.pop();
	        }
	    }
}
