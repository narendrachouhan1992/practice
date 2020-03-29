package newDynamic;

public class ConstructASpecialTreeFromGivenPreorderTraversal {
	Node root;
	int index_ptr = 0;
	Node constructtree(int[] pre,char[] preLN, int n)
	{
		if(index_ptr == n)
		{
			return null;
		}
		Node newNode = new Node(pre[index_ptr]);
		index_ptr++;
		if(preLN[index_ptr-1] == 'N')
		{
			newNode.left = constructtree(pre, preLN, n);
			newNode.right = constructtree(pre, preLN, n);
		}
		return newNode;
	}
	/* This function is used only for testing */
	void printInorder (Node node)
	{
	    if (node == null)
	        return;
	 
	    /* first recur on left child */
	    printInorder (node.left);
	 
	    /* then print the data of node */
	   System.out.println(node.data);
	   printInorder(node.right);
	}
	    /* now recur on right child */
	 
	public static void main(String[] args) {
		 int[] pre = {10, 30, 20, 5, 15};
		 char[] preLN = {'N', 'N', 'L', 'L', 'L'};
		 ConstructASpecialTreeFromGivenPreorderTraversal obj = new ConstructASpecialTreeFromGivenPreorderTraversal();
		 obj.root = obj.constructtree(pre, preLN, 5);
		 obj.printInorder(obj.root);
	}
}
