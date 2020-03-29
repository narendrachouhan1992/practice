
public class IntrestInLIC {
	double getIntrest(int yInst, int time, double rate )
	{
		double ammount = 0;
		rate = rate/4;
		for(int i=0;i<time;i++)
		{
			ammount+=yInst;
			ammount+= ammount*rate/100;
			ammount+= ammount*rate/100;
			ammount+= ammount*rate/100;
			ammount+= ammount*rate/100;
		}
		
		return ammount;
	}
	public static void main(String[] args) {
		IntrestInLIC obj = new IntrestInLIC();
		System.out.println(obj.getIntrest(40000, 30, 9));
	}
}
