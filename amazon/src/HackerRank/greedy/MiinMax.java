package HackerRank.greedy;

import java.util.Arrays;

public class MiinMax {
	static int maxMin(int k, int[] arr) {

		Arrays.parallelSort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= arr.length - k; i++) {
			if (arr[i + k - 1] - arr[i] < min)
				min = arr[i + k - 1] - arr[i];
		}
		return min;
	}

	public static void main(String[] args) {
		int[] a = { 100, 200, 300, 350, 400, 401, 402 };
		System.out.println(maxMin(3, a));
	}

}
