package newDynamic;

public class ConvertAGivenTreeToSumTree {
	int convertToSumTree(Node root)
	{
		if(root == null)
			return 0;
		else if (root.left== null && root.right== null) {
			return root.data;
		}
		else
		{
			root.data = convertToSumTree(root.left) + convertToSumTree(root.right);
		}
		return root.data;
	}
	void inorder(Node node) 
    {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
	public static void main(String[] args) {
		ConvertAGivenTreeToSumTree obj = new ConvertAGivenTreeToSumTree();
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
  
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
     
        System.out.println("Inorder traversal of given obj is : ");
        obj.inorder(root);
        obj.convertToSumTree(root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        
        System.out.println("");
        System.out.println("Inorder traversal of modified obj is : ");
        obj.inorder(root);
	}
}
