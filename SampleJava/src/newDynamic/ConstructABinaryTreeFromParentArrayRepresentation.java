package newDynamic;

public class ConstructABinaryTreeFromParentArrayRepresentation {
	Node root;
	void construct(int[] parent,int i,Node[] created)
	{
		if(created[i]!= null)
			return;
		created[i] = new Node(i);
		if(parent[i] == -1)
		{
			root = created[i];
			return;
		}
		if(created[parent[i]] == null)
		{
			construct(parent, parent[i], created);
		}
		Node p = created[parent[i]];
		if(p.left == null)
		{
			p.left = created[i];
		}else
		{
			p.right = created[i];
		}
	}
	  void inorder(Node node) 
	    {
	        if (node != null) 
	        {
	            inorder(node.left);
	            System.out.print(node.data + " ");
	            inorder(node.right);
	        }
	    }
	  
	void constructTree(int[] parent)
	{
		int length = parent.length;
		Node[] created = new Node[length];
		for(int i =0;i<length;i++)
		{
			construct(parent, i, created);
		}
	}
	public static void main(String[] args) {
		ConstructABinaryTreeFromParentArrayRepresentation obj = new ConstructABinaryTreeFromParentArrayRepresentation();
		int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		obj.constructTree(parent);
		obj.inorder(obj.root);
	}
}
