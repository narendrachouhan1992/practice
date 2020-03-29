package newDynamic;

import java.util.Arrays;

public class SegmentTreeSet1RangeMinimumQuery {
	int[] tree;
	int creatSagmentTreeUntil(int[] arr, int s, int e, int c)
	{
		if(s== e)
		{
			tree[c] = arr[s];
			return arr[s];
		}
		else
		{
			int mid = (s+e)/2;
			tree[c] = Integer.min(creatSagmentTreeUntil(arr, s, mid, c*2+1), creatSagmentTreeUntil(arr, mid+1, e, c*2+2));
			return tree[c];
		}
	}
	void createSagmenttree(int[] arr)
	{
		int n = arr.length;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int maxSize = 2*((int)Math.pow(2, x) -1);
		tree = new int[maxSize];
		creatSagmentTreeUntil(arr, 0, n-1, 0);
		System.out.println(Arrays.toString(tree));
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 7, 9, 11};
		SegmentTreeSet1RangeMinimumQuery obj =new SegmentTreeSet1RangeMinimumQuery();
		obj.createSagmenttree(arr);
		System.out.println();
	}
}
