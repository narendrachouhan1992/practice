package newDynamic;

public class FindDistanceBetweenTwoNodesOfABinaryTree {
	Node getLCA(Node root, int n1, int n2)
	{
		if(root == null)
			return null;
		if(root.data == n1 || root.data == n2)
			return root;
		Node left = getLCA(root.left, n1, n2);
		Node right = getLCA(root.right, n1, n2);
		if(left!= null && right != null)
			return root;
		else if(left!= null)
		{
			return getLCA(root.left, n1, n2);
		}
		return getLCA(root.right, n1, n2);
	}
	int getLevel(Node root, int n, int level)
	{
		if(root == null)
			return -1;
		if(root.data == n)
		{
			return level;
		}
		int left = getLevel(root.left, n, level+1);
	    if (left == -1)
	       return getLevel(root.right, n, level+1);
	    return left;
		
	}
	int getDistance(Node root, int n1, int n2)
	{
		Node lca = getLCA(root ,n1 ,n2);
		int d1 = getLevel(lca, n1, 0);
		int d2 = getLevel(lca, n2, 0);
		return d1+d2;
	}
	public static void main(String[] args) {
		FindDistanceBetweenTwoNodesOfABinaryTree obj = new FindDistanceBetweenTwoNodesOfABinaryTree();
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println(obj.getDistance(root, 4, 5));
	}
}
