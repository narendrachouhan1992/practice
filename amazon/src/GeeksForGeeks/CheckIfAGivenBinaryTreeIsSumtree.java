package GeeksForGeeks;

public class CheckIfAGivenBinaryTreeIsSumtree {
	static boolean iSSumTree(TreeNode node)
	{
		int ls;
		int rs;
		if(node==null || (node.left==null && node.right == null))
			return true;
		
		if(iSSumTree(node.left) && iSSumTree(node.right))
		{
			if(node.left==null)
				ls = 0;
			else if(node.left.left==null && node.left.right==null)
			{
				ls = node.left.val;
			}
			else
			{
				ls = node.left.val*2;
			}
			
			if(node.right==null)
				rs=0;
			else if(node.right.left==null && node.right.right==null)
				rs=node.right.val;
			else 
			{
				rs = node.right.val*2;
			}
			
			if(node.val==rs+ls)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(26); 
        root.left = new TreeNode(10); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(6); 
        root.right.right = new TreeNode(3); 
        if(iSSumTree(root))
        {
        	System.out.println("yes");
        }
        else
        {
        	System.out.println("no");
        }
	}
}
