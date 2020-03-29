package test;
class NumInt
{
	int i;
}
public class TestCallByReference {
	void method(NumInt x)
	{
		x.i = 5;
	}
	public static void main(String[] args) {
		TestCallByReference obj = new TestCallByReference();
		NumInt num = new NumInt();
		num.i = 10;
		System.out.println(num.i);
		obj.method(num);
		System.out.println(num.i);
	}
}
