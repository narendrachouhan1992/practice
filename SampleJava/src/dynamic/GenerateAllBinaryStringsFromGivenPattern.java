package dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateAllBinaryStringsFromGivenPattern {
	void printAll(String str)
	{
		Queue<String> q = new LinkedList<String>();
		q.add(str);
		while(!q.isEmpty())
		{
			String temp = q.poll();
			int i;
			for(i=0;i<temp.length();i++)
			{
				if(temp.charAt(i) == '?')
				{
					temp = temp.substring(0, i) +"1" +temp.substring(i+1, temp.length());
					q.add(temp);
					temp = temp.substring(0, i) +"0" +temp.substring(i+1, temp.length());
					q.add(temp);
					break;
				}
			}
			if(i == temp.length())
			{
				System.out.println(temp);
			}
		}
	}
	public static void main(String[] args) {
		GenerateAllBinaryStringsFromGivenPattern obj = new GenerateAllBinaryStringsFromGivenPattern();
		obj.printAll("1??0?101");
	}
}
