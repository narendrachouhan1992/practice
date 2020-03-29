package newDynamic;

public class MergeKSortedLinkedLists {
	
	int getMinimum(ListNode[] arr)
	{
		int minIndex = -1;
		for(int i=0;i<arr.length;i++)
		{
			if(minIndex== -1 && arr[i]!= null)
			{
				minIndex = i;
			}
			else if(i!= -1 && arr[i]!= null && arr[i].data<arr[minIndex].data)
				minIndex = i;
		}
		return minIndex;
	}
	ListNode mergeLL(ListNode[] ll)
	{
		ListNode res = null;
		ListNode end = null;
		int minIndex = getMinimum(ll);
		while(minIndex!= -1)
		{
			if(end == null)
			{
				res = ll[minIndex];
				end = ll[minIndex];
				ll[minIndex] = ll[minIndex].next;
			}
			else
			{
				end.next =  ll[minIndex];
				end = end.next;
				ll[minIndex] = ll[minIndex].next;
			}
			minIndex = getMinimum(ll);
		}
		return res;
	}
	void printlist(ListNode node)
	{
		if(node == null)
			return;
		System.out.println(node.data);
		printlist(node.next);
	}
	public static void main(String[] args) {
		MergeKSortedLinkedLists obj = new MergeKSortedLinkedLists();
		ListNode[] arr = new ListNode[3];
		arr[0] = new ListNode(1);
	    arr[0].next = new ListNode(3);
	    arr[0].next.next = new ListNode(5);
	    arr[0].next.next.next = new ListNode(7);
	 
	    arr[1] = new ListNode(2);
	    arr[1].next = new ListNode(4);
	    arr[1].next.next = new ListNode(6);
	    arr[1].next.next.next = new ListNode(8);
	 
	    arr[2] = new ListNode(0);
	    arr[2].next = new ListNode(9);
	    arr[2].next.next = new ListNode(10);
	    arr[2].next.next.next = new ListNode(11);
	    
	    obj.printlist(obj.mergeLL(arr));
	}
}
