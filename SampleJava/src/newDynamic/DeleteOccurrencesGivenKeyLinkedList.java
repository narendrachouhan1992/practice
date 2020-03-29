package newDynamic;

public class DeleteOccurrencesGivenKeyLinkedList {
	ListNode deleteOccurence(ListNode root, int key)
	{
		if(root== null)
			return null;
		if(root.data == key)
		{
			return deleteOccurence(root.next, key);
		}
		else
		{
			root.next = deleteOccurence(root.next, key);
			return root;
		}
	}
	void  printList(ListNode curr)
	{
		if(curr == null)
			return;
		System.out.print(curr.data+" ");
		printList(curr.next);
	}
	public static void main(String[] args) {
		DeleteOccurrencesGivenKeyLinkedList obj = new DeleteOccurrencesGivenKeyLinkedList();
		ListNode list = new ListNode(2);
		list.next  = new ListNode(2);
		list.next.next = new ListNode(1);
		list.next.next.next = new ListNode(8);
		list.next.next.next.next = new ListNode(2);
		list.next.next.next.next.next = new ListNode(3);
		list.next.next.next.next.next.next = new ListNode(2);
		list.next.next.next.next.next.next.next = new ListNode(7);
		obj.printList(list);
		list = obj.deleteOccurence(list, 2);
		System.out.println();
		obj.printList(list);
	}
}
