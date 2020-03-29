package newDynamic;

public class AddGreaterValuesEveryNodeGivenBst {
	int max = 0;
	void modifytree(Node root)
	{
		if(root == null)
			return;
		modifytree(root.right);
		root.data += max;
		max = root.data;
		modifytree(root.left);
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
		AddGreaterValuesEveryNodeGivenBst obj = new AddGreaterValuesEveryNodeGivenBst();
	   /* Let us create following BST
			        50
			     /     \
			    30      70
			   /  \    /  \
			 20   40  60   80 */
		Node tree = new Node(50);
		tree.left = new Node(30);
		tree.right = new Node(70);
		tree.left.left = new Node(20);
		tree.left.right = new Node(40);
		tree.right.left = new Node(60);
		tree.right.right = new Node(80);
		obj.printInorder(tree);
		System.out.println();
		obj.modifytree(tree);
		obj.printInorder(tree);
	}
}
