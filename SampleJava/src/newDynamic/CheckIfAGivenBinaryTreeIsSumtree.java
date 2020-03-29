package newDynamic;

public class CheckIfAGivenBinaryTreeIsSumtree {
	int getSum(Node node)
	{
		if(node== null)
			return 0;
		return (getSum(node.left) + getSum(node.right)+ node.data);
	}
	boolean isSumtree(Node node)
	{
		if(node == null || (node.left == null && node.right == null))
			return true;
		int lsum;
		int rsum;
		lsum = getSum(node.left);
		rsum = getSum(node.right);
		if(isSumtree(node.left) && isSumtree(node.right) && (node.data == lsum+rsum))
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		CheckIfAGivenBinaryTreeIsSumtree obj = new CheckIfAGivenBinaryTreeIsSumtree();
		Node root = new Node(26);
		root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        if(obj.isSumtree(root))
        	System.out.println("yes");
        else
        	System.out.println("NO");
  
	}
}
