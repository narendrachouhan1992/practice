package HackerRank.search;

import java.util.LinkedList;
import java.util.Queue;

public class SwapsAlgo {
	private static class Node {
		int val;
		Node left;
		Node right;
	}
	static int ind = 0;
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		Node head = new Node();
		head.val = 1;
		int[][] res = new int[queries.length][indexes.length];
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);
		int i = 0;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (indexes[i][0] != -1) {
				curr.left = new Node();
				curr.left.val = indexes[i][0];
				q.add(curr.left);
			}
			if (indexes[i][1] != -1) {
				curr.right = new Node();
				curr.right.val = indexes[i][1];
				q.add(curr.right);
			}
			i++;
		}
		for(i =0;i<queries.length;i++)
		{
			System.out.println();
			ind = 0;
			swap(head, queries[i], 1);
			populateInOrder(head,res, i);
		}
		return res;
		
	}
	private static void populateInOrder(Node curr,int[][] res, int index)
	{
		if(curr == null)
			return;
		populateInOrder(curr.left, res, index);
		res[index][ind++] = curr.val;
		System.out.print(curr.val+" ");
		populateInOrder(curr.right, res, index);
	}
	private static void swap(Node curr, int levelToSwap, int currLevel)
	{
		if(curr==null)
			return ;
		if(currLevel%levelToSwap == 0)
		{
			Node tmp = curr.left;
			curr.left = curr.right;
			curr.right = tmp;
		}
		
		swap(curr.left, levelToSwap, currLevel+1);
		swap(curr.right, levelToSwap, currLevel+1);
	
	}
	public static void main(String[] args) {
		int[][] s = { { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 }, { 10, 11 },
				{ -1, -1 }, { -1, -1 }, { -1, -1 } };
		int[] q = { 2 , 4};
		swapNodes(s, q);
	}

}
