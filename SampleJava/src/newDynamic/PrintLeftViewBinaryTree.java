package newDynamic;

public class PrintLeftViewBinaryTree {
	int max_level = 0;
	void printLeft(Node root, int level)
	{
		if(root == null)
			return;
		if(level>max_level)
		{
			System.out.print(root.data + " ");
			max_level = level;
			
		}
		printLeft(root.left, level+1);
		printLeft(root.right, level+1);
	}
	public static void main(String[] args) {
		PrintLeftViewBinaryTree obj = new PrintLeftViewBinaryTree();
		Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        obj.printLeft(root, 1);
	}
}
