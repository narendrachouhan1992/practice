package amazone;

import java.util.Arrays;

class Nodeq {
	int data;
	Nodeq left;
	Nodeq right;

	public Nodeq(int data) {
		this.data = data;
		this.right = this.left = null;
	}
}

public class BinaryTreeToBinarySearchTreeConversion {
	Nodeq tree;
	int[] inorderArray;
	int index = 0;

	void getInorder(Nodeq curr) {
		if (curr == null)
			return;
		getInorder(curr.left);
		inorderArray[index++] = curr.data;
		getInorder(curr.right);
	}

	int getnodeCount(Nodeq curr) {
		if (curr == null)
			return 0;
		return (getnodeCount(curr.left) + getnodeCount(curr.right) + 1);
	}

	void getTreeFromArray(Nodeq curr) {
		if (curr == null) {
			return;
		}
		getTreeFromArray(curr.left);
		curr.data = inorderArray[index++];
		getTreeFromArray(curr.right);
	}

	void convertTreeToBST() {
		if (tree == null) {
			return;
		}
		int nodeCount = getnodeCount(tree);
		inorderArray = new int[nodeCount];
		getInorder(tree);
		System.out.println(Arrays.toString(inorderArray));
		Arrays.sort(inorderArray);
		index = 0;
		getTreeFromArray(tree);
		System.out.println(Arrays.toString(inorderArray));
	}
	public static void main(String[] args) {
		BinaryTreeToBinarySearchTreeConversion obj = new BinaryTreeToBinarySearchTreeConversion();
		obj.tree = new Nodeq(10);
		obj.tree.left = new Nodeq(30);
		obj.tree.right = new Nodeq(15);
		obj.tree.left.left = new Nodeq(20);
		obj.tree.right.right = new Nodeq(5);
		obj.convertTreeToBST();
	}
}
