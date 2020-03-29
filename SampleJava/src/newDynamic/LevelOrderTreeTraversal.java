package newDynamic;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversal {
	void printLevelOrderTree(Node root)
	{
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node curr = queue.poll();
			if(curr.left!= null)
				queue.add(curr.left);
			if(curr.right!= null)
				queue.add(curr.right);
			System.out.print(curr.data + " ");
		}
	}
	public static void main(String[] args) {
		Node root = new Node();
		LevelOrderTreeTraversal obj = new LevelOrderTreeTraversal();
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        obj.printLevelOrderTree(root);
	}
}
