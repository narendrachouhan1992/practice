package hackerRank;

public class TimeConversion {
	static String timeConversion(String s) {
        /*
         * Write your code here.
         */
		int hour = Integer.parseInt(s.substring(0, 2));
		String sth;
		boolean isPM = "PM".equals(s.substring(8, 10));
		if(isPM)
		{
			if(hour!= 12)
			{
				hour += 12;
			}
			sth = (hour != 24 ? Integer.toString(hour) : "00");
		}
		else
		{
			sth = (hour != 12 ? Integer.toString(hour) : "00");
			
		}
		if(sth.length()== 1)
			sth = "0" + sth;
		return (sth + s.substring(2, 8));
    }
	public static void main(String[] args) {
		System.out.println(timeConversion("12:45:54PM"));
		
	}
}
