package newDynamic;

public class LargestIndependentSetProblem {
	int LISS(Node curr)
	{
		if(curr ==null)
		{
			return 0;
		}
		int exc = LISS(curr.left) + LISS(curr.right);

		int inc = 1;
		if(curr.left!= null)
		{
			inc += (LISS(curr.left.right)+ LISS(curr.left.left));
		}
		if(curr.right != null)
		{
			inc += (LISS(curr.right.right)+ LISS(curr.right.left));
		}
		return Integer.max(inc, exc);
	}
	public static void main(String[] args) {
		Node root  = new Node(20);
	    root.left = new Node(8);
	    root.left.left          = new Node(4);
	    root.left.right         = new Node(12);
	    root.left.right.left   = new Node(10);
	    root.left.right.right  = new Node(14);
	    root.right               = new Node(22);
	    root.right.right        = new Node(25);
	 LargestIndependentSetProblem obj = new LargestIndependentSetProblem();
	 System.out.println(obj.LISS(root));
	}
}

