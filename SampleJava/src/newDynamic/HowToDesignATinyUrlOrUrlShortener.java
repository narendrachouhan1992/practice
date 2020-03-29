package newDynamic;

import java.util.Arrays;

public class HowToDesignATinyUrlOrUrlShortener {
	String idToShortURL(long n)
	{
	    // Map to store 62 possible characters
	    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	 
	    String shorturl = "";
	    
	    // Convert given integer id to a base 62 number
	    while (n!= 0)
	    {
	        // use above map to store actual character
	        // in short url
	    	int rem = (int) (n%62);
	        shorturl+= Character.toString(map[rem]);
	        n = n/62;
	    }
	    char[] su = shorturl.toCharArray();
	    // Reverse shortURL to complete base conversion
	   for(int i=0;i<su.length/2;i++)
	   {
		   char temp = su[i];
		   su[i] = su[su.length-i-1];
		   su[su.length-i-1] = temp;
		   
	   }
	    return Arrays.toString(su);

	}
	long shortURLtoID(String shortURL)
	{
	    long id = 0; // initialize result
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length(); i++)
	    {
	        if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
	          id = id*62 + shortURL.charAt(i) - 'a';
	        if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
	          id = id*62 + shortURL.charAt(i) - 'A' + 26;
	        if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
	          id = id*62 + shortURL.charAt(i) - '0' + 52;
	    }
	    return id;
	}
	public static void main(String[] args) {
		HowToDesignATinyUrlOrUrlShortener obj = new HowToDesignATinyUrlOrUrlShortener();
		 int n = 12345;
		 System.out.println("number "+ n+ " to id "+obj.idToShortURL(n));
		 System.out.println("id "+ obj.idToShortURL(n)+ " to number "+obj.shortURLtoID("brcrc"));
	}
}
