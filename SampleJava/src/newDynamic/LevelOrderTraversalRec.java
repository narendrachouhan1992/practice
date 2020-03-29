package newDynamic;

public class LevelOrderTraversalRec {
	void printlevelOrder(Node root)
	{
		int height = height(root);
		for(int i=0;i<height;i++)
		{
			printLevel(root, i);
		}
	}
	void printLevel(Node root, int level)
	{
		if(root == null)
			return;
		if(level == 0)
		{
			System.out.print(root.data+" ");
		}
		else
		{
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	int height(Node node) 
    {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
	public static void main(String[] args) {
		LevelOrderTraversalRec obj = new LevelOrderTraversalRec();
		Node root = new Node(1);
		root.left        = new Node(2);
	    root.right       = new Node(3);
	    root.left.left  = new Node(7);
	    root.left.right = new Node(6);
	    root.right.left  = new Node(5);
	    root.right.right = new Node(4);
	    obj.printlevelOrder(root);
	}
}
