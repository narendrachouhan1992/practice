package javaPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InheritedMap<K, V> extends HashMap<K, V> {
	@Override
	public int hashCode() {
		
		return 1;
	}
	public static void main(String[] args) {
		Map<Integer, Character> im = new InheritedMap<Integer, Character>();
		im.put(3, 'c');
		im.put(4, 'd');
		im.put(5, 'e');
		im.put(1, 'a');
		im.put(null, '0');
	
		System.out.println("data");
	}
}

