package javaPractice;

class dummy
{
	int a;

	public dummy(int a) {
		super();
		this.a = a;
	}
	void modify(int b)
	{
		this.a = b;
	}
}
public class FinalTest {
	public static void main(String[] args) {
		final dummy obj = new dummy(5);
		
		System.out.println(obj.a);
		obj.modify(7);
		System.out.println(obj.a);
	}
}
