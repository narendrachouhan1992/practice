package GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;



public class Testtest {
	public class A
	{
		int x;
		
	}
	public class B extends A
	{
		int y;
		public B(int y) {
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		HashSet s = new HashSet();
		TreeSet t = new TreeSet();
		list s = new ArrayList();
		
		l.add(5);
		l.add(new Object());
		l.add("abc");
		for (Object o : l) {
			System.out.println(o);
		}
		try
		{
			System.out.println();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
