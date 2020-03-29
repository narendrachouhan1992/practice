package newDynamic;

public class MergeTwoSortedLinkedLists {
	ListNode mergeLL(ListNode a, ListNode b)
	{
		ListNode res;
		
		if(a == null)
			res = b;
		else if(b==null)
			res = a;
		else
		{
			if(a.data > b.data)
			{
				res = b;
				b = b.next;
			}
			else
			{
				res = a;
				a = a.next;
			}
			res.next = mergeLL(a, b);
		}
		return res;
	}
	void print(ListNode node)
	{
		while(node != null)
		{
			System.out.print(node.data +" " );
			node= node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		MergeTwoSortedLinkedLists obj = new MergeTwoSortedLinkedLists();
		ListNode a = new ListNode(5);
		a.next = new ListNode(10);
		a.next.next = new ListNode(15);
		obj.print(a);
		
		ListNode b = new ListNode(2);
		b.next = new ListNode(3);
		b.next.next = new ListNode(20);
		obj.print(b);
		obj.print(obj.mergeLL(a, b));
	}
}
