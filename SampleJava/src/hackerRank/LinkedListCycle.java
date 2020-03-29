package hackerRank;

public class LinkedListCycle {
	  class Node {
	        int data;
	        Node next;
	    }
	boolean hasCycle(Node head) {
		if(head==null || head.next==null || head.next.next==null)
		{
			return false;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while(true)
		{
			if(slow==null || fast == null)
			{
				return false;
			}
			if(slow.equals(fast))
			{
				return true;
			}
			slow = slow.next;
			if(fast.next!=null)
			{
				fast = fast.next.next;
			}
			else
			{
				return false;
			}
		}
	}
}
