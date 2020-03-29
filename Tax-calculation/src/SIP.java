
public class SIP {
	static double currBalance=520000;
	static float rate = 10;
	static int time = 3;
	static void calculateTotalSithSIP(double sip)
	{
		float time_t=time*12;
		float rate_t=rate/12;
		double curr_sum = currBalance;
		
		for(int i=0;i<time_t;i++)
		{
			curr_sum+=sip;
			curr_sum+=curr_sum*rate_t/100;
		}
		System.out.println("final sum after 3 years with sip ammount :"+sip+" is :"+curr_sum);
	}
	public static void main(String[] args) {
		calculateTotalSithSIP(22000);
	}
	
}
