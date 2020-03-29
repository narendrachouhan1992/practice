package newDynamic;

public class HighestPower2LessEqualGivenNumber {
	int getMaxPowTwoSmallerThanNumber(int num)
	{
		int i = (int)(Math.log(num)/Math.log(2));
		return (int)Math.pow(2, i);
	}
	public static void main(String[] args) {
		int n = 100;
		HighestPower2LessEqualGivenNumber obj = new HighestPower2LessEqualGivenNumber();
		System.out.println(obj.getMaxPowTwoSmallerThanNumber(n));
	}
}
