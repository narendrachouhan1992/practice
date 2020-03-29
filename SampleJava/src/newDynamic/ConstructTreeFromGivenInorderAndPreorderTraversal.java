package newDynamic;

public class ConstructTreeFromGivenInorderAndPreorderTraversal {
	int preIndex = 0;
	Node buildTree(int[] in, int[] pre, int i, int j)
	{
		if(i>j)
			return null;
		Node temp = new Node(pre[preIndex++]);
		if(i==j)
			return temp;
		else
		{
			int x;
			for(x = i;x<=j;x++)
			{
				if(temp.data == in[x])
					break;
			}
			temp.left = buildTree(in, pre, i, x-1);
			temp.right = buildTree(in, pre, x+1, j);
			return temp;
		}
	}
	void printInorder(Node root)
	{
		if(root== null)
			return;
		printInorder(root.left);
		System.out.print(root.data+ " ");
		printInorder(root.right);
	}
	public static void main(String[] args) {
		ConstructTreeFromGivenInorderAndPreorderTraversal obj = new ConstructTreeFromGivenInorderAndPreorderTraversal();
		int in[] = new int[]{1, 2, 3, 4, 5, 6};
        int pre[] = new int[]{4, 2, 1, 3, 6, 5};
        
        obj.printInorder(obj.buildTree(in, pre, 0, in.length-1));
	}
}
