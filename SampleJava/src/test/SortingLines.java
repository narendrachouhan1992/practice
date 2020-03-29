package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class MyComparator implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2) {
		String[] in1 = o1.split(" ");
		String[] in2 = o2.split(" ");
		int len1 = in1.length;
		int len2 = in2.length;
		int num1 = -1;
		int num2 = -1;
		try {
			num1 = Integer.parseInt(in1[1]);
        } catch (NumberFormatException e) {
        	num1 = -1;
        }
		try {
			num2 = Integer.parseInt(in2[1]);
        } catch (NumberFormatException e) {
        	num2 = -1;
        }
		
		if(num1 == -1 && num2== -1)
		{
			int i = 1;
			while(i<len1 && i<len2 && in1[i].compareTo(in2[i]) == 0)
			{
				i++;
			}
			if(i<len1 && i<len2)
			{
				return in1[i].compareTo(in2[i]);
			}
			else
			{
				return in1[0].compareTo(in2[0]);
			}
		}
		else if(num1 != -1 && num2!= -1)
		{
			return 1;
		}
		else
		{
			if(num1 == -1 )
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	}
	
}
public class SortingLines {

	public List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
		MyComparator c = new MyComparator();
		Collections.sort(logfile, c);
		
		return logfile;
		// WRITE YOUR CODE HERE
	}
	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("a1 alps cow bar");
		str.add("mi2 jog mid pet");
		str.add("wz3 34 54 398");
		str.add("x4 45 21 7");
		
		SortingLines obj = new SortingLines();
		System.out.println(obj.reorderLines(4, str));
		
	}
}
