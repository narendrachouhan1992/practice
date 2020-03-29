package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class PrintExtremeNodesOfEachLevelOfBinaryTreeInAlternateOrder {
	void printExtreamZigZag(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		boolean flag = false;
		while(!q.isEmpty())
		{
			int nodeCount = q.size();
			int n = nodeCount;
			while(n!=0)
			{
				n--;
				Node curr = q.poll();
				if(curr.left!= null)
					q.add(curr.left);
				if(curr.right != null)
					q.add(curr.right);
				
				if(flag && n == (nodeCount-1))
					System.out.print(curr.data+ " ");
				if(!flag && n == 0)
					System.out.print(curr.data+ " " );
			}
			flag = !flag;
		}
	}
	public static void main(String[] args) {
		PrintExtremeNodesOfEachLevelOfBinaryTreeInAlternateOrder obj = new PrintExtremeNodesOfEachLevelOfBinaryTreeInAlternateOrder();
		Node root = new Node(1);
		 
	    root.left = new Node(2);
	    root.right = new Node(3);
	 
	    root.left.left  = new Node(4);
	    root.left.right = new Node(5);
	    root.right.right = new Node(7);
	 
	    root.left.left.left  = new Node(8);
	    root.left.left.right  = new Node(9);
	    root.left.right.left  = new Node(10);
	    root.left.right.right  = new Node(11);
	    root.right.right.left  = new Node(14);
	    root.right.right.right  = new Node(15);
	 
	    root.left.left.left.left  = new Node(16);
	    root.left.left.left.right  = new Node(17);
	    root.right.right.right.right  = new Node(31);
	    obj.printExtreamZigZag(root);
	}
}
