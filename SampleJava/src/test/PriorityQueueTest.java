package test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

 class Comp implements Comparator<String>
 {

	@Override
	public int compare(String o1, String o2) {
		return (o1.length() - o2.length());
	}
	 
 }
public class PriorityQueueTest {
	public static void main(String[] args) {
		Comp myc = new Comp();
		PriorityQueue<String> q = new PriorityQueue<String>(myc);
		q.add("narendra");
		q.add("akshay");
		q.add("paresh");
		q.add("bulbul");
		q.add("zeeshan");
		q.add("a");
		q.add("asd");
		Stack<Node> s = new Stack<Node>();
		for (String str : q) {
			System.out.println(str);
		}
	}
}
