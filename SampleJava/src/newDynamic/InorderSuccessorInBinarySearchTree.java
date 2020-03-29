package newDynamic;

class Value
{
	boolean foundCurr = false;
}

public class InorderSuccessorInBinarySearchTree {
	Node getNextInOrder(Node root, Node key, Value val)
	{
		if(root == null)
			return null;
		getNextInOrder(root.left, key, val);
		if(val.foundCurr)
			return root;
		if(root == key)
		{	val.foundCurr = true;
			return null;
		}
		getNextInOrder(root.right, key, val);
		return null;
		
	}
	public static void main(String[] args) {
		InorderSuccessorInBinarySearchTree obj = new InorderSuccessorInBinarySearchTree();
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(17);
		System.out.println(obj.getNextInOrder(root, root.left.right, (new Value())).data);
	}
}
