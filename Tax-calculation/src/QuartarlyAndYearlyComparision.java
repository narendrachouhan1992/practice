
public class QuartarlyAndYearlyComparision {
	static double getReturnsPercentageForQuarterly(double principle, double time, double
			rate)
	{
		time = time*4;
		rate = rate/4;
		 double amount = principle * Math.pow(((100+rate)/100), time);
		 double intrest = amount - principle;
		 return ((intrest*100)/principle);
	}
	static double getReturnsPercentageForYearly(float principle, int time, float rate)
	{
		 double amount = principle * Math.pow(((100+rate)/100), time);
		 double intrest = amount - principle;
		 return ((intrest*100)/principle);
	}
	static double getEquivalentYearlyRate(float qRate, float time)
	{
		double qReturn = getReturnsPercentageForQuarterly(100, time, qRate);
		
		return (Math.pow(Math.E, (Math.log((qReturn+100)/time))) -100);
	}
	public static void main(String[] args) 
	{
		System.out.println(getReturnsPercentageForQuarterly(100, 1, 7));
		System.out.println(getReturnsPercentageForYearly(100, 1, 7));
		System.out.println(getEquivalentYearlyRate(7,5));
		System.out.println(getReturnsPercentageForQuarterly(100.0,15.0,20));
	}
}
