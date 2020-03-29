package GeeksForGeeks;

import sun.reflect.generics.tree.TypeTree;

public class ConvertAGivenTreeToSumTree {
	int getSumtree(TreeNode node)
	{
		if(node==null)
			return 0;
		
		int curr = node.val;
		node.val = getSumtree(node.left)+ getSumtree(node.right);
		return curr+node.val;
	}
	void inorder(TreeNode node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.val+", ");
		inorder(node.right);
	}
	public static void main(String[] args) {
		ConvertAGivenTreeToSumTree obj = new ConvertAGivenTreeToSumTree();
		/* Constructing tree given in the above figure */
		TreeNode root = new TreeNode(10); 
        root.left = new TreeNode(-2); 
        root.right = new TreeNode(6); 
        root.left.left = new TreeNode(8); 
        root.left.right = new TreeNode(-4); 
        root.right.left = new TreeNode(7); 
        root.right.right = new TreeNode(5); 
        obj.inorder(root);
        System.out.println();
        obj.getSumtree(root);
        obj.inorder(root);
	}
}
