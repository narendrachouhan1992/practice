package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelMaximumSumBinaryTree {
	int getMaxLevelSum(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		if(root== null)
			return 0;
		q.add(root);
		int res = 0;
		while(!q.isEmpty())
		{
			int length = q.size();
			int sum = 0;
			while(length != 0)
			{
				 Node curr = q.peek();
				 q.remove();
				 sum+= curr.data;
				 if(curr.left != null)
				 {
					 q.add(curr.left);
				 }
				 if(curr.right != null)
				 {
					 q.add(curr.right);
				 }
				 length --;
			}
			res = Integer.max(res, sum);
		}
		return res;
	}
	public static void main(String[] args) {
		FindLevelMaximumSumBinaryTree obj = new FindLevelMaximumSumBinaryTree();
		Node root = new Node();
		root.left = new Node(2);
	    root.right       = new Node(3);
	    root.left.left  = new Node(4);
	    root.left.right = new Node(5);
	    root.right.right = new Node(8);
	    root.right.right.left  = new Node(6);
	    root.right.right.right  = new Node(7);
	    System.out.println(obj.getMaxLevelSum(root));
	}
}
