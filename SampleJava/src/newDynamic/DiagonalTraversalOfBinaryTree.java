package newDynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiagonalTraversalOfBinaryTree {
	void printDiagonalUntill(Node root, HashMap<Integer, ArrayList<Integer>> map, int i)
	{
		if(root == null)
			return;
		ArrayList<Integer> list = map.get(i);
		if(list == null)
		{
			list = new ArrayList<Integer>();
			list.add(root.data);
		}
		else
		{
			list.add(root.data);
		}
		map.put(i, list);
		printDiagonalUntill(root.right, map, i);
		printDiagonalUntill(root.left, map, i+1);
	}
	void printDiagonal(Node root)
	{
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		printDiagonalUntill(root, map, 0);
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
	}
	public static void main(String[] args) {
		DiagonalTraversalOfBinaryTree obj = new DiagonalTraversalOfBinaryTree();
		Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        obj.printDiagonal(root);
	}
}
