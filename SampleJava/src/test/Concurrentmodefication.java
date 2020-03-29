package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Concurrentmodefication {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(8);
		list.add(8);
		list.add(7);
		list.add(5);
		list.add(4);
		System.out.println(list.toString());
		list.remove(new Integer(8));
		System.out.println(list.toString());
		
	}
}
