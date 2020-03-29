package GeeksForGeeks;

public class ConstructASpecialTreeFromGivenPreorderTraversal {
	int index= 1;
	TreeNode head;
	void createTreeUntil(int[] arr, char[] ln, int n, TreeNode curr)
	{
		  if(index==n)
		  {
			  return;
		  }
		  if(ln[index]=='N')
		  {
			  curr.left = new TreeNode(arr[index++]);
			  createTreeUntil(arr, ln, n, curr.left);
			  curr.right = new TreeNode(arr[index++]);
			  createTreeUntil(arr, ln, n, curr.right);
		  }
	}
	void createNode(int[] arr, char[] ln)
	{
		head = new TreeNode(arr[0]);
		createTreeUntil(arr, ln, ln.length, head);
	}
	public static void main(String[] args) {
		
	}
	
}
