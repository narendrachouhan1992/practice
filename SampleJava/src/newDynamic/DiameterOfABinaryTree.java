package newDynamic;

public class DiameterOfABinaryTree {
	int getHeight(Node root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Integer.max(getHeight(root.left), getHeight(root.right)) +1;
	}
	int getDiameter(Node root)
	{
		if(root == null)
			return 0;
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		return Math.max(lHeight+rHeight+1, Integer.max(getDiameter(root.left), getDiameter(root.right)));
	}
	public static void main(String[] args) {
		DiameterOfABinaryTree obj = new DiameterOfABinaryTree();
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(obj.getDiameter(root));
	}
}
