package HackerRank;

public class ApendAndDelete {
	static String appendAndDelete(String s, String t, int k) {
		int commonLength = 0;
        
        for (int i=0; i<java.lang.Math.min(s.length(),t.length());i++){
            if (s.charAt(i)==t.charAt(i))
                commonLength++;
            else
                break;
        }
//CASE A
        if((s.length()+t.length()-2*commonLength)>k){
            return "No";
        }
//CASE B
        else if((s.length()+t.length()-2*commonLength)%2==k%2){
        	return "Yes";
        }
//CASE C
        else if((s.length()+t.length()-k)<0){
            return "Yes";
        }
//CASE D
        else{
            return "No";
        }
    }
//	CASE A:
//
//		What this case is finding is if k is bigger than the difference in length of the two strings.
//
//		example: s = "123456789", t = "1", k = 5
//
//		in this case, you definitely need a bigger k to transform s to t or vice versa, therefore you reject any such cases.
//
//		Case B:
//
//		now that the case has passed A, we can say that the total number of letters required to change is less than or equal to k.
//
//		however the next problem comes because the question specified that exactly k moves must be done, no more no less. this leads to an example whereby:
//
//		s = "010101", t = "01010", k = any EVEN number
//
//		OR
//
//		s = "010101", t = "010101", k = any ODD number
//
//		from these two examples you can see that only if k is odd/even matches the odd/even of number of different digits will such cases pass.
//
//		Case C:
//
//		However there is a way to overcome this odd/even problem if you are able to completely delete away one string as a deletion action on an empty string results in another empty string.
//
//		Example: s = '1' t = '101' k = 5
//
//		in this case, to get a S from T you could do delete-delete-delete-delete-add(1) and you will satisfy the condition.
//
//		Case D:
//
//		all other cases will fail the test
//
//		Hope i helped
}
