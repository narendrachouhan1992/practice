package newDynamic;

import java.util.HashMap;
import java.util.Map;

class Pairs
{
	int a;
	int b;
	public Pairs(int a , int b) {
		this.a = a;
		this.b = b;
	}
}
public class FindFourElementsABCAndDInAnArraySuchThatAbCd {
	void printPairs(int[] numbers)
	{
		int length = numbers.length;
		Map<Integer,Pairs> map = new HashMap<>();
		for(int i =0;i<length;i++)
		{
			for(int j = i+1;j<length;j++)
			{
				if(map.containsKey(numbers[i]+ numbers[j]))
				{
					System.out.println(numbers[i]+" "+ numbers[j] + " " + map.get(numbers[i]+ numbers[j]).a +" "+ map.get(numbers[i]+ numbers[j]).b);
				}
				else
				{
					map.put(numbers[i]+ numbers[j], new Pairs(numbers[i], numbers[j]));
				}
			}
		}
	}
	public static void main(String[] args) {
		FindFourElementsABCAndDInAnArraySuchThatAbCd obj = new FindFourElementsABCAndDInAnArraySuchThatAbCd();
		int arr[] = {3, 4, 7, 1, 2, 9, 8};
		obj.printPairs(arr);
	}
}
