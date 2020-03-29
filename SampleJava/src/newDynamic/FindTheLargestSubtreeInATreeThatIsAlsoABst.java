package newDynamic;
class Data
{
	boolean isBST;
	int min;
	int max;
	int max_size;
}
public class FindTheLargestSubtreeInATreeThatIsAlsoABst {
	int getBST(Node root, Data val)
	{
		if(root == null)
		{
			val.isBST = true;
			return 0;
		}
		if(root.left == null && root.right== null)
		{
			val.isBST = true;
			val.max_size = 1;
			val.max = root.data;
			val.min = root.data;
			return 1;
		}
		int ll = 0;
		int rl = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean leftFlag = false;
		boolean rightFlag = false;
		ll = getBST(root.left, val);
		if(val.isBST && root.data> val.max)
		{
			leftFlag = true;
			min = val.min;
		}
		
		rl = ll = getBST(root.right, val);
		if(val.isBST && root.data<val.min)
		{
			rightFlag = true;
			max = val.max;
		}
		
		if(leftFlag && rightFlag)
		{
			val.min = min;
			val.max = max;
			val.max_size =  (ll+rl+ 1);
			val.isBST = true;
			return val.max_size;
		} else
		{
			val.isBST = false;
			return 0;
		}
	}
	public static void main(String[] args) {
		FindTheLargestSubtreeInATreeThatIsAlsoABst obj = new FindTheLargestSubtreeInATreeThatIsAlsoABst();
		Node root = new Node(50);
        root.left = new Node(10);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(55);
        root.right.left.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        System.out.println(obj.getBST(root, new Data()));
	}
}
