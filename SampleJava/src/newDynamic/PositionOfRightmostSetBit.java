package newDynamic;

public class PositionOfRightmostSetBit {
	int getRightMostSetBitlocation(int num)
	{
		return ((int)(Math.log(num & -num)/Math.log(2)) +1);	
	}
	public static void main(String[] args) {
		PositionOfRightmostSetBit obj = new PositionOfRightmostSetBit();
		System.out.println(obj.getRightMostSetBitlocation(12));
	}
}
