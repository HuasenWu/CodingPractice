//import java.util.Set;
import java.util.ArrayList;
public class Solution_mergeSortedArray {
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        if (A == null || A.size() == 0) {
            return B;
        }
        if (B == null || B.size() == 0) {
            return A;
        }
        ArrayList<Integer> result = new ArrayList<Integer>(A.size() + B.size());
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
            	System.out.println("In");
                result.add(A.get(i));
                i++;
            } else {
            	System.out.println("In");
                result.add(B.get(j));
                j++;
            }
        }
        if (i < A.size()) {
            for ( ; i < A.size(); i++) {
                result.add(A.get(i));
            }
        } else if (j < A.size()) {
            for ( ; j < B.size(); j++) {
                result.add(B.get(j));
            }
        }
        return result;
    }
}
