import java.util.*;
public class Solution_permute {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return results;
        }
        ArrayList<Integer> perm = new ArrayList<Integer>();
        helper(nums, perm, results);
        return results;
    }
    private void helper(ArrayList<Integer> nums, ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> results) {
        if (perm.size() == nums.size()) {
            results.add(new ArrayList<Integer>(perm));
            return;
        } 
        for (int i = 0; i < nums.size(); i++) {
            if (perm.contains(nums.get(i))) {
                continue;
            }
            perm.add(nums.get(i));
            helper(nums, perm, results);
            perm.remove(perm.size() - 1);
        }
    }
}
