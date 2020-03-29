package GeeksForGeeks;


public class HowToDetermineIfABinaryTreeIsBalanced {
	static class Height
	{
		int height;
	}
	boolean isBalanced(TreeNode curr, Height h)
	{
		if(curr==null)
			return true;
		Height lHeight = new Height();
		Height rHeight = new Height();
		if(!(isBalanced(curr.left, lHeight) && isBalanced(curr.right, rHeight)))
			return false;
		
		h.height = (lHeight.height>rHeight.height?lHeight.height:rHeight.height )+1;
		
		if(Math.abs(lHeight.height-rHeight.height)<=1)
			return true;
		return false;
	}
}
