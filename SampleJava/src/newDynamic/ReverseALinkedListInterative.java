package newDynamic;

class ListNode
{
	int data;
	ListNode next;
	public ListNode(int data) {
		this.data = data;
		// TODO Auto-generated constructor stub
	}
}
public class ReverseALinkedListInterative {
	ListNode reverse(ListNode head)
	{
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		
		return head;
	}
	void printList(ListNode head)
	{
		if(head != null)
		{
			System.out.print(head.data + " ");
			printList(head.next);
		}
	}
	public static void main(String[] args) {
		ReverseALinkedListInterative obj = new ReverseALinkedListInterative();
		ListNode head = new ListNode(85);
		head.next = new ListNode(15); 
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(20);
		obj.printList(head);
		head = obj.reverse(head);
		System.out.println();
		obj.printList(head);
	}
}
