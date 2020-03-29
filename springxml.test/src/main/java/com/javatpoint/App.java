package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatpoint.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
    	context = new ClassPathXmlApplicationContext("spring/config/applicationContext.xml");
    	Student st = (Student) context.getBean("studentbean");
        System.out.println( "Hello World!" );
        System.out.println(st.getName());
        System.out.println(st.getGender());
    }
}
