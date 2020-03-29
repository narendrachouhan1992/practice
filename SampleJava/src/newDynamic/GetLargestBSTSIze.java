package newDynamic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GetLargestBSTSIze {
	static class Value {
		int data;

		public Value(int data) {
			this.data = data;
		}

	}

	int largestBSTUtil(Node node, Value min_ref, Value max_ref,Value max_size_ref, Value is_bst_ref)
	{

		/* Base Case */
		if (node == null)
		{
			is_bst_ref.data = 1; // An empty tree is BST
			return 0;    // Size of the BST is 0
		}
		
		int min = Integer.MAX_VALUE;

		/* A flag variable for left subtree property
		i.e., max(root->left) < root->data */
		boolean left_flag = false;
		
		/* A flag variable for right subtree property
		i.e., min(root->right) > root->data */
		boolean right_flag = false;
		
		int ls, rs; // To store sizes of left and right subtrees
		
		/* Following tasks are done by recursive call for left subtree
		a) Get the maximum value in left subtree (Stored in *max_ref)
		b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref)
		c) Get the size of maximum size BST in left subtree (updates *max_size) */
		max_ref.data = Integer.MIN_VALUE;
		ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
		if (is_bst_ref.data == 1 && node.data > max_ref.data)
		{
			left_flag = true;
		}
		
		/* Before updating *min_ref, store the min value in left subtree. So that we
		have the correct minimum value for this subtree */
		min = min_ref.data;
		
		/* The following recursive call does similar (similar to left subtree) 
		task for right subtree */
		min_ref.data =  Integer.MAX_VALUE;
		rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
		if (is_bst_ref.data == 1 && node.data < min_ref.data)
		{
			right_flag = true;
		}
		
		// Update min and max values for the parent recursive calls
		if (min < min_ref.data)
		{
			min_ref.data = min;
		}
		if (node.data < min_ref.data) // For leaf nodes
		{
			min_ref.data = node.data;
		}
		if (node.data > max_ref.data)
		{
			max_ref.data = node.data;
		}
		
		/* If both left and right subtrees are BST. And left and right
		subtree properties hold for this node, then this tree is BST.
		So return the size of this tree */
		if(left_flag && right_flag)
		{
			if (ls + rs + 1 >max_size_ref.data)
			max_size_ref.data = ls + rs + 1;
			return ls + rs + 1;
		}
		else
		{
		//Since this subtree is not BST, set is_bst flag for parent calls
			is_bst_ref.data = 0; 
			return 0;
		}
	}

	int getMaxSizeOfBST(Node root) {
		Value min_range = new Value(Integer.MIN_VALUE);
		Value max_range = new Value(Integer.MAX_VALUE);
		Value max_size = new Value(0);
		Value isBST = new Value(0);
		int size = largestBSTUtil(root, min_range, max_range, max_size, isBST);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Entry<Integer, Integer>> set;
		
		return size;
	}
	public static void main(String[] args) {
		/* Let us construct the following Tree
		        50
		     /      \
		   10        60
		  /  \       /  \
		 5   20    55    70
		          /     /  \
		        45     65    80
		*/
		
		Node root = new Node(50);
		root.left        = new Node(10);
		root.right       = new Node(60);
		root.left.left  = new Node(5);
		root.left.right = new Node(20);
		root.right.left  = new Node(55);
		root.right.left.left  = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		
		/* The complete tree is not BST as 45 is in right subtree of 50.
		   The following subtree is the largest BST
		      60
		    /  \
		  55    70
		 /     /  \
		45     65    80
		*/
		GetLargestBSTSIze obj = new GetLargestBSTSIze();
		System.out.println(obj.getMaxSizeOfBST(root));
	}

}
