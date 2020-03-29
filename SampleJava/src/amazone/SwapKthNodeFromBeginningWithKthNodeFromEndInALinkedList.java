package amazone;

class Nodz 
{
	int data;
	Nodz next;
}
public class SwapKthNodeFromBeginningWithKthNodeFromEndInALinkedList {
	
	Nodz llist = new Nodz();
	Nodz end = llist;
	int getNodeCount()
	{
		int count = 0;
		Nodz temp = llist;
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		return count;
	}
	void replaceK(int k)
	{
		int length = getNodeCount();
		if(length<k)
		{
			return ;
		}
		if(2*k -1 == length )
			return ;
		
		Nodz X = llist;
		Nodz X_prev = null;
		for(int i=1;i<k;i++)
		{
			X_prev = X;
			X=X.next;
		}
		Nodz Y = llist;
		Nodz Y_prev = null;
		for(int i=1;i<length - k+1;i++)
		{
			Y_prev = Y;
			Y=Y.next;
		}
		if(X_prev==Y)
		{
			Y.next=X.next;
			Y_prev.next = X;
			X.next=Y;
		}
		else if(Y_prev==X)
		{
			X.next=Y.next;
			X_prev.next = Y;
			Y.next=X;
		} 
		else 
		{
			X.next=Y.next;
			
		}
		
	}
	public static void main(String[] args) {
		SwapKthNodeFromBeginningWithKthNodeFromEndInALinkedList obj = new SwapKthNodeFromBeginningWithKthNodeFromEndInALinkedList();
		for(int i=8;i>=1;i--)
		{
			obj.end.next = new Nodz();
			obj.end.data = i;
			obj.end=obj.end.next;		
		}
		
	}
}
