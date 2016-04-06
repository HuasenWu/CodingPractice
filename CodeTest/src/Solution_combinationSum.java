import java.util.*;
public class Solution_combinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return res;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<Integer>();
        combinationSumHelper(res, candidates, target, path, 0);
        return res;
    }
    private void combinationSumHelper(List<List<Integer>> res, int[] candidates, 
                                           int target, ArrayList<Integer> path, int start) {
    	if (target == 0) {
    		res.add(new ArrayList<Integer>(path)); 
        	return;
    	}
    	int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
            	break;
            }
            if (prev != -1 && prev == candidates[i]) {
            	continue;
            }
            path.add(candidates[i]); 
            combinationSumHelper(res, candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
            prev = candidates[i];
        }
    }
}
