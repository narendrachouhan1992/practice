package GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelMaximumSumBinaryTree {
	public int getMaxLevelSum(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int max = 0;
		int sum=0 ;
		q.add(root);
		while(!q.isEmpty())
		{
			int count = q.size();
			max = Integer.max(max, sum);
			sum  = 0;
			while(count>0)
			{
				TreeNode curr = q.poll();
				sum+=curr.val;
				if(curr.left != null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
				count--;
			}
		}
		return max;
	}
}
