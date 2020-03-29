package java8test;

import java.util.ArrayList;
import java.util.List;

interface Drawable{  
    public void draw();
}  
public class LambdaExpTesting {
	public static void main(String[] args) {
		Drawable obj = () -> {	
			System.out.println("drawing");
		};		
		obj.draw();
		 List<String> list=new ArrayList<String>();  
	        list.add("ankit");  
	        list.add("mayank");  
	        list.add("irfan");  
	        list.add("jai");  
	        list.forEach((name)-> {
	        	System.out.println(name);
	        });
	}
	
}
