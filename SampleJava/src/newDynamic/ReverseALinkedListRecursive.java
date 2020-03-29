package newDynamic;

public class ReverseALinkedListRecursive {
	static ListNode head;
	 
    static class ListNode {
 
        int data;
        ListNode next;
 
        ListNode(int d) {
            data = d;
            next = null;
        }
    }
 
    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    ListNode reverseUtil(ListNode curr, ListNode prev) {
 
        /* If last ListNode mark it head*/
        if (curr.next == null) {
            head = curr;
 
            /* Update next to prev ListNode */
            curr.next = prev;
            return null;
        }
 
        /* Save curr->next ListNode for recursive call */
        ListNode next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
        reverseUtil(next1, curr);
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
		ReverseALinkedListRecursive obj = new ReverseALinkedListRecursive();
		ListNode head = new ListNode(85);
		head.next = new ListNode(15); 
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(20);
		ReverseALinkedListRecursive.head = head;
		obj.printList(ReverseALinkedListRecursive.head);
		obj.reverseUtil(ReverseALinkedListRecursive.head, null);
		System.out.println();
		obj.printList(ReverseALinkedListRecursive.head);
	}
}
