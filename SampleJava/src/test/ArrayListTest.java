package test;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=1;i<10;i++)
		{
			l.add(i);
		}
		l.remove(5);
		System.out.println(l);
	}
}
