package newDynamic;

public class BinaryRepresentationOfAGivenNumber {
	void bin(int n)
	{
		if(n>1)
			bin(n/2);
		System.out.print(n%2);
	}
	public static void main(String[] args) {
		BinaryRepresentationOfAGivenNumber obj = new BinaryRepresentationOfAGivenNumber();
		obj.bin(5);
	}
}
