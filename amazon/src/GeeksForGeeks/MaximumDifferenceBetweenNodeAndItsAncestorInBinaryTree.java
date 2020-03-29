package GeeksForGeeks;
class Result
{
	int r=Integer.MIN_VALUE;
}
public class MaximumDifferenceBetweenNodeAndItsAncestorInBinaryTree {
	int findMinAndPopulRes(TreeNode root, Result res)
	{
		if(root ==null) return Integer.MAX_VALUE;
		if(root.left==null && root.right==null) return root.val;
		
		int min = Integer.min(findMinAndPopulRes(root.left, res),findMinAndPopulRes(root.right, res));
		res.r = Integer.max(res.r, root.val -min);
		
		return Integer.min(min,root.val);
	}
	int findMaxDiff(TreeNode root)
	{
		Result res = new Result();
		findMinAndPopulRes(root, res);
		return res.r;
	}
}
