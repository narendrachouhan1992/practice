package GeeksForGeeks;

public class RearrangeALinkedListSuchThatAllEvenAndOddPositionedNodesAreTogether {

	static void rearrange(Node head)
	{
		if(head == null)
			return;
		Node odd = head;
		while(odd!=null && odd.data%2==1)
		{
			odd = odd.next;
		}
		if(odd==null)
			return;
		Node curr = odd.next;
		while(curr!=null)
		{
			if(curr.data%2==1)
			{
				int temp = curr.data;
				curr.data=odd.data;
				odd.data=temp;
				odd = odd.next;
			}
			curr=curr.next;
		}
	}
	static void printlist(Node curr)
	{
		if(curr==null)
			return;
		System.out.print(curr.data+", ");
		printlist(curr.next);
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		printlist(head);
		
		System.out.println();
		rearrange(head);
		printlist(head);
	}
}
