package GeeksForGeeks;

public class ReverselinkedList {
	static Node HEAD = null;;
	static Node reveIterative(Node head)
	{
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr  = next;
		}
		head = prev;
		return head;
	}
	static Node rev(Node curr)
	{
		return revrec(null, curr);
		
	}
	static Node revrec(Node prev, Node curr)
	{
		if(curr.next==null)
		{
			HEAD = curr;
			curr.next=prev;
			
			return HEAD;
		}
		Node next = curr.next;
		curr.next = prev;
		revrec(curr, next);
		return HEAD;
	}
	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(5);
		head.next.next = new Node(8);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(12);
		head.next.next.next.next.next = new Node(15);
		Node curr = head;
		
		while(curr!=null)
		{
			System.out.print(curr.toString()+" ");
			curr=curr.next;
		}
		System.out.println();
		
		head = reveIterative(head);
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.toString()+" ");
			curr = curr.next;
		}
		
		
	}
}
