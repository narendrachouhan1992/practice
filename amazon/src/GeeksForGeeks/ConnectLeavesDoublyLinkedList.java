package GeeksForGeeks;

import apple.laf.JRSUIUtils.Tree;

public class ConnectLeavesDoublyLinkedList {
	TreeNode head;
	 TreeNode prev;
	TreeNode root;
	 TreeNode getDll(TreeNode node)
	{
		
		
		if(node == null)
			return null;
		else if(node.left==null && node.right==null)
		{
			if(head==null)
			{
				head = node;
				prev = node;
			}
			else
			{
				prev.right=node;
				node.left=prev;
				prev = node;
			}
			return null;
		}
		root.left=getDll(node.left);
		root.right=getDll(node.right);
		return node;
	}
}
