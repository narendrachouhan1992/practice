
public class DebtFund {
	static void calCulateAmmount(long sip)
	{
		double ammount = 102000;

		float rate = 8.5f;
		rate/=12;
		for(int i=0;i<12;i++)
		{
			ammount+=sip;
			double intr = (ammount*rate)/100;
			ammount+=intr;
		}
		System.out.println("invested amount is :126000");
		System.out.println("final ammount is :"+ammount);
	}
	public static void main(String[] args) {
		calCulateAmmount(2000);
	}
}
