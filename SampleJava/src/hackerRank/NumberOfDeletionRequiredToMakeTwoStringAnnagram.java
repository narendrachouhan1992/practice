package hackerRank;

public class NumberOfDeletionRequiredToMakeTwoStringAnnagram {
	public static int numberNeeded(String first, String second) {
		int firstcount = first.length();
		int secondCount = second.length();
		int[] counter = new int[26];
		int numOfDeletion = 0;
		for(int i =0;i<firstcount;i++)
		{
			counter[first.charAt(i)-'a']++;
		}
		for(int i =0;i<secondCount;i++)
		{
			if(counter[second.charAt(i)-'a']==0)
			{
				numOfDeletion++;
			} 
			else
			{
				counter[second.charAt(i)-'a']--;
			}
		}
		numOfDeletion += firstcount - (secondCount-numOfDeletion);
		
		return numOfDeletion;     
    }
	public static void main(String[] args) {
		NumberOfDeletionRequiredToMakeTwoStringAnnagram obj = new NumberOfDeletionRequiredToMakeTwoStringAnnagram();
		System.out.println(obj.numberNeeded("cde", "abc"));
	}
}
