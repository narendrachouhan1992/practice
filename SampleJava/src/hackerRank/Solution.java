package hackerRank;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
	int count = 0;
    Node[] list = new Node[26];
 }
public class Solution {
	
	static Node list = new Node();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if("add".equals(op))
            {
            	addData(contact);
            }
            else
            {
            	getPartialCount(contact);
            }
        }
        in.close();
    }
    static void addData(String str)
    {
    	int length = str.length();
    	Node curr = list;
    	for(char i=0;i<length;i++)
    	{
    		if(curr==null)
    		{
    			curr= new Node();
    		}
    		if(curr.list[str.charAt(i)-'a']==null)
    		{
    			curr.list[str.charAt(i)-'a'] = new Node();
    		} 
    		curr.list[str.charAt(i)-'a'].count++;
    		curr = curr.list[str.charAt(i)-'a'];
    	}
    }
    static void getPartialCount(String str)
    {
    	int length = str.length();
    	Node curr = list;
    	for(int i =0;i<length;i++)
    	{
    		if(curr.list[str.charAt(i)-'a'] ==null)
    		{
    			System.out.println(0);
    			return;		
    		}
    		curr = curr.list[str.charAt(i)-'a'];
    	}
    	System.out.println(curr.count);
    }
}