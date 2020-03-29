package HackerRank;

import java.util.Arrays;

class TimeSlots implements Comparable<TimeSlots>
{
	int day;
	int startH;
	int endH;
	int startM;
	int endM;
	public TimeSlots(String s) {
		super();
		
		this.day = getDay(s.substring(0, 3));
		this.startH = Integer.parseInt(s.substring(4,6));
		this.endH = Integer.parseInt(s.substring(10,12));;
		this.startM = Integer.parseInt(s.substring(7,9));
		this.endM = Integer.parseInt(s.substring(13,15));
	}
	@Override
	public String toString() {
		return "TimeSlots [day=" + day + ", startH=" + startH + ", endH=" + endH + ", startM=" + startM + ", endM="
				+ endM + "]";
	}
	int getDay(String str)
	{
		switch (str) {
		case "Mon":
			return 0;
		case "Tue":
			return 1;
		case "Wed":
			return 2;
		case "Thu":
			return 3;
		case "Fri":
			return 4;
		case "Sat":
			return 5;
		case "Sun":
			return 6;


		default:
			return -1;
		}
	}
	@Override
	public int compareTo(TimeSlots o) {
		if(this.day>o.day)
			return 1;
		if(this.day<o.day)
			return -1;
		if(this.startH>o.startH)
			return 1;
		if(this.startH<o.startH)
			return -1;
		if(this.startM>o.startM)
			return 1;
		if(this.startM<o.startM)
			return -1;
		return 0;
	}
	
}
public class LongestSleepTime {
	int solution(String S)
	{
		int size = 17;
		String[] times = S.split("(?<=\\G.{" + size + "})");
		TimeSlots[] slots = new TimeSlots[times.length];
		for (int i = 0; i < slots.length; i++) {
			slots[i] = new TimeSlots(times[i]);
		}
		Arrays.sort(slots);
		int maxMins = Integer.MIN_VALUE;
		for(int i=0;i<slots.length-1;i++)
		{
			int diff = getDiff(slots[i], slots[i+1]);
			System.out.println("difference is :"+diff);
				maxMins=Integer.max(maxMins, diff);
		}
		TimeSlots t = new TimeSlots("Sun 24:00-24:00");
		maxMins = Integer.max(maxMins, getDiff(slots[slots.length-1], t));
		return maxMins;
	}
	int getDiff(TimeSlots t1, TimeSlots t2)
	{
		int d = 0;
		if(t1.day < t2.day)
		{
			d+=60-t1.endM;
			d+=(24-t1.endH-1)*60;
			d+=(t2.day-t1.day-1)*60*24;
			d+=t2.startM;
			d+= (t2.startH*60);
		} else
		{
			d+=(60*(t2.startH-t1.endH));
			d+=(t2.startM-t1.startM);
		}
		return d;
	}
	public static void main(String[] args) {
		LongestSleepTime obbj = new LongestSleepTime();
		System.out.println(obbj.solution("Mon 01:00-23:00\\nTue 01:00-23:00\\nWed 01:00-23:00\\nThu 01:00-23:00\\nFri 01:00-23:00\\nSat 01:00-23:00\\nSun 01:00-21:00"));
	
	}
}
