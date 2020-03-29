package newDynamic;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeRandomPointers {
	Map<Node, Node> map = new HashMap<>();
	void createMap(Node root)
	{
		if(root!= null)
		{
			Node temp = new Node(root.data);
			map.put(root, temp);
			createMap(root.left);
			createMap(root.right);
		}
	}
	Node populateClone(Node root, Node clone)
	{
		if(root == null)
			return null;
		clone = map.get(root);
		clone.random = map.get(root.random);
		clone.left = populateClone(root.left, clone.left);
		clone.right = populateClone(root.right, clone.right);
		return clone ;
	}
	Node createClone(Node root)
	{
		createMap(root);
		return populateClone(root, map.get(root));
	}
	void printInorder(Node root)
	{
		if(root ==null)
			return;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	public static void main(String[] args) {
		CloneBinaryTreeRandomPointers obj = new CloneBinaryTreeRandomPointers();
		Node tree = new Node(1);
	    tree.left = new Node(2);
	    tree.right = new Node(3);
	    tree.left.left = new Node(4);
	    tree.left.right = new Node(5);
	    tree.random = tree.left.right;
	    tree.left.left.random = tree;
	    tree.left.right.random = tree.right;
	    obj.printInorder(tree);
	    Node clone = obj.createClone(tree);
	    System.out.println();
	    obj.printInorder(clone);
	}
}
