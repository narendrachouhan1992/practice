
public class RecurringDepositQuarterly {
	double getValue(double monthly, double rate, double time)
	{
		double balance = 150000;
		rate /= 4;
		time*=4;
		for(int i =0; i<time ; i++)
		{
			double intrest = balance*rate/100 + monthly*2*rate/100 + 3500;
			balance += (intrest + monthly*3);
		}
		return balance+ 200000;
	}
	public static void main(String[] args) {
		RecurringDepositQuarterly obj = new RecurringDepositQuarterly();
		System.out.println(obj.getValue(20000.0, 6, 1));
	}
}
