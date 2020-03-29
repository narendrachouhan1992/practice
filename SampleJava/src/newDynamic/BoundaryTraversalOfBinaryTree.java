package newDynamic;

public class BoundaryTraversalOfBinaryTree {
	Node root;
	void printLeftboundary(Node root)
	{
		if(root!= null)
		{
			if(root.left!= null)
			{
				System.out.print(root.data+ ", ");
				printLeftboundary(root.left);
			}
			else if(root.right != null)
			{
				System.out.print(root.data+ ", ");
				printLeftboundary(root.right);
			}
		}
	}
	void printLeaves(Node root)
	{
		if(root!= null)
		{
			printLeaves(root.left);
			if(root.left == root.right &&root.right == null)
			{
				System.out.print(root.data+", ");
			}
			printLeaves(root.right);
		}
	}
	void printRightBoundary(Node root)
	{
		if(root!= null)
		{
			if(root.right!= null)
			{
				printLeftboundary(root.right);
				System.out.print(root.data +", ");
			}
			else if(root.left != null)
			{
				printLeftboundary(root.left);
				System.out.print(root.data+", ");
			}
		}
	}
	void printBoundary(Node root)
	{
		if(root!= null)
		{
			System.out.print(root.data + ", ");
			printLeftboundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
		
	}
	public static void main(String[] args) {
		BoundaryTraversalOfBinaryTree obj = new BoundaryTraversalOfBinaryTree();
	    obj.root = new Node(20);
        obj.root.left = new Node(8);
        obj.root.left.left = new Node(4);
        obj.root.left.right = new Node(12);
        obj.root.left.right.left = new Node(10);
        obj.root.left.right.right = new Node(14);
        obj.root.right = new Node(22);
        obj.root.right.right = new Node(25);
//              20
//          8            22
//      4      12             25
//           10  14
        obj.printBoundary(obj.root);
	}
}
