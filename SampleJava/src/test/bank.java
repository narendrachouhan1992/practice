package test;

public class bank {
	double calculate(int year, double rate, double monthly) {
		year = year *4;
		rate = rate/4;
		double total = 0;
		for(int i=0;i<year;i++)
		{
			total += monthly*2;
			total += total* rate/100;
			total += monthly;
		}
		return total;
	}
	public static void main(String[] args) {
		bank obj = new bank();
//		System.out.println(obj.calculate(20,8.0,16977));     saving with intrest 8
//		System.out.println(obj.calculate(18,12.0,14000));    mutual 
		System.out.println(obj.calculate(1, 10.0, 1000));
	}
}
