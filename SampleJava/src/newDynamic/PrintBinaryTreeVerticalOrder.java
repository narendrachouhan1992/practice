package newDynamic;

public class PrintBinaryTreeVerticalOrder {
	int left = 0;
	int right = 0;
	void printVertical(Node root)
	{
		setLeftRight(root, 0);
		if(left!= right)
		{
			for(int i =left;i<=right;i++)
			{
				System.out.print("level "+ i+ " is ");
				printLevel(root, i, 0);
				System.out.println();
			}
		}
	}
	void printLevel(Node root, int pos, int curr)
	{
		if(root== null)
			return;
		if(curr== pos)
		{
			System.out.print(root.data +" ");
		}
		printLevel(root.left, pos, curr-1);
		printLevel(root.right, pos, curr+1);
	}
	void setLeftRight(Node root, int pos)
	{
		if(root == null)
			return;
		if(left >pos)
			left = pos;
		if(right < pos)
			right = pos;
		setLeftRight(root.left, pos-1);
		setLeftRight(root.right, pos+1);
	}
	public static void main(String[] args) {
		PrintBinaryTreeVerticalOrder obj = new PrintBinaryTreeVerticalOrder();
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("vertical order traversal is :");
        obj.printVertical(root);
        /*
         *     1
         * 2      3
         *4 5   6   7
         *        8   9
         */
        
	}
}
