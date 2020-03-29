
public class SIPLiquid {
	public static void main(String[] args) {
		double sipAmm = 10000;
		double rate = 8;
		int duration = 3;
		double initial = 100000;
		double notional = initial;
		int iteration = 12*duration;
		int i=0;
		while(i<iteration)
		{
			notional+=sipAmm;
			double intrest= (notional*rate)/(100*12);
			notional+= intrest;
			i++;
		}
		
		System.out.println("SIP ammount:"+sipAmm+
				", duration:"+duration+
				", rate:"+rate+
				", invested: "+((duration*12*sipAmm)+initial)+
				", income tax: "+ ((notional-((duration*12*sipAmm)+initial))*.3)+
				", output:"+notional);
	}
}
