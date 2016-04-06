import java.util.*;
public class Solution_updateBits {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
    	int mask;
    	if (j < 31) {
    		mask = ~((1 << (j + 1)) - (1 << i));
    		System.out.println(Integer.toBinaryString(mask));
    	} else {
    		mask = (1 << i) - 1;
    	}
    	return (m << i) | (mask & n);
    }
}