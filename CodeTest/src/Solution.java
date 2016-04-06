import java.util.*;
public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            gas[i] -= cost[i]; // per point remaining gas
        }
        int sum = 0;
        int max_val = Integer.MIN_VALUE;
        int max_ind = -1;
        for (int i = 0; i < len; i++) {
            sum += gas[i];
            if (gas[i] > max_val) {
                max_val = gas[i];
                max_ind = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        boolean flag = true;
        sum = 0;
        for (int i = 0; i < len; i++) {
            int ind = (max_ind + i) % len;
        	if (ind < 0) {
        		ind += len;
        	}
            sum += gas[ind];
            if (sum < 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return max_ind;
        }
        sum = 0;
        flag = true;
        for (int i = 0; i < len; i++) {
            int ind = (max_ind - i) % len;
        	if (ind < 0) {
        		ind += len;
        	}
            sum += gas[ind];
            System.out.println(ind);
            if (sum < 0) {
            	
                return -1;
            }
        }
        
        if (flag) {
            return max_ind;
        }
        
        return max_ind;
    }
}