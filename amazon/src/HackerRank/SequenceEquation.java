package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SequenceEquation {
	static int[] permutationEquation(int[] p) {
		int[] pr = new int[p.length+1];
		for (int i = 0; i < p.length; i++) {
			pr[i+1] =p[i];
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i < pr.length; i++) {
			map.put(i, pr[pr[i]]);
		}

		map.forEach((k,v)->{
			p[v-1]= k;
		});
return p;
	}
	static int[] permutationEquation1(int[] p) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < p.length; i++) {
			map.put(i, p[p[i]-1]);
		}

		map.forEach((k,v)->{
			p[v-1]= k+1;
		});
		return p;
	}
	public static void main(String[] args) {
		int[] a = {4, 3, 5, 1, 2};
		System.out.println(Arrays.toString(permutationEquation1(a)));
	}
}
