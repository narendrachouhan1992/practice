package GeeksForGeeks;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test {
	static Node reverse(Node curr)
	{
		Stack<Node> st = new Stack<Node>();
		while(curr!=null)
		{
			
			st.push(curr);
			curr= curr.next;
		}
		curr = st.pop();
		Node rev = curr;
		while(!st.isEmpty())
		{
			rev.next = st.pop();
			rev = rev.next;
		}
		rev.next=null;
		return curr;
	}
	public static void main(String[] args) {
		Node head = new Node();
		head.data = 5;
		head.next = new Node();
		head.next.data = 10;
		head.next.next = new Node();
		head.next.next.data = 15;
		Node curr = head;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
		reverse(head);
		curr = head;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public static void main1(String[] args) {
		List<Integer> ls = new LinkedList<Integer>();
		ls.add(5);
		ls.add(10);
		ls.add(20);
		ls.stream().collect().
		
	}
}
