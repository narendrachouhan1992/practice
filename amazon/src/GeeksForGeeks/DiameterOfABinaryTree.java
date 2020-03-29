package GeeksForGeeks;

public class DiameterOfABinaryTree {
	int getDiameter(TreeNode node)
	{
		if(node==null)
			return 0;
		int rdiameter = getDiameter(node.right);
		int ldiameter = getDiameter(node.left);
		
		int lh = getHeight(node.left);
		int rh = getHeight(node.right);
		return Integer.max(rdiameter, Integer.max(ldiameter, (lh+rh+1)));
		
	}
	int getHeight(TreeNode node)
	{
		if(node==null)
			return 0;
		return Integer.max(getHeight(node.left), getHeight(node.right))+1;
	}
	public static void main(String[] args) {
		DiameterOfABinaryTree obj = new DiameterOfABinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(obj.getDiameter(root));
	}
}
