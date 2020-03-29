package newDynamic;

public class FixTwoSwappedNodesOfBst {
	Node first = null;
	Node middle = null;
	Node last = null;
	Node prev;
	void correctUntill(Node root)
	{
		if(root == null)
			return;
		correctUntill(root.left);
		if(prev!= null && prev.data>root.data)
		{
			if(first == null)
			{
				first = prev;
				middle = root;
			}
			else
			{
				last = root;
			}
		}
		prev = root;
		correctUntill(root.right);
	}
	void correct(Node root)
	{
		first = middle = last = prev = null;
		correctUntill(root);
		if(last == null)
		{
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
		else
		{
			int temp = last.data;
			last.data = first.data;
			first.data = temp;
		}
	}
	void printInorder(Node root)
	{
		if(root == null)
		 return;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	public static void main(String[] args) {
		FixTwoSwappedNodesOfBst obj = new FixTwoSwappedNodesOfBst();
				/*   6
		        / \
		       10  2
		      / \ / \
		     1  3 7 12
		     
		    10 and 2 are swapped
		    */

		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		obj.printInorder(root);
		obj.correct(root);
		System.out.println();
		obj.printInorder(root);
	}
}
