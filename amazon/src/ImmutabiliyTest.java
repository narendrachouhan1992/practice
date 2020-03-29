
public class ImmutabiliyTest {
	public static void main(String[] args) {
		String a = new String("abcd");
		String b = a;
		a = new String("xyz");
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
		int x = 1;
		int y = x;
		x = 2;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
	}
}
