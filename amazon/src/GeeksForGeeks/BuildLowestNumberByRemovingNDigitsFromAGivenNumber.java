package GeeksForGeeks;

public class BuildLowestNumberByRemovingNDigitsFromAGivenNumber {
	static String res = "";
	static void printSmallest(String str, int n)
	{
		 // If there are 0 characters to remove from str, 
        // append everything to result 
        if (n == 0)  
        { 
            res.concat(str); 
            return; 
        } 
  
        int len = str.length(); 
  
        // If there are more characters to  
        // remove than string length,  
        // then append nothing to result 
        if (len <= n) 
            return; 
  
        // Find the smallest character among  
        // first (n+1) characters of str. 
        int minIndex = 0; 
        for (int i = 1; i <= n; i++) 
            if (str.charAt(i) < str.charAt(minIndex)) 
                minIndex = i; 
  
        // Append the smallest character to result 
        res += str.charAt(minIndex); 
  
        // substring starting from  
        // minIndex+1 to str.length() - 1. 
        String new_str = str.substring(minIndex + 1); 
  
        // Recur for the above substring  
        // and n equals to n-minIndex 
        printSmallest(new_str, n - minIndex); 
	}
	public static void main(String[] args) {
		String str = "121198";
		printSmallest(str, 2);
		System.out.println(res);
	}
}
