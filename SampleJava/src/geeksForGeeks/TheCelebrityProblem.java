package geeksForGeeks;

import java.util.Stack;

public class TheCelebrityProblem {
	int findCelebrity(boolean[][] knows)  
    { 
		int n = knows.length;
        Stack<Integer> st = new Stack<>(); 
        int c; 
  
        // Step 1 :Push everybody 
        // onto stack 
        for (int i = 0; i < n; i++)  
        { 
            st.push(i); 
        } 
  
        while (st.size() > 1)  
        { 
            // Step 2 :Pop off top 
            // two persons from the  
            // stack, discard one  
            // person based on return 
            // status of knows(A, B). 
            int a = st.pop(); 
            int b = st.pop(); 
  
            // Step 3 : Push the  
            // remained person onto stack. 
            if (knows[a][b])  
            { 
                st.push(b); 
            } 
  
            else
                st.push(a); 
        } 
  
        c = st.pop(); 
  
        // Step 5 : Check if the last  
        // person is celebrity or not 
        for (int i = 0; i < n; i++)  
        { 
            // If any person doesn't 
            //  know 'c' or 'a' doesn't  
            // know any person, return -1 
            if (i != c && (knows[c][i] ||  
                          !knows[i][c])) 
                return -1; 
        } 
        return c; 
    } 
}
