package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSort {
	public static void main(String[] args) {
		String[] s = {"10","190", "9","90" };
		System.out.println(Arrays.toString(s));
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		Set<Integer> rt = new HashSet<>();
		rt.forEach(i-> System.out.println(i));
	}
}
