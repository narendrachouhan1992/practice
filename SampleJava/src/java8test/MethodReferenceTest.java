package java8test;

import java.util.function.BiFunction;

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}
	
}
interface Ab
{
	default int getnum()
	{
		return 5;
	}
	int addin(int a, int b);
}
public class MethodReferenceTest {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
			int result = adder.apply(10, 20);
		System.out.println(result);
		Ab x = Arithmetic::add;
		System.out.println(x.getnum());
		
	}
}