package newDynamic;

import java.util.Arrays;
import java.util.Comparator;

class Interval
{
	int start;
	int end;
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	 
}
class MyComparator1 implements Comparator<Interval>
{

	@Override
	public int compare(Interval o1, Interval o2) {
		return (o1.start - o2.start);
	}
	
}
public class MergingIntervals {
	void getMergedIntervals(Interval[] arr)
	{
		int length = arr.length;
		int index = 0;
		MyComparator1 c = new MyComparator1();
		Arrays.sort(arr, c);
		for(int i=1;i<length; i++)
		{
			if(arr[index].end>arr[i].start)
			{
				arr[index].end = Integer.max(arr[index].end, arr[i].end);
				arr[index].start = Integer.min(arr[index].start, arr[i].start);
			}
			else
			{
				arr[index++] = arr[i];
			}
		}
		
		for(int i=0;i<=index;i++)
		{
			System.out.println(arr[i].start + " "+ arr[i].end);
		}
	}
	public static void main(String[] args) {
		MergingIntervals obj = new MergingIntervals();
		Interval[] arr =  { new Interval(6,8),  new Interval(1,9), new Interval(2,4), new Interval(4,7) };
		obj.getMergedIntervals(arr);
	}
}
