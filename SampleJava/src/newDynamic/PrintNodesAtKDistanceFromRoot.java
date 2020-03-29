package newDynamic;

public class PrintNodesAtKDistanceFromRoot {
	Node root = null;
	void printNodeWithDistanceK(Node current, int k)
	{
		if(current== null)
		{
			return;
		}
		if(k==0)
		{
			System.out.println(current.data);
		}
		printNodeWithDistanceK(current.left, k-1);
		printNodeWithDistanceK(current.right, k-1);
	}
	public static void main(String[] args) {
		PrintNodesAtKDistanceFromRoot tree = new PrintNodesAtKDistanceFromRoot();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		tree.printNodeWithDistanceK(tree.root, 2);
	}
}
