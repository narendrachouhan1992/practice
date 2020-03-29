package test;


public class Chessbord {
	double calculate(int n) {
		double sum = 0;
		for(int i=0;i<n;i++)
		{
			sum += Math.pow(2, i);
		}
		return sum;
	}
	public static void main(String[] args) {
		Chessbord obj = new Chessbord();	
		int n = 64;
		System.out.println(obj.calculate(n)* .0001);
	}
}
