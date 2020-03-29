import java.lang.annotation.Retention;

public class PF {
	double getReturns(double yearlyInvst, double rate, int time)
	{
		long ammount = 0;
		for(int i=0;i< time;i++)
		{
			ammount+=yearlyInvst;
			ammount += (ammount*(rate))/100;
		}
		return ammount;
	}
	double getqReturns(double yearlyInvst, double rate, int time)
	{
		long ammount = 0;
		time = time*4;
		rate = rate/4;
		for(int i=0;i< time;i++)
		{
			ammount+=yearlyInvst;
			ammount += (ammount*(rate))/100;
		}
		return ammount;
	}
	double getmReturns(double monthlyInvst, double rate, int time)
	{
		long ammount = 50000;
		time = time*4;
		rate = rate/4;
		double intAmm = 0;
		double intrestQ = 0;
		for(int i=0;i< time;i++) {
			intAmm = monthlyInvst*2;
			
			intrestQ = (ammount+intAmm)*rate/100;
			ammount+=intrestQ;
			ammount += monthlyInvst*3;
			ammount += 1750;
		}
		ammount += 100000;
		return ammount;
	}
	
	double getmReturns(double money, int time)
	{
		boolean aboveOne = false;
		if(money>100000)
		{
			money-=100000;
			aboveOne = true;
		}
		time = time*4;
		for(int i=0;i<time;i++)
		{
			double intrest  = (money*1.5)/100;
			money += intrest;
			money += 1750;
		}
		return (money+100000);
		
	}
	public static void main(String[] args) {
		PF obj  = new PF();
		System.out.println(obj.getmReturns(10000.0, 6, 10)+ obj.getmReturns(200000, 1));
		
	}
}
