package newDynamic;

public class CountPossibleGroupsSize23SumMultiple3 {
	int getNumber(int[] arr)
	{
		int[] reminderArray = new int[3];
		int numberOfWays = 0;
		int size = arr.length;
		for(int i=0;i<size;i++)
		{
			reminderArray[arr[i]%3]++; 
		}
		// two with reminder zero.
		numberOfWays += (reminderArray[0]*(reminderArray[0]-1))>>1;
		
		// one deom reminder 1 and one from 2
		numberOfWays += reminderArray[1]*reminderArray[2];
		
		// all from zero
		numberOfWays+= (reminderArray[0]*(reminderArray[0]-1)*(reminderArray[0]-2))/6;
		
		//all from 1
		numberOfWays+= reminderArray[1]*(reminderArray[1]-1)*(reminderArray[1]-2)/6;
		
		// all from 2
		numberOfWays+= reminderArray[2]*(reminderArray[2]-1)*(reminderArray[2]-2)/6;
		
		numberOfWays+= reminderArray[1]*reminderArray[2]*reminderArray[2];
		return numberOfWays;
	}
	public static void main(String[] args) {
		CountPossibleGroupsSize23SumMultiple3 obj = new CountPossibleGroupsSize23SumMultiple3();
		int[] arr = {3,6,7,2,9};
		System.out.println(obj.getNumber(arr));
	}
}
