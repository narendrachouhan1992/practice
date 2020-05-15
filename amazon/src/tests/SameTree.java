package tests;

public class SameTree {
	static class Node
	{
		int val;
		Node left;
		Node right;
		public Node(int val) {
			super();
			this.val=val;
		}
	}
	static int preIndex=0;
	static Node buildTree(char in[], char pre[], int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.val); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
  
        return tNode; 
    } 
	static boolean checktree(int preorder[], int inorder[], int postorder[], int len)
    {
		boolean[] visited=
		for(int i=0;i<preorder;i++)
		{
			
		}
			
		return true;
    }
}
