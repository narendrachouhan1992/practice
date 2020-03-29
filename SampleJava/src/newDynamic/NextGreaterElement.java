package newDynamic;

import java.util.Stack;

public class NextGreaterElement {
	void printNextElement(int[] arr)
	{
		int length = arr.length;
		Stack< Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		for(int i=1;i<length;i++)
		{
			int next = arr[i];
			if(!s.isEmpty())
			{
				int element = s.pop();
				while(element<next)
				{
					System.out.println("next of " +element + " is "+ next);
					if(s.isEmpty())
					{
						break;
					}
					element = s.pop();
				}
				if(element>next)
				{
					s.push(element);
				}
			}
			s.push(next);
		}
		 while (s.isEmpty() == false) 
	        {
	            int element = s.pop();
	            int next = -1;
	            System.out.println("next of " +element + " is "+ next);
	        }
	}
	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int arr[] = { 11, 13, 21, 3 };
		obj.printNextElement(arr);
	}
	
}

