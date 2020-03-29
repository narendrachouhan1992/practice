package newDynamic;

public class LowestCommonAncestorBinaryTreeSet1 {
	void findLCN(Node root, int x, int y)
	{
		findUntill(root, x, y);
	}
	boolean findUntill(Node root, int x, int y)
	{
		if(root == null)
		{
			return false;
		}
		if(root.data == x || root.data == y)
		{
			return true;
		}
		boolean left =findUntill(root.left, x, y);
		boolean right = findUntill(root.right, x, y); 
		if( left && right)
		{
			System.out.println(root.data);
			return true;
		}
		return (left|| right);
	}
	public static void main(String[] args) {
		LowestCommonAncestorBinaryTreeSet1 obj = new LowestCommonAncestorBinaryTreeSet1();
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.left.left = new Node(9);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    obj.findLCN(root, 9, 6);
	    /*
	     *      1
	     * 2         3
	     *4  5     6  7
	     9
	     */
	    
	    
	}
}
