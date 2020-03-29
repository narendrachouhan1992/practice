
public class GDPIndia {
	float CURRENT = 2.848f;
	int year = 2018;
	float rate = 7.5f;
	float rate2 = 10;
	
	void printGDP()
	{
		float gdph = CURRENT;
		float gdpl = CURRENT;
		for(int i=0;i<14;i++)
		{
			
			System.out.println("GDP in "+ (year+i) + " at 7.5 is "+ gdpl + ". at 8 is "+ gdph);
			gdph *= (1+ rate2/100);
			gdpl *= (1+ rate/100);
		}
	}
	public static void main(String[] args) {
		GDPIndia obj = new GDPIndia();
		obj.printGDP();
	}
}
