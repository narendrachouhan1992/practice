package PhaseTwo;

public class PositionOfRightmostSetBit_p2 {

	public int findFirsOne(int a)
	{
		int andWith2sCompliment = (a&(-a));
		int position= (int) (Math.log10(andWith2sCompliment)/Math.log10(2)) +1;
		return position;
	}
	public static void main(String[] args) {
		int num = 12;
		PositionOfRightmostSetBit_p2 obj = new PositionOfRightmostSetBit_p2();
		System.out.println("first set bit is "+obj.findFirsOne(num));
		
	}
}
