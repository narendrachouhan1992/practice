package hackerRank;

import java.util.Arrays;

public class AutomatedGrading {
	static int[] gradingStudents(int[] grades) {
        int n = grades.length;
        for(int i=0;i<n;i++)
        {
        	if(grades[i]<38 || grades[i]%5<3)
        	{
        		continue;
        	}
        	else
        	{
        		int rem = grades[i]%5;
        		grades[i] = grades[i]+ 5-rem;
        	}
        }
        return grades;
    }
	public static void main(String[] args) {
		int[] grades = {73, 6, 38, 33}; 
		System.out.println(Arrays.toString(gradingStudents(grades)));
	}
}
