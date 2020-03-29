package newDynamic;

public class CountSumOfDigitsInNumbers {
	static double getSum(double n)
	{
		if (n<10)
		      return n*(n+1)/2;
		
		int d = ((Double)Math.log10(n)).intValue();
		
		
		double[] a = new double[d+1];
	    a[0] = 0;
	    a[1] = 45;
	    for (int i=2; i<=d; i++)
	        a[i] = a[i-1]*10 + 45*Math.ceil(Math.pow(10,i-1));
	    
	    double p = Math.ceil(Math.pow(10, d));
	    
	    double msd = n/p;
		
	    return msd*a[d] + (msd*(msd-1)/2)*p +  
	            msd*(1+n%p) + getSum(n%p);
	}
	public static void main(String[] args) {
		System.out.println(getSum(328));
	}
}
