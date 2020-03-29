package geeksForGeeks;

public class XorSubarrayXors {
	int getXor(int[] arr) {
		int res = 0;
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int freq = (i + 1) * (N - i);
			if (freq % 2 == 1) {
				res = res ^ arr[i];
			}
		}
		return res;
	}


	public static void main(String[] args) {
		XorSubarrayXors obj = new XorSubarrayXors();

		int[] arr = { 3, 5, 2, 4, 6 };
		System.out.println(obj.getXor(arr));
	}
}
