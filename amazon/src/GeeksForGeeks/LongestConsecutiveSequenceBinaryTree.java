package GeeksForGeeks;

public class LongestConsecutiveSequenceBinaryTree {
static class Max
{
	int value;
}
	int getLongestSeq(TreeNode curr)
	{
		Max m = new Max();
		getLongestSeq(curr, 0, curr.val, m);
		return m.value;
	}
	void getLongestSeq(TreeNode curr, int currLen, int expected, Max m)
	{
		if(curr==null)
		{
			return ;
		}
		if(expected==curr.val)
			currLen++;
		else
			currLen=1;
		if(currLen>m.value)
			m.value=currLen;
		
		getLongestSeq(curr.left, currLen, curr.val+1, m);
		getLongestSeq(curr.right, currLen, curr.val+1, m);
		
	}
}
