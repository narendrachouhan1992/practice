package newDynamic;

public class DifferenceBetweenSumsOfOddAndEvenLevels {
	Node root;
	int getDiff(Node curr)
	{
		if(curr==null)
		{
			return 0;
		} 
		return curr.data -getDiff(curr.left) -getDiff(curr.right); 
	}
	public static void main(String[] args) {
		DifferenceBetweenSumsOfOddAndEvenLevels tree = new DifferenceBetweenSumsOfOddAndEvenLevels();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		System.out.println(tree.getDiff(tree.root));
	}
}
