package test;

import java.io.*;
import java.util.Hashtable;

class Student {
	/**
	 * 
	 */
	int number;
	String name;

	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
}

public class SerializableTest {
	public static void main(String[] args) {
		ObjectOutputStream out;
		Hashtable<Integer, Integer> obj = new Hashtable<>();
		obj.put(1, 5);
		Student s1 = new Student(211, "ravi");

		FileOutputStream fout;
		try {
			fout = new FileOutputStream("f.txt");
			out = new ObjectOutputStream(fout);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("success");
	}
}
