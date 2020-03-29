package java8test;

import java.util.ArrayList;
import java.util.List;

class ForeachOrderTest
{
	public static void main(String[] args) {
		List<String> st = new ArrayList<>();
		st.add("narendra");
		st.add("kajol");
		st.add("chouhan");
		st.add("pareta");
		st.stream().sorted().forEachOrdered(System.out::println);
	}
}