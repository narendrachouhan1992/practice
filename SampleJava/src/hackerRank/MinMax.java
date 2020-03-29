package hackerRank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMax {
//	 static int countSpecialElements(List<List<Integer>> matrix) {
//		 List<Integer> maxRow = new ArrayList<Integer>();
//		 List<Integer> minRow = new ArrayList<Integer>();
//		 List<Integer> maxCol = new ArrayList<Integer>();
//		 List<Integer> minCol = new ArrayList<Integer>();
//		 if(matrix.size() == 0)
//			 return 0;
//		 if(matrix.get(0).size() == 0)
//	        {
//	            return 0;
//	        }
//		 for(int i=0;i<matrix.size();i++)
//		 {
//			 for(int j=0;j<matrix.get(0).size();j++)
//			 {
//				 if(maxRow.size()<= i)
//				 {
//					 maxRow.add(matrix.get(i).get(j));
//				 }
//				 else if(maxRow.get(i)<matrix.get(i).get(j))
//				 {
//					 maxRow.set(i, matrix.get(i).get(j));
//				 }
//				 
//				 if(minRow.size()<= i)
//				 {
//					 minRow.add(matrix.get(i).get(j));
//				 }
//				 else if(minRow.get(i)>matrix.get(i).get(j))
//				 {
//					 minRow.set(i, matrix.get(i).get(j));
//				 }
//				 
//				 if(maxCol.size()<= j)
//				 {
//					 maxCol.add(matrix.get(i).get(j));
//				 }
//				 else if(maxCol.get(j)<matrix.get(i).get(j))
//				 {
//					 maxCol.set(j, matrix.get(i).get(j));
//				 }
//				 
//				 if(minCol.size()<= j)
//				 {
//					 minCol.add(matrix.get(i).get(j));
//				 }
//				 else if(minCol.get(j)>matrix.get(i).get(j))
//				 {
//					 minCol.set(j, matrix.get(i).get(j));
//				 }
//			 }
//		 }
//		 Set<Integer> set = new HashSet<Integer>();
//		 for(int i=0;i<matrix.size();i++)
//		 {
//			 for(int j=0;j<matrix.get(0).size();j++)
//			 {
//				if(minRow.get(i) == matrix.get(i).get(j) || minCol.get(j) == matrix.get(i).get(j) || maxRow.get(i) == matrix.get(i).get(j) || maxCol.get(j) == matrix.get(i).get(j))
//				{
//					set.add(matrix.get(i).get(j));
//				}
//			 }
//		 }
//		 return set.size();
//    }
//	 
//	 
	 
	 
	 
	 static int countSpecialElements(List<List<Integer>> matrix) {
		 if(matrix.size() == 0)
             return 0;
        if(matrix.get(0).size() == 0)
        {
            return 0;
        }
         List<Integer> maxRow = new ArrayList<Integer>();
         List<Integer> minRow = new ArrayList<Integer>();
         List<Integer> maxCol = new ArrayList<Integer>();
         List<Integer> minCol = new ArrayList<Integer>();
         for(int i=0;i<matrix.size();i++)
         {
             for(int j=0;j<matrix.get(0).size();j++)
             {
                 if(maxRow.size()<= i)
                 {
                     maxRow.add(matrix.get(i).get(j));
                 }
                 else if(maxRow.get(i)<matrix.get(i).get(j))
                 {
                     maxRow.set(i, matrix.get(i).get(j));
                 }
                 else if(maxRow.get(i) == matrix.get(i).get(j))
                 {
                	return -1;
                 }
                 
                 if(minRow.size()<= i)
                 {
                     minRow.add(matrix.get(i).get(j));
                 }
                 else if(minRow.get(i)>matrix.get(i).get(j))
                 {
                     minRow.set(i, matrix.get(i).get(j));
                 }
                 else if(minRow.get(i) == matrix.get(i).get(j))
                 {
                     return -1;
                 }
                 
                 if(maxCol.size()<= j)
                 {
                     maxCol.add(matrix.get(i).get(j));
                 }
                 else if(maxCol.get(j)<matrix.get(i).get(j))
                 {
                     maxCol.set(j, matrix.get(i).get(j));
                 }
                 else if(maxCol.get(j) == matrix.get(i).get(j))
                 {
                     return -1;
                 }
                 
                 if(minCol.size()<= j)
                 {
                     minCol.add(matrix.get(i).get(j));
                 }
                 else if(minCol.get(j)>matrix.get(i).get(j))
                 {
                     minCol.set(j, matrix.get(i).get(j));
                 }
                 else if(minCol.get(j) == matrix.get(i).get(j))
                 {
                     return -1;
                 }
             }
         }
         int count = 0;
         for(int i=0;i<matrix.size();i++)
         {
             for(int j=0;j<matrix.get(0).size();j++)
             {
                if(minRow.get(i) == matrix.get(i).get(j) || minCol.get(j) == matrix.get(i).get(j) || maxRow.get(i) == matrix.get(i).get(j) || maxCol.get(j) == matrix.get(i).get(j))
                {
                    count++;
                }
             }
         }
         return count;
    }
	 public static void main(String[] args) {
		 List<Integer> ls1 = new ArrayList<>();
		 ls1.add(1);
		 ls1.add(3);
		 ls1.add(4);
		 List<Integer> ls2 = new ArrayList<>();
		 ls2.add(5);
		 ls2.add(2);
		 ls2.add(9);
		 List<Integer> ls3 = new ArrayList<>();
		 ls3.add(8);
		 ls3.add(7);
		 ls3.add(6);
		List<List<Integer>> l = new ArrayList<>();
		l.add(ls1);
		l.add(ls2);
		l.add(ls3);
		System.out.println(countSpecialElements(l));
		
	}
}
